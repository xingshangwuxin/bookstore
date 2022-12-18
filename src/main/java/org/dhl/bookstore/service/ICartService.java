package org.dhl.bookstore.model.service;

import org.dhl.bookstore.common.pojo.BSResult;
import org.dhl.bookstore.model.entity.BookInfo;
import org.dhl.bookstore.model.entity.custom.Cart;

import javax.servlet.http.HttpServletRequest;

public interface ICartService {

    BSResult addToCart(BookInfo bookInfo, Cart cart, int buyNum);

    BSResult clearCart(HttpServletRequest request,String sessionName);

    BSResult deleteCartItem(int bookId, HttpServletRequest request);

    BSResult updateBuyNum(int bookId, int newNum, HttpServletRequest request);

    BSResult checkedOrNot(Cart cart,int bookId);

}
