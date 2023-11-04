package id.starter.perustakaan.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import id.starter.perustakaan.common.RestResult;
import id.starter.perustakaan.common.StatusCode;
import id.starter.perustakaan.entity.Book;
import id.starter.perustakaan.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * @Author "Noverry Ambo"
 * @start 11/1/2023
 */
@RestController
@RequestMapping("books")
@PreAuthorize("permitAll()")
public class BookController extends BaseController {

    @Autowired
    private BookService service;

    @PreAuthorize("permitAll()")
    @GetMapping
    public RestResult get(@RequestParam(value = "param", required = false) String param,
                          @RequestParam(value = "offset") int offset,
                          @RequestParam(value = "limit") int limit) throws JsonProcessingException {
        Book book = param != null ? new ObjectMapper().readValue(param, Book.class) : null;

        long rows = service.count(book);

        return new RestResult(rows > 0 ? service.find(book, offset, limit) : new ArrayList<>(), rows);
    }

    @PreAuthorize("permitAll()")
    @PostMapping
    public RestResult save(@RequestBody Book param){
//        param = service.save(param);
        param = service.saveBooks(param);
        return new RestResult(param, param != null ? StatusCode.SAVE_SUCCESS : StatusCode.SAVE_FAILED);
    }

    @PutMapping
    public RestResult update(@RequestBody Book book) {
        book = service.update(book);

        return new RestResult(book, book != null ? StatusCode.UPDATE_SUCCESS : StatusCode.UPDATE_FAILED);
    }
    @PreAuthorize("permitAll()")
    @DeleteMapping(value = "{id}")
    public RestResult delete(@PathVariable Long id) {
        return new RestResult(service.delete(id) ? StatusCode.DELETE_SUCCESS : StatusCode.DELETE_FAILED);
    }


}
