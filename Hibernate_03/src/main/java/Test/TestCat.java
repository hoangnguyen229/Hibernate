package Test;

import Dao.CatDAO;
import Model.Cat;
import Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.sql.Date;

public class TestCat {
    public static void main(String[] args) {

//        Transient
        Cat cat_1 = new Cat();
        cat_1.setId(3);

        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            if(sessionFactory!=null) {
                Session session = sessionFactory.openSession();
                Transaction tr = session.beginTransaction();

//                Persistent
                cat_1 = session.get(Cat.class,3);
                //find
                //load

                tr.commit();
                session.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(cat_1);
    }
}
