package ch.bfh.swos.bookapp.jsf.controller;

import ch.bfh.swos.bookapp.service.AuthorService;
import ch.bfh.swos.bookapp.service.dto.AuthorDTO;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@Scope("session")
public class AuthorController {

    @Inject
    private AuthorService authorService;

    private AuthorDTO currentAuthor;

    private DataModel<AuthorDTO> authors;

    private boolean showId;

    @PostConstruct
    public void cancel() {
        currentAuthor = new AuthorDTO();
    }

    public void save() {
        authorService.update(currentAuthor);
        cancel();
    }

    public void edit() {
        currentAuthor = authors.getRowData();
    }

    public void remove() {
        AuthorDTO author = authors.getRowData();
        authorService.delete(author);
        cancel();
    }

    public AuthorDTO getCurrentAuthor() {
        return currentAuthor;
    }

    public void setCurrentAuthor(AuthorDTO currentAuthor) {
        this.currentAuthor = currentAuthor;
    }

    public DataModel<AuthorDTO> getAuthors() {
        authors = new ListDataModel<AuthorDTO>();
        authors.setWrappedData(authorService.list());
        return authors;
    }

    public boolean isShowId() {
        return showId;
    }

    public void setShowId(boolean showId) {
        this.showId = showId;
    }
}