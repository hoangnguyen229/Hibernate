package Model;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Student extends Person {
    private double avgScore;

    public Student() {
    }

    public Student(double avgScore) {
        this.avgScore = avgScore;
    }

    public Student(String id, String fullName, Date dateOfBirth, double avgScore) {
        super(id, fullName, dateOfBirth);
        this.avgScore = avgScore;
    }

    public double getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(double avgScore) {
        this.avgScore = avgScore;
    }
}
