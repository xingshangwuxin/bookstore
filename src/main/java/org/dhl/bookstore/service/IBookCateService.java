package org.dhl.bookstore.model.service;

import org.dhl.bookstore.model.entity.BookCategory;

import java.util.List;

public interface IBookCateService {
    List<BookCategory> getCategoryList();
}
