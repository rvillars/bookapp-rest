package ch.bfh.swos.bookapp.repository.impl;

import java.util.Collection;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import ch.bfh.swos.bookapp.model.Author;
import ch.bfh.swos.bookapp.repository.AuthorRepository;

@Named
public class JPAAuthorRepository implements AuthorRepository {

	@PersistenceContext
	protected EntityManager em;

	@Override
	@Transactional
	public Author create(Author author) {
		em.persist(author);
		return author;
	}

	@Override
	public Author read(long id) {
		return em.find(Author.class, id);
	}

	@Override
	@SuppressWarnings("unchecked")
	public Collection<Author> list() {
		return em.createQuery("select a from Author a").getResultList();
	}

	@Override
	@Transactional
	public Author update(Author author) {
		return em.merge(author);
	}

	@Override
	@Transactional
	public void delete(Author author) {
		em.remove(author);
	}

}
