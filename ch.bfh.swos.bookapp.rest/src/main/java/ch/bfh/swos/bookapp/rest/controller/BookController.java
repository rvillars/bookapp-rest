package ch.bfh.swos.bookapp.rest.controller;

import java.util.Collection;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import ch.bfh.swos.bookapp.service.BookService;
import ch.bfh.swos.bookapp.service.dto.BookDTO;

@Controller
@RequestMapping("/books")
public class BookController {

	@Inject
	private BookService bookService;

	/**
	 * Create
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public BookDTO create(@RequestBody BookDTO book, final HttpServletResponse response) {
		BookDTO createdBook = bookService.create(book);
		System.out.println("Book created with id = " + createdBook.getId());
        response.addHeader("Access-Control-Allow-Origin", "*");
        return createdBook;
	}

	/**
	 * ReadAll
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Collection<BookDTO> list(final HttpServletResponse response) {
		System.out.println("Collection of Book requested");
        response.addHeader("Access-Control-Allow-Origin", "*");
        return bookService.list();
	}

	/**
	 * Read
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	@ResponseBody
    public BookDTO read(@PathVariable long id, final HttpServletResponse response) {
		System.out.println("Book requested with id = " + id);
        response.addHeader("Access-Control-Allow-Origin", "*");
        return bookService.read(id);
	}

	/**
	 * Update
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	@ResponseBody
	public BookDTO update(@RequestBody BookDTO book, @PathVariable long id, final HttpServletResponse response) {
		BookDTO updatedBook = bookService.update(book);
		System.out.println("Book updated with id = " + updatedBook.getId());
        response.addHeader("Access-Control-Allow-Origin", "*");
        return updatedBook;
	}

	/**
	 * Delete
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable long id, final HttpServletResponse response) {
		BookDTO book = bookService.read(id);
		bookService.delete(book);
        System.out.println("Delete Book with id = " + id);
        response.addHeader("Access-Control-Allow-Origin", "*");
	}

    @RequestMapping(method = RequestMethod.OPTIONS)
    public void catchAllOpt(final HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "HEAD, GET, OPTIONS, POST");
        response.addHeader("Access-Control-Allow-Headers", "Cache-Control, Pragma, Origin, Authorization, Content-Type, X-Requested-With");
    }
}
