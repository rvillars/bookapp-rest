package ch.bfh.swos.bookapp.service.dto;

import java.io.Serializable;

/**
 * Entity implementation class for Entity: Author
 * 
 */
public class AuthorDTO implements Serializable {

	private static final long serialVersionUID = -4783174154421098852L;
	private long id;
	private String firstname;
	private String lastname;

	public AuthorDTO() {
		super();
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Override
	public boolean equals(Object obj) {
		return this.id == ((AuthorDTO) obj).getId();
	}
}
