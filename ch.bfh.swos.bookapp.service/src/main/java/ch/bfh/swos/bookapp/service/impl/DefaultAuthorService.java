package ch.bfh.swos.bookapp.service.impl;

import ch.bfh.swos.bookapp.model.Author;
import ch.bfh.swos.bookapp.repository.AuthorRepository;
import ch.bfh.swos.bookapp.service.AuthorService;
import ch.bfh.swos.bookapp.service.dto.AuthorDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import javax.inject.Inject;
import javax.inject.Named;
import java.lang.reflect.Type;
import java.util.Collection;

@Named
public class DefaultAuthorService implements AuthorService {

    @Inject
    private AuthorRepository authorRepository;

    private final ModelMapper mapper = new ModelMapper();

    public AuthorDTO create(AuthorDTO authorDto) {
        Author author = mapper.map(authorDto, Author.class);
        Author persistedAuthor = authorRepository.save(author);
        return mapper.map(persistedAuthor, AuthorDTO.class);
    }

    public AuthorDTO read(long id) {
        Author author = authorRepository.findOne(id);
        if (author == null) return null;
        return mapper.map(author, AuthorDTO.class);
    }

    public Collection<AuthorDTO> list() {
        Iterable<Author> authors = authorRepository.findAll();
        Type listType = new TypeToken<Collection<AuthorDTO>>() {
        }.getType();
        return mapper.map(authors, listType);
    }

    public AuthorDTO update(AuthorDTO authorDto) {
        Author author = mapper.map(authorDto, Author.class);
        Author updatedAuthor = authorRepository.save(author);
        return mapper.map(updatedAuthor, AuthorDTO.class);
    }

    public void delete(AuthorDTO authorDto) {
        Author author = authorRepository.findOne(authorDto.getId());
        authorRepository.delete(author);
    }
}
