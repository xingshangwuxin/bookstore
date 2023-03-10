package org.dhl.bookstore.model.service;

import org.dhl.bookstore.common.pojo.BSResult;
import org.dhl.bookstore.model.entity.custom.Cart;
import org.dhl.bookstore.model.entity.User;
import org.dhl.bookstore.model.entity.custom.OrderCustom;
import org.dhl.bookstore.pay.PayContext;

import java.util.List;

public interface IOrderService {

    List<OrderCustom> findOrdersByUserId(int userId);

    List<OrderCustom> findOrdersByStoreId(int storeId);

    BSResult createOrder(Cart cart, User user, String express, int payMethod);

    BSResult findOrderById(String orderId);

    BSResult deleteOrder(String orderId);

    void updateOrderAfterPay(PayContext payContext);

    BSResult postOrder(String orderId);

    OrderCustom findOrderCustomById(String orderId);

    BSResult updateOrder(OrderCustom orderCustom);

    BSResult confirmReceiving(String orderId);
}
