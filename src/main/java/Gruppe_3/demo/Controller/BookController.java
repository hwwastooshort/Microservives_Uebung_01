package Gruppe_3.demo.Controller;

import Gruppe_3.demo.Entities.Book;
import Gruppe_3.demo.Service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/repo")
public class BookController {

    private static final Logger log = LoggerFactory.getLogger(BookController.class);
    private final BookService bs;

    BookController(BookService bs) {
        this.bs = bs;
    }

    @GetMapping("/books")
    List<Book> getALl() {
        log.info("Getting all Books");
        return bs.getAll();
    }

    @GetMapping("/books/{id}")
     Book getOne(@PathVariable Long id) {
        log.info("Getting Book with ID: " + id);
        return bs.getOne(id);
    }

    @PutMapping("/books/{id}")
    Book changeBook(@PathVariable Long id, @RequestBody Book newBook) {
        log.info("changing book with ID: " + id);
        return bs.changeBook(id, newBook);
    }

    @DeleteMapping("/books/{id}")
    void deleteBook(@PathVariable Long id) {
        log.info("Delete Book with ID: " + id);
        bs.deleteBook(id);
    }


    @PostMapping("/books")
    Book newBook(@RequestBody Book newBook) {
        log.info("Saving new Book");
        return bs.addNew(newBook);
    }
}
