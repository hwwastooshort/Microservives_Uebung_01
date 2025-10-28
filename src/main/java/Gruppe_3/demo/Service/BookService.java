package Gruppe_3.demo.Service;

import Gruppe_3.demo.Entities.Book;
import Gruppe_3.demo.Entities.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository br;

    BookService(BookRepository br) {
        this.br = br;
    }

    public List<Book> getAll() {
        return br.findAll();
    }

    public Book getOne(long id) {
        return br.findById(id).orElseGet(() -> null);
    }

    public void deleteBook(long id) {
        br.deleteById(id);
    }

    public Book changeBook(long id, Book newBook) {
        return br.findById(id)
                .map(existingBook -> {
                    existingBook.setName(newBook.getName());
                    existingBook.setAutor(newBook.getAutor());
                    return br.save(existingBook);
                })
                .orElseGet(() -> {
                    newBook.setId(id);
                    return br.save(newBook);
                });
    }

    public Book addNew(Book book) {
        return br.save(book);
    }
}
