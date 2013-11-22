package ch.bfh.swos.bookapp.rest.controller;

import ch.bfh.swos.bookapp.service.BookService;
import ch.bfh.swos.bookapp.service.dto.AuthorDTO;
import ch.bfh.swos.bookapp.service.dto.BookDTO;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

@Api(value = "/books", description = "Operations for books")
@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
public class BookController {

	@SuppressWarnings("SpringJavaAutowiringInspection")
    @Inject
	private BookService bookService;

	/**
	 * Create
	 */
    @ApiOperation(value = "Creates a new book", response = BookDTO.class, notes = "Resturns the created book with a set id", position = 3)
    @ApiResponses(value = {@ApiResponse(code = 400, message = "Bad request")})
    @POST
	public BookDTO create(@Valid BookDTO book) {
		BookDTO createdBook = bookService.create(book);
		System.out.println("Book created with id = " + createdBook.getId());
		return createdBook;
	}

	/**
	 * ReadAll
	 */
    @ApiOperation(value = "Gets a list of all existing books", response = BookDTO.class, position = 1)
    @GET
	public Collection<BookDTO> list() {
		System.out.println("Collection of Book requested");
		return bookService.list();
	}

	/**
	 * Read
	 */
    @ApiOperation(value = "Returns the book with the given id", response = BookDTO.class, position = 2)
    @GET
    @Path("/{id}")
	public BookDTO read(@PathParam("id") long id) {
		System.out.println("Book requested with id = " + id);
		return bookService.read(id);
	}

	/**
	 * Update
	 */
    @ApiOperation(value = "Replaces the given book", response = BookDTO.class, position = 4)
    @ApiResponses(value = {@ApiResponse(code = 400, message = "Bad request")})
    @PUT
    @Path("/{id}")
	public BookDTO update(@Valid BookDTO book, @PathParam("id") long id) {
		BookDTO updatedBook = bookService.update(book);
		System.out.println("Book updated with id = " + updatedBook.getId());
		return updatedBook;
	}

	/**
	 * Delete
	 */
    @ApiOperation(value = "Deletes the book with the given id", response = BookDTO.class, position = 5)
    @DELETE
    @Path("/{id}")
	public void delete(@PathParam("id") long id) {
		BookDTO book = bookService.read(id);
		bookService.delete(book);
		System.out.println("Delete Book with id = " + id);
	}
}
