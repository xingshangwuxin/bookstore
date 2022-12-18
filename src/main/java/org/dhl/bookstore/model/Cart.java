package org.dhl.bookstore.model.entity.custom;

import java.util.HashMap;
import java.util.Map;

/**
 * 购物车实体类
 */
public class Cart {

        //购物车中的商品以哈希map给出
    private Map<Integer,CartItem> cartItems = new HashMap<>();

    //总数
    private double total;

    public Map<Integer, CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(Map<Integer, CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
