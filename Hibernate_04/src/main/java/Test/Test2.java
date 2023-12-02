package Test;

import Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        if(sessionFactory != null) {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            String hql = "select p.id,p.name, p.spouse.name,p.spouse.id from Person p";
            List<Object[]> results = session.createQuery(hql).list();

            for (Object[] obj : results) {
                String id = obj[0] +"";
                String name = obj[1] + "";
                String spouseName = obj[2] + "";
                String spouseId = obj[3] + "";

                System.out.println(name + "("+ id + ")" + " is married to " + spouseName + "(" + spouseId+ ")");
            }

            transaction.commit();
            session.close();
        }
    }
}
