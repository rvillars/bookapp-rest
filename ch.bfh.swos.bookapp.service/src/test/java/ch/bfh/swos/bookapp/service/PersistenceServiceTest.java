package ch.bfh.swos.bookapp.service;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ch.bfh.swos.bookapp.model.Book;
import ch.bfh.swos.bookapp.repository.BookRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/serviceContext.xml")
public class PersistenceServiceTest {

	@Inject
	private BookRepository bookDao;

	@Test
	public void test() {
		Book book = new Book();
		book.setTitle("Test");
		Book managedBook = bookDao.update(book);
		Book foundBook = bookDao.read(managedBook.getId());
		Assert.assertTrue(book.getTitle().equals(foundBook.getTitle()));
		bookDao.delete(foundBook);
	}

}
