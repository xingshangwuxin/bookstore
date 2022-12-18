package org.dhl.bookstore.pay;

import java.util.Map;

public interface WeixinPayService {
    /**
     * 生成微信支付二维码
     * @return Map集合
     */
    Map<String, String> genPayCode(PayContext payContext);
}
