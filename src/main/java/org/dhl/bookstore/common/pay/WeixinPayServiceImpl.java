package org.dhl.bookstore.pay;

import org.dhl.bookstore.model.entity.Orders;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.dhl.bookstore.common.utils.HttpClientUtils;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: Darryl
 * Desc:
 * File created at 2020-6-3
 */
@Component
@PropertySource(value = "classpath:weixinpay.properties",encoding = "utf-8")
public class WeixinPayServiceImpl implements WeixinPayService {
    /** 微信公众号 */
    @Value("${appidwx}")
    private String appidWX;
    /** 商户账号 */
    @Value("${partner}")
    private String partner;
    /** 商户密钥 */
    @Value("${partnerkey}")
    private String partnerkey;
    /** 统一下单请求地址 */
    @Value("${unifiedorder}")
    private String unifiedorder;
    /**
     * 生成微信支付二维码
     * @return 集合
     */
    public Map<String, String> genPayCode(PayContext payContext){
        Orders orders = payContext.getOrders();
        /** 创建Map集合封装请求参数 */
        Map<String, String> param = new HashMap<>();
        /** 公众号 */
        param.put("appid", appidWX);
        /** 商户号 */
        param.put("mch_id", partner);
        /** 随机字符串 */
        param.put("nonce_str", WXPayUtil.generateNonceStr());
        /** 商品描述 */
        param.put("body", payContext.getBookInfos().get(0).getName());
        /** 商户订单交易号 */
        param.put("out_trade_no", orders.getOrderId());
        /** 总金额（分） */
        param.put("total_fee",new BigDecimal(orders.getPayment()).multiply(new BigDecimal("100")).setScale(0).toString());
        /** IP地址 */
        param.put("spbill_create_ip", "127.0.0.1");
        /** 回调地址(随意写) */
        param.put("notify_url", "https://shop243665397.taobao.com");
        /** 交易类型 */
        param.put("trade_type", "NATIVE");
        try {
            /** 根据商户密钥签名生成XML格式请求参数 */
            String xmlParam = WXPayUtil.generateSignedXml(param, partnerkey);
            System.out.println("请求参数：" + xmlParam);
            /** 创建HttpClientUtils对象发送请求 */
            HttpClientUtils client = new HttpClientUtils(true);
            /** 发送请求，得到响应数据 */
            String result = client.sendPost(unifiedorder, xmlParam);
            System.out.println("响应数据：" + result);
            /** 将响应数据XML格式转化成Map集合 */
            Map<String,String> resultMap = WXPayUtil.xmlToMap(result);
            /** 创建Map集合封装返回数据 */
            Map<String,String> data = new HashMap<>();
            /** 支付地址(二维码中的URL) */
            data.put("codeUrl", resultMap.get("code_url"));
            /** 总金额 */
            data.put("totalFee", orders.getPayment());
            /** 订单交易号 */
            data.put("outTradeNo", orders.getOrderId());
            data.put("description",payContext.getBookInfos().get(0).getName());
            return data;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}