package org.dhl.bookstore.pay;


import org.dhl.bookstore.common.pojo.BSResult;
import org.dhl.bookstore.common.utils.BSResultUtil;

public abstract class AbstractPay implements IPayService {

    @Override
    public BSResult pay(PayContext payContext) throws Exception {
        prepareAndPay(payContext);
        afterPay(payContext);
        return BSResultUtil.success();
    }


}
