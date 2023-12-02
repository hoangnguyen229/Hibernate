package Test;

import Dao.PersonDAO;
import Model.Person;

import java.util.Date;
import java.util.List;

public class Test3 {
    public static void main(String[] args) {
        PersonDAO personDAO = new PersonDAO();
        List<Person> personList = personDAO.selectAll();
        for (Person ps : personList) {
            System.out.println(ps.getId() + " " + ps.getName());
        }


        Person person = new Person();
        person.setId(2);

        Person person1 = personDAO.selectByID(person);
        System.out.println(person1.getName() + " " + person1.getDateOfBirth());

        Person person2 = new Person("Trần Thị D", new Date(System.currentTimeMillis()),null);
        Person person3 = new Person("Doãn Bá E",new Date(System.currentTimeMillis()),null);
        personDAO.insert(person2);
        personDAO.insert(person3);

        personDAO.delete(person3);
    }
}
