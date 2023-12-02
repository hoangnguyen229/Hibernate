package Dao;

import Model.Person;
import Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class PersonDAO implements DAOInterface<Person> {

    @Override
    public List<Person> selectAll() {
        List<Person> list = new ArrayList<>();
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            if (sessionFactory != null){
                Session session = sessionFactory.openSession();
                Transaction transaction = session.beginTransaction();

                String hql = "FROM Person";
                Query query = session.createQuery(hql);
                list = query.getResultList();

                transaction.commit();
                session.close();
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public Person selectByID(Person person) {
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            if (sessionFactory != null){
                Session session = sessionFactory.openSession();
                Transaction transaction = session.beginTransaction();

                Person result = session.get(Person.class,2);

                transaction.commit();
                session.close();
                return result;
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    public boolean saveOrUpdate(Person person){
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            if (sessionFactory != null){
                Session session = sessionFactory.openSession();
                Transaction transaction = session.beginTransaction();

                session.saveOrUpdate(person);

                transaction.commit();
                session.close();
                return true;
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
    @Override
    public boolean insert(Person person) {
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            if (sessionFactory != null){
                Session session = sessionFactory.openSession();
                Transaction transaction = session.beginTransaction();

                session.saveOrUpdate(person);

                transaction.commit();
                session.close();
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Person person) {
        return saveOrUpdate(person);
    }

    @Override
    public boolean delete(Person person) {
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            if (sessionFactory != null){
                Session session = sessionFactory.openSession();
                Transaction transaction = session.beginTransaction();

                session.delete(person);

                transaction.commit();
                session.close();
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
}
