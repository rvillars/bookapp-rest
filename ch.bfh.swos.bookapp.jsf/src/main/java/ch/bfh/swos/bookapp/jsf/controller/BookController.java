package ch.bfh.swos.bookapp.jsf.controller;

import ch.bfh.swos.bookapp.service.BookService;
import ch.bfh.swos.bookapp.service.dto.BookDTO;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Date;

@Named
@Scope("session")
public class BookController {

    @Inject
    private BookService bookService;

    private BookDTO currentBook;

    private DataModel<BookDTO> books;

    private boolean showId;

    @PostConstruct
    public void cancel() {
        currentBook = new BookDTO();
        currentBook.setReleaseDate(new Date());
    }

    public void save() {
        bookService.update(currentBook);
        cancel();
    }

    public void edit() {
        currentBook = books.getRowData();
    }

    public void remove() {
        BookDTO book = books.getRowData();
        bookService.delete(book);
        cancel();
    }

    public BookDTO getCurrentBook() {
        return currentBook;
    }

    public void setCurrentBook(BookDTO currentBook) {
        this.currentBook = currentBook;
    }

    public DataModel<BookDTO> getBooks() {
        books = new ListDataModel<BookDTO>();
        books.setWrappedData(bookService.list());
        return books;
    }

    public boolean isShowId() {
        return showId;
    }

    public void setShowId(boolean showId) {
        this.showId = showId;
    }
}