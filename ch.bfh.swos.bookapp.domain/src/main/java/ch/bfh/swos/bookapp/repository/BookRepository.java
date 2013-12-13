package ch.bfh.swos.bookapp.repository;

import java.util.Collection;

import ch.bfh.swos.bookapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

}
