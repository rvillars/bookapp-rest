package ch.bfh.swos.bookapp.service.impl;

import ch.bfh.swos.bookapp.model.Book;
import ch.bfh.swos.bookapp.repository.BookRepository;
import ch.bfh.swos.bookapp.service.BookService;
import ch.bfh.swos.bookapp.service.dto.BookDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import javax.inject.Inject;
import javax.inject.Named;
import java.lang.reflect.Type;
import java.util.Collection;

@Named
public class DefaultBookService implements BookService {

    @Inject
    private BookRepository bookRepository;

    private final ModelMapper mapper = new ModelMapper();

    public BookDTO create(BookDTO bookDto) {
        Book book = mapper.map(bookDto, Book.class);
        Book persistedBook = bookRepository.save(book);
        return mapper.map(persistedBook, BookDTO.class);
    }

    public BookDTO read(long id) {
        Book book = bookRepository.findOne(id);
        if (book == null) return null;
        return mapper.map(book, BookDTO.class);
    }

    public Collection<BookDTO> list() {
        Iterable<Book> books = bookRepository.findAll();
        Type listType = new TypeToken<Collection<BookDTO>>() {
        }.getType();
        return mapper.map(books, listType);
    }

    public BookDTO update(BookDTO bookDto) {
        Book book = mapper.map(bookDto, Book.class);
        Book updatedBook = bookRepository.save(book);
        return mapper.map(updatedBook, BookDTO.class);
    }

    public void delete(BookDTO bookDto) {
        Book book = bookRepository.findOne(bookDto.getId());
        bookRepository.delete(book);
    }

}
