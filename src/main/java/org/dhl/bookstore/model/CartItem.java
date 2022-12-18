package org.dhl.bookstore.model.entity.custom;

import org.dhl.bookstore.model.entity.BookInfo;

/**
 * 购物项
 */
public class CartItem {

    //book信息
    private BookInfo bookInfo;

    //这本书的总金额
    private double subTotal;

    //购买数量
    private int buyNum;


    private boolean checked = true;

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public BookInfo getBookInfo() {
        return bookInfo;
    }

    public void setBookInfo(BookInfo bookInfo) {
        this.bookInfo = bookInfo;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public int getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(int buyNum) {
        this.buyNum = buyNum;
    }
}
