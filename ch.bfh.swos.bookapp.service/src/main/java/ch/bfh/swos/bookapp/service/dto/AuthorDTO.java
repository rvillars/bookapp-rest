package ch.bfh.swos.bookapp.service.dto;

import com.wordnik.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Entity implementation class for Entity: Author
 */
public class AuthorDTO implements Serializable {

    private static final long serialVersionUID = -4783174154421098852L;

    @ApiModelProperty(required = false, value = "Unique id of the author", position = 1)
    private Long id;

    @ApiModelProperty(required = true, value = "Firstname of the author", position = 2)
    @NotNull
    private String firstname;

    @ApiModelProperty(required = true, value = "Lastname the author", position = 3)
    @NotNull
    private String lastname;

    public AuthorDTO() {
        super();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
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
