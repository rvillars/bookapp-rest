package ch.bfh.swos.bookapp.service.dto;

import com.wordnik.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * Entity implementation class for Entity: Book
 */
public class BookDTO implements Serializable {

    private static final long serialVersionUID = -7591860079571184677L;

    @ApiModelProperty(required = false, value = "Unique id of the book", position = 1)
    private Long id;

    @ApiModelProperty(required = true, value = "The title of the book", position = 2)
    @NotNull
    private String title;

    @ApiModelProperty(required = false, value = "Release date of the book in format yyyy-MM-dd", position = 3)
    @Future
    private Date releaseDate;

    @ApiModelProperty(required = false, value = "Author of the book", position = 4)
    @Valid
    private AuthorDTO author;

    public BookDTO() {
        super();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
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

    public AuthorDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }
}
