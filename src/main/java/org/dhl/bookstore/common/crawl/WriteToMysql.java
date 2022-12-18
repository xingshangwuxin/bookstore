package org.dhl.bookstore.crawl;

import org.dhl.bookstore.model.dao.BookInfoMapper;
import org.dhl.bookstore.model.entity.BookInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;

@Component
public class WriteToMysql {

    @Autowired
    private BookInfoMapper bookInfoMapper;
        //插入多条书籍信息
    public void executeInsert(List<BookInfo> bookdatas) throws SQLException
    {
        long start = System.currentTimeMillis() / 1000;
        System.out.println(start);
        for (BookInfo bookdata : bookdatas) {
            bookInfoMapper.insert(bookdata);
        }

        System.out.println("成功插入" + bookdatas.size() + "条");
        System.out.println(System.currentTimeMillis() / 1000);
        System.out.println(System.currentTimeMillis() / 1000 - start);
    }

}
