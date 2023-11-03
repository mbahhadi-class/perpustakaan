package id.starter.perustakaan.service;

import id.starter.perustakaan.dao.BaseDao;
import id.starter.perustakaan.dao.BookDao;
import id.starter.perustakaan.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author "Noverry Ambo"
 * @start 11/1/2023
 */
@Service
public class BookService extends BaseService<Book> {
    @Autowired
    private BookDao dao;

    @Override
    protected BaseDao<Book> getDAO() {
        return dao;
    }
}
