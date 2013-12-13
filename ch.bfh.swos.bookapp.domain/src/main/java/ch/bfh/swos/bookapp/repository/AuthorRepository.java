package ch.bfh.swos.bookapp.repository;

import java.util.Collection;

import ch.bfh.swos.bookapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
