package ch.bfh.swos.bookapp.repository;

import ch.bfh.swos.bookapp.model.Book;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/persistenceContext.xml")
public class BookRepositoryIT {

    @Inject
    private BookRepository bookRepository;

    @Test
    public void test() {

        // Save
        Book newBook = new Book();
        newBook.setTitle("Test");
        newBook = bookRepository.save(newBook);

        // FindOne
        Book readBook = bookRepository.findOne(newBook.getId());
        Assert.assertTrue(newBook.getTitle().equals(readBook.getTitle()));

        // Change
        readBook.setTitle("Test2");
        readBook = bookRepository.save(readBook);
        Book updatedBook = bookRepository.findOne(readBook.getId());
        Assert.assertTrue(readBook.getTitle().equals(updatedBook.getTitle()));

        // Delete
        bookRepository.delete(updatedBook);
        Book deletedBook = bookRepository.findOne(readBook.getId());
        Assert.assertNull(deletedBook);
    }

}
