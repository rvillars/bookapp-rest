package ch.bfh.swos.bookapp.repository;

import java.util.Collection;

import ch.bfh.swos.bookapp.model.Book;

public interface BookRepository {

	public Book create(Book book);

	public Book read(long id);

	public Collection<Book> list();

	public Book update(Book book);

	public void delete(Book book);

}
