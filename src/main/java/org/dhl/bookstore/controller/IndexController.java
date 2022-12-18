package org.dhl.bookstore.web.controller;


import org.dhl.bookstore.crawl.URLEntity;
import org.dhl.bookstore.crawl.WriteToMysql;
import org.dhl.bookstore.model.entity.BookCategory;
import org.dhl.bookstore.model.entity.BookInfo;
import org.dhl.bookstore.model.service.IBookCateService;
import org.dhl.bookstore.model.service.IBookInfoService;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Random;

@Controller
public class IndexController {

    @Autowired
    private IBookInfoService bookInfoService;

    @Autowired
    private IBookCateService cateService;

    @Autowired
    private WriteToMysql writeToMysql;

    @Value("${book.category}")
    private String BOOK_CATEGORY;

    private List<BookCategory> categoryList;


    /**
     * 第一次访问首页首页
     *
     * @return
     */
    @RequestMapping({"", "/", "/index"})
    public String index(Model model) {
        if(categoryList == null){
            categoryList = cateService.getCategoryList();
        }
        //获得书籍列表
        //首页好书推荐的展示，随机展示
        List<BookInfo> bookInfos = bookInfoService.findBookListByCateId(categoryList.get(new Random().nextInt(6)).getCateId(), new Random().nextInt(3), 18);
        model.addAttribute("bookInfos", bookInfos);

        return "index";
    }


    /**
     * 点击首页导航栏分类后来到这个handler
     *
     * @param cateId
     * @param model
     * @return
     */
    @RequestMapping("/index/category/{cateId}")
    public String bookListByCategoryId(@PathVariable("cateId") int cateId, Model model) {
        //通过cateid查找书籍并返回到前端
        List<BookInfo> bookInfos = bookInfoService.findBookListByCateId(cateId, new Random().nextInt(3), 18);
        model.addAttribute("bookInfos", bookInfos);
        model.addAttribute("cateId", cateId);
        return "index";
    }

    /**
     * 爬取当当网书籍列表数据，并将数据插入到本地mysql数据库中
     *
     * @param url
     * @throws IOException
     * @throws ParseException
     * @throws SQLException
     */
    @PostMapping("/write")
    public void write(String url) throws IOException, ParseException, SQLException {
        HttpClient httpclient = new DefaultHttpClient(); //创建HttpClient
        //先去书籍列表页列表页
        List<BookInfo> books = URLEntity.URLParse(httpclient, url, BOOK_CATEGORY); //通过URLEntity获取实体中的信息
        //mysql_control.executeInsert(books);  //数据库添加数据

        writeToMysql.executeInsert(books);
    }
}
