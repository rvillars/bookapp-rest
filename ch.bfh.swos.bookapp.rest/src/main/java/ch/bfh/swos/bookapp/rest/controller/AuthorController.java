package ch.bfh.swos.bookapp.rest.controller;

import java.util.Collection;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import ch.bfh.swos.bookapp.service.AuthorService;
import ch.bfh.swos.bookapp.service.dto.AuthorDTO;

@Api(value = "/authors", description = "Operations for authors")
@Path("/authors")
@Produces(MediaType.APPLICATION_JSON)
public class AuthorController {

	@SuppressWarnings("SpringJavaAutowiringInspection")
    @Inject
	private AuthorService authorService;

	/**
	 * Create
	 */
    @ApiOperation(value = "Creates a new author", response = AuthorDTO.class, notes = "Resturns the created author with a set id", position = 3)
    @ApiResponses(value = {@ApiResponse(code = 400, message = "Bad request")})
    @POST
	public AuthorDTO create(@Valid AuthorDTO author) {
		AuthorDTO createdAuthor = authorService.create(author);
		System.out.println("Author created with id = " + createdAuthor.getId());
		return createdAuthor;
	}

	/**
	 * ReadAll
	 */
    @ApiOperation(value = "Gets a list of all existing authors", response = AuthorDTO.class, position = 1)
    @GET
	public Collection<AuthorDTO> list() {
		System.out.println("Collection of Author requested");
		return authorService.list();
	}

	/**
	 * Read
	 */
    @ApiOperation(value = "Returns the author with the given id", response = AuthorDTO.class, position = 2)
    @GET
    @Path("/{id}")
	public AuthorDTO read(@PathParam("id") long id) {
		System.out.println("Book requested with id = " + id);
		return authorService.read(id);
	}

	/**
	 * Update
	 */
    @ApiOperation(value = "Replaces the given author", response = AuthorDTO.class, position = 4)
    @ApiResponses(value = {@ApiResponse(code = 400, message = "Bad request")})
    @PUT
    @Path("/{id}")
	public AuthorDTO update(@Valid AuthorDTO author, @PathParam("id") long id) {
		AuthorDTO updatedAuthor = authorService.update(author);
		System.out.println("Author updated with id = " + updatedAuthor.getId());
		return updatedAuthor;
	}

	/**
	 * Delete
	 */
    @ApiOperation(value = "Deletes the author with the given id", response = AuthorDTO.class, position = 5)
    @DELETE
    @Path("/{id}")
	public void delete(@PathParam("id") long id) {
		AuthorDTO author = authorService.read(id);
		authorService.delete(author);
		System.out.println("Delete Author with id = " + id);
	}
}
