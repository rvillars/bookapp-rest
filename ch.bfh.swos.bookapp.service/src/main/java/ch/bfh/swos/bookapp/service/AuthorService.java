package ch.bfh.swos.bookapp.service;

import java.util.Collection;

import ch.bfh.swos.bookapp.service.dto.AuthorDTO;

public interface AuthorService {

	public AuthorDTO create(AuthorDTO authorDto);

	public AuthorDTO read(long id);

	public Collection<AuthorDTO> list();

	public AuthorDTO update(AuthorDTO book);

	public void delete(AuthorDTO book);
}
