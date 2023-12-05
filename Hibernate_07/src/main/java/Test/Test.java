package Test;


import Model.Employee;
import Model.Meeting;
import Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        if(sessionFactory != null){
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            Employee employee_1 = new Employee("E1","Nguyễn Văn A",new Date(100,10,15)); // year - 1900, month -1, date -1
            Employee employee_2 = new Employee("E2","Nguyễn Văn B",new Date(100,9,16));
            Employee employee_3 = new Employee("E3","Nguyễn Văn C",new Date(100,9,17));
            session.saveOrUpdate(employee_1);

            Meeting meeting_1 = new Meeting();
            meeting_1.setNameMeeting("Hội đồng quản trị");
            meeting_1.setTime(new Date(2025,2,28));
            meeting_1.setLocation("Room 1");
            meeting_1.addEmployee(employee_1);
            meeting_1.addEmployee(employee_2);
            meeting_1.addEmployee(employee_3);

            Meeting meeting_2 = new Meeting();
            meeting_2.setNameMeeting("Hội đồng kỉ luật");
            meeting_2.setTime(new Date(125,3,3));
            meeting_2.setLocation("Room 2");
            meeting_2.addEmployee(employee_2);
            meeting_2.addEmployee(employee_3);

            session.saveOrUpdate(meeting_1);
            session.saveOrUpdate(meeting_2);
            transaction.commit();
            session.close();
        }
    }
}
