package Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Cat {
    private Integer id;
    private String name;
    private Date dateOfBirth;
    private Boolean sex;

    // Bat buoc co 1 constructor rong
    public Cat(){
        super();
    }
    public Cat(Integer id, String name, Date dateOfBirth, Boolean sex){
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
    }
    @Id
    @GeneratedValue // auto number
    public Integer getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Date getDateOfBirth() {
        return dateOfBirth;
    }
    public Boolean getSex() {
        return sex;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public void setSex(Boolean sex) {
        this.sex = sex;
    }
}
