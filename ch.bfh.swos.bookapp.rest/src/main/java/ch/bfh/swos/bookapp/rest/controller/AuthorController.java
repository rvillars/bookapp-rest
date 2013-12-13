package ch.bfh.swos.bookapp.rest.controller;

import java.util.Collection;

import javax.inject.Inject;

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

@Controller
@RequestMapping("/authors")
public class AuthorController {

	@Inject
	private AuthorService authorService;

	/**
	 * Create
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public AuthorDTO create(@RequestBody AuthorDTO author) {
		AuthorDTO createdAuthor = authorService.create(author);
		System.out.println("Author created with id = " + createdAuthor.getId());
		return createdAuthor;
	}

	/**
	 * ReadAll
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Collection<AuthorDTO> list() {
		System.out.println("Collection of Author requested");
		return authorService.list();
	}

	/**
	 * Read
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	@ResponseBody
	public AuthorDTO read(@PathVariable long id) {
		System.out.println("Author requested with id = " + id);
		return authorService.read(id);
	}

	/**
	 * Update
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	@ResponseBody
	public AuthorDTO update(@RequestBody AuthorDTO author, @PathVariable long id) {
		AuthorDTO updatedAuthor = authorService.update(author);
		System.out.println("Author updated with id = " + updatedAuthor.getId());
		return updatedAuthor;
	}

	/**
	 * Delete
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable long id) {
		AuthorDTO author = authorService.read(id);
		authorService.delete(author);
		System.out.println("Delete Author with id = " + id);
	}
}
