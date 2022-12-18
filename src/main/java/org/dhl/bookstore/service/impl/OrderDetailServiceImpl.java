package org.dhl.bookstore.model.service.impl;

import org.dhl.bookstore.model.dao.BookInfoMapper;
import org.dhl.bookstore.model.dao.OrderDetailMapper;
import org.dhl.bookstore.model.entity.BookInfo;
import org.dhl.bookstore.model.entity.OrderDetail;
import org.dhl.bookstore.model.service.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderDetailServiceImpl implements IOrderDetailService {

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Autowired
    private BookInfoMapper bookInfoMapper;

    @Override
    public List<BookInfo> findBooksByOrderId(String orderId) {

        Example example = new Example(OrderDetail.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("orderId", orderId);
        List<OrderDetail> orderDetails = orderDetailMapper.selectByExample(example);

        List<BookInfo> bookInfos = orderDetails.stream()
                .map(orderDetail -> bookInfoMapper.selectByPrimaryKey(orderDetail.getBookId()))
                .collect(Collectors.toList());

        return bookInfos;
    }

}
