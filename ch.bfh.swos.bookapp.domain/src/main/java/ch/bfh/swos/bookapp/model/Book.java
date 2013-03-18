package ch.bfh.swos.bookapp.model;

import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.TemporalType.DATE;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 * Entity implementation class for Entity: Book
 * 
 */
@Entity
public class Book implements Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private long id;
	private String title;
	@Temporal(DATE)
	private Date releaseDate;
	private static final long serialVersionUID = 1L;

	private Author author;

	public Book() {
		super();
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getReleaseDate() {
		return this.releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

}
