package Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PERSON")
public class Person {

    @Id
    @GeneratedValue
    @Column(name = "persion_id")
    private int id;
    private String name;
    private Date dateOfBirth;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "spouse_id") // nối 2 cột
    private Person spouse; // vợ hoặc chồng
    public Person(){

    }
    public Person(int id, String name, Date dateOfBirth, Person spouse){
        super();
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.spouse = spouse;
    }
    public Person(String name, Date dateOfBirth, Person spouse){
        super();
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.spouse = spouse;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public Person getSpouse() {
        return spouse;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setSpouse(Person spouse) {
        this.spouse = spouse;
    }
}
