package ch.bfh.swos.bookapp.repository;

import ch.bfh.swos.bookapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
