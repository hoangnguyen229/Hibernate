package Test;

import Dao.CatDAO;
import Model.Cat;
import Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.sql.Date;

public class TestCat_2 {
    public static void main(String[] args) {

//        Transient
        Cat cat_1 = new Cat("Meo Long Xu",new Date(System.currentTimeMillis()),true);

        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            if(sessionFactory!=null) {
                Session session = sessionFactory.openSession();
                Transaction tr = session.beginTransaction();

//                Persistent
                session.save(cat_1);
                tr.commit();

//                Detached => Persistent
                session.refresh(cat_1);

                session.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(cat_1);
    }
}
