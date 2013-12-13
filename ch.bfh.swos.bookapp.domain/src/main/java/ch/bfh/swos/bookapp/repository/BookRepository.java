package ch.bfh.swos.bookapp.repository;

import ch.bfh.swos.bookapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

}
