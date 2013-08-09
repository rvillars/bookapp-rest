package ch.bfh.swos.bookapp.repository.impl;

import java.util.Collection;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import ch.bfh.swos.bookapp.model.Book;
import ch.bfh.swos.bookapp.repository.BookRepository;

@Named
public class JPABookRepository implements BookRepository {

	@PersistenceContext
	protected EntityManager em;

	@Override
	@Transactional
	public Book create(Book book) {
		em.persist(book);
		return book;
	}

	@Override
	public Book read(long id) {
		return em.find(Book.class, id);
	}

	@Override
	@SuppressWarnings("unchecked")
	public Collection<Book> list() {
		return em.createQuery("select b from Book b").getResultList();
	}

	@Override
	@Transactional
	public Book update(Book book) {
		return em.merge(book);
	}

	@Override
	@Transactional
	public void delete(Book book) {
		em.remove(book);
	}

}
