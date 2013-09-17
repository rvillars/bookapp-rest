package ch.bfh.swos.bookapp.repository;

import java.util.Collection;

import ch.bfh.swos.bookapp.model.Author;

public interface AuthorRepository {

	public Author create(Author author);

	public Author read(long id);

	public Collection<Author> list();

	public Author update(Author author);

	public void delete(Author author);

}
