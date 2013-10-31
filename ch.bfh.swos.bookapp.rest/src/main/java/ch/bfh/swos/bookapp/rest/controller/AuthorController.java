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
	public AuthorDTO create(@RequestBody AuthorDTO author, final HttpServletResponse response) {
		AuthorDTO createdAuthor = authorService.create(author);
		System.out.println("Author created with id = " + createdAuthor.getId());
        response.addHeader("Access-Control-Allow-Origin", "*");
		return createdAuthor;
	}

	/**
	 * ReadAll
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Collection<AuthorDTO> list(final HttpServletResponse response) {
		System.out.println("Collection of Author requested");
        response.addHeader("Access-Control-Allow-Origin", "*");
        return authorService.list();
	}

	/**
	 * Read
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	@ResponseBody
	public AuthorDTO read(@PathVariable long id, final HttpServletResponse response) {
		System.out.println("Book requested with id = " + id);
        response.addHeader("Access-Control-Allow-Origin", "*");
        return authorService.read(id);
	}

	/**
	 * Update
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	@ResponseBody
	public AuthorDTO update(@RequestBody AuthorDTO author, @PathVariable long id, final HttpServletResponse response) {
		AuthorDTO updatedAuthor = authorService.update(author);
		System.out.println("Author updated with id = " + updatedAuthor.getId());
        response.addHeader("Access-Control-Allow-Origin", "*");
        return updatedAuthor;
	}

	/**
	 * Delete
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable long id, final HttpServletResponse response) {
		AuthorDTO author = authorService.read(id);
		authorService.delete(author);
        response.addHeader("Access-Control-Allow-Origin", "*");
        System.out.println("Delete Author with id = " + id);
	}

    @RequestMapping(method = RequestMethod.OPTIONS)
    public void catchAllOpt(final HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "HEAD, GET, OPTIONS, POST");
        response.addHeader("Access-Control-Allow-Headers", "Cache-Control, Pragma, Origin, Authorization, Content-Type, X-Requested-With");
    }
}
