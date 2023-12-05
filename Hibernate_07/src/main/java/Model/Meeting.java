package Model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Meeting {
    @Id
    @GeneratedValue
    private int id;
    private String nameMeeting;
    private String location;
    private Date time;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Employee_Meeting",
                    joinColumns = {@JoinColumn(name = "meeting_id")},
                    inverseJoinColumns = {@JoinColumn(name = "employee_id")})
    private Set<Employee> listEmployee = new HashSet<Employee>();

    public Meeting() {
    }

    public Meeting(int id, String nameMeeting, String location, Date time) {
        this.id = id;
        this.nameMeeting = nameMeeting;
        this.location = location;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameMeeting() {
        return nameMeeting;
    }

    public void setNameMeeting(String nameMeeting) {
        this.nameMeeting = nameMeeting;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public void addEmployee(Employee employee){
        this.listEmployee.add(employee);
    }
}
