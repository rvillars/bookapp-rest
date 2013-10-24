package ch.bfh.swos.bookapp.repository.index;

import ch.bfh.swos.bookapp.model.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Created with IntelliJ IDEA.
 * User: rovi
 * Date: 13.10.13
 * Time: 17:07
 * To change this template use File | Settings | File Templates.
 */
public interface BookIndexRepository extends ElasticsearchRepository<Book,String> {
}
