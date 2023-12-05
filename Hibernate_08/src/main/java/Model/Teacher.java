package Model;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Teacher extends Person {
    private String subject;

    public Teacher() {
    }

    public Teacher(String subject) {
        this.subject = subject;
    }

    public Teacher(String id, String fullName, Date dateOfBirth, String subject) {
        super(id, fullName, dateOfBirth);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
