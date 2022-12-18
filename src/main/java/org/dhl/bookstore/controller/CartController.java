package org.dhl.bookstore.web.controller;

import org.dhl.bookstore.model.entity.BookInfo;
import org.dhl.bookstore.model.entity.custom.Cart;
import org.dhl.bookstore.model.service.IBookInfoService;
import org.dhl.bookstore.common.pojo.BSResult;
import org.dhl.bookstore.model.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private IBookInfoService bookInfoService;

    @Autowired
    private ICartService cartService;

    //返回购物车页面
    @GetMapping("/items")
    public String showCart() {
        return "cart";
    }

    /**
     * 加入购物车
     *
     * @param bookId
     * @param request
     * @return
     */
    @RequestMapping("/addition")
    public String addToCart(@RequestParam(value = "bookId",defaultValue = "0") int bookId,
                            @RequestParam(required = false,defaultValue = "0") int buyNum,
                            HttpServletRequest request) {
        //从session中拿到cart购物车，如果没有则证明之前没有生成cart对象，则会在cartService.addToCart中生成
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        //根据要加入购物车的bookId查询bookInfo，得到它
        BookInfo bookInfo = bookInfoService.queryBookAvailable(bookId);

        if (bookInfo != null) {
            //这本书在数据库里
            BSResult bsResult = cartService.addToCart(bookInfo, cart, buyNum);
            request.getSession().setAttribute("cart", bsResult.getData());
            request.setAttribute("bookInfo", bookInfo);
        } else {
            //数据库里没有这本书
            request.setAttribute("bookInfo", null);
        }
        return "addcart";
    }

        //清空购物车
    @GetMapping("/clear")
    public String clearCart(HttpServletRequest request) {
        cartService.clearCart(request,"cart");
        return "cart";
    }

        //点击删除按钮清空选择的图书items，
    @GetMapping("/deletion/{bookId}")
    public String deleteCartItem(@PathVariable("bookId") int bookId,HttpServletRequest request){
        cartService.deleteCartItem(bookId, request);
        return "redirect:/cart/items";
    }

    /**
     * 更新某个购物车项的购买数量
     * @param bookId
     * @param newNum
     * @param request
     * @return
     */
    @PostMapping("/buy/num/update")
    @ResponseBody
    public BSResult updateBuyNum(int bookId, int newNum, HttpServletRequest request){
        return cartService.updateBuyNum(bookId, newNum, request);
    }

    @PostMapping("/checkOne")
    @ResponseBody
    public BSResult checkACartItem(int bookId,HttpServletRequest request){
        Cart cart = (Cart)request.getSession().getAttribute("cart");
        return cartService.checkedOrNot(cart, bookId);
    }
}
