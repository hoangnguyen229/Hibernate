package Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Author {
    @Id
    private String author_id;
    private String name;
    private Date dateOfBirth;

    public Author(String author_id, String name, Date dateOfBirth) {
        this.author_id = author_id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public Author() {
    }

    public String getAuthor_id() {
        return author_id;
    }

    public String getName() {
        return name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setAuthor_id(String author_id) {
        this.author_id = author_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
