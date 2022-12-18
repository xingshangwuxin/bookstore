package org.dhl.bookstore.model.service;

import com.github.pagehelper.PageInfo;
import org.dhl.bookstore.common.pojo.BSResult;
import org.dhl.bookstore.common.pojo.Bar;
import org.dhl.bookstore.common.pojo.Pie;
import org.dhl.bookstore.exception.BSException;
import org.dhl.bookstore.model.entity.BookInfo;

import java.util.List;

    //定义书籍相关方法
public interface IBookInfoService {

        //通过cateId找到book列表
    List<BookInfo> findBookListByCateId(int cateId, int currentPage, int pageSize);

    BookInfo findById(Integer bookId) throws BSException;

    PageInfo<BookInfo> findBookListByCondition(String keywords, int cateId, int page, int pageSize,int storeId);

    BookInfo queryBookAvailable(int bookId);

    BSResult saveBook(BookInfo bookInfo,String bookDescStr);

    BSResult updateBook(BookInfo bookInfo, String bookDesc);

    BSResult changeShelfStatus(int bookId,int shelf);

    BookInfo adminFindById(int bookId) throws BSException;

    BSResult deleteBook(int bookId);

    int addLookMount(BookInfo bookInfo);

    List<Pie> getBookViewsPiesByStoreId(Integer storeId);

    Bar getBookSalesBarJson(Integer storeId);
}
