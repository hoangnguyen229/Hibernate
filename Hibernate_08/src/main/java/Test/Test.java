package Test;


import Model.Person;
import Model.Student;
import Model.Teacher;
import Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Date;

public class Test {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        if(sessionFactory != null){
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            Teacher teacher = new Teacher("T01","Nguyễn Văn A",new Date(90,1,3),"Maths");
            Student student = new Student("S01","Nguyễn Văn B",new Date(110,4,5),9.8);

            session.saveOrUpdate(teacher);
            session.saveOrUpdate(student);

            transaction.commit();
            session.close();
        }
    }
}
