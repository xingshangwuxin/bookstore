package org.dhl.bookstore.model.service;

import org.dhl.bookstore.model.entity.BookInfo;

import java.util.List;

public interface IOrderDetailService {

    List<BookInfo> findBooksByOrderId(String orderId);
}
