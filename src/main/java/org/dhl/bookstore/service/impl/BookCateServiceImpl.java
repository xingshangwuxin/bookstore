package org.dhl.bookstore.model.service.impl;

import org.dhl.bookstore.model.dao.BookCategoryMapper;
import org.dhl.bookstore.model.entity.BookCategory;
import org.dhl.bookstore.model.service.IBookCateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 书籍分类服务
 */
@Service
public class BookCateServiceImpl implements IBookCateService {


    @Autowired
    private BookCategoryMapper bookCategoryMapper;


        //返回所有的categories分类
    @Override
    public List<BookCategory> getCategoryList() {
        return bookCategoryMapper.selectAll();
    }
}
