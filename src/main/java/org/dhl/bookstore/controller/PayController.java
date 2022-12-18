package org.dhl.bookstore.web.controller;

import org.dhl.bookstore.model.entity.BookInfo;
import org.dhl.bookstore.model.entity.Orders;
import org.dhl.bookstore.model.service.IOrderDetailService;
import org.dhl.bookstore.model.service.IOrderService;
import org.dhl.bookstore.common.pojo.BSResult;
import org.dhl.bookstore.common.pojo.PayMethod;
import org.dhl.bookstore.pay.Alipay;
import org.dhl.bookstore.pay.PayContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.dhl.bookstore.pay.WeixinPayServiceImpl;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/payment")
public class PayController {

    @Autowired
    private Alipay alipay;
    @Autowired
    private WeixinPayServiceImpl weixinPayService;

    @Autowired
    private IOrderService orderService;

    @Autowired
    private IOrderDetailService orderDetailService;

    @RequestMapping("/{orderId}/{payMethod}")
    public String paymentPage(@PathVariable("orderId") String orderId,@PathVariable("payMethod") int payMethod, HttpServletResponse response, Model model){

        System.out.println(payMethod);
        BSResult bsResult = orderService.findOrderById(orderId);
        Orders order = (Orders)bsResult.getData();

        List<BookInfo> books = orderDetailService.findBooksByOrderId(order.getOrderId());

        PayContext payContext = new PayContext();
        payContext.setResponse(response);
        payContext.setOrders(order);
        payContext.setBookInfos(books);

        try {
            if (payMethod==PayMethod.WEIXIN.value()){
                Map<String, String> genPayCode = weixinPayService.genPayCode(payContext);
                model.addAttribute("genPayCode",genPayCode);
                return "weixin_pay";
            }else if (payMethod==PayMethod.ZHIFUBAO.value()){
                alipay.pay(payContext);

            }

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("exception", "支付出错了!");
            return "exception";
        }
        return "pay_success";
    }

    @RequestMapping("/return")
    public String returnUrl(String out_trade_no,String total_amount,String body,
                            Model model){

        model.addAttribute("body", body);
        model.addAttribute("total_amount", total_amount);


        BSResult bsResult = orderService.findOrderById(out_trade_no);
        Orders order = (Orders)bsResult.getData();

        List<BookInfo> books = orderDetailService.findBooksByOrderId(order.getOrderId());

        PayContext payContext = new PayContext();
        payContext.setOrders(order);
        payContext.setBookInfos(books);

        orderService.updateOrderAfterPay(payContext);


        return "pay_success";
    }

    @RequestMapping("/notify")
    public void notifyUrl(){

        System.out.println("notify--------------------------");



    }

}
