package Dao;

import Model.Author;
import Model.Book;
import Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AuthorDAO implements DAOInterface<Author> {
    @Override
    public List<Author> selectAll() {
        List<Author> list = new ArrayList<>();
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            if(sessionFactory != null){
                Session session = sessionFactory.openSession();
                Transaction transaction = session.beginTransaction();

                String hql = "From Author";
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
    public Author selectByID(Author author) {
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            if (sessionFactory != null){
                Session session = sessionFactory.openSession();
                Transaction transaction = session.beginTransaction();

                Scanner sc = new Scanner(System.in);
                System.out.print("Input author ID: ");
                String bookID = sc.nextLine();
                Author result = session.get(Author.class,bookID);

                transaction.commit();
                session.close();
                return result;
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean insert(Author author) {
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            if (sessionFactory != null){
                Session session = sessionFactory.openSession();
                Transaction transaction = session.beginTransaction();

                Scanner sc = new Scanner(System.in);
                System.out.print("Input book id: ");
                String authorID = sc.nextLine();
                System.out.println("Input author name: ");
                String authorName = sc.nextLine();
                Author author1 = new Author();
                author1.setAuthor_id(authorID);
                author1.setName(authorName);

                session.saveOrUpdate(author1);

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
    public boolean update(Author author) {
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            if (sessionFactory != null){
                Session session = sessionFactory.openSession();
                Transaction transaction = session.beginTransaction();

                Scanner sc = new Scanner(System.in);
                System.out.print("Input author ID to update: ");
                String authorID = sc.nextLine();
                Author authorResult = session.get(Author.class,authorID);
                if(authorResult != null){
                    System.out.print("Input name to update: ");
                    String authorName = sc.nextLine();
                    authorResult.setName(authorName);
                }else {
                    System.out.println("Not found ID author");
                }

                session.saveOrUpdate(authorResult);

                transaction.commit();
                session.close();
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Author author) {
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            if (sessionFactory != null){
                Session session = sessionFactory.openSession();
                Transaction transaction = session.beginTransaction();

                Scanner sc = new Scanner(System.in);
                System.out.print("Input author ID to delete: ");
                String authorID = sc.nextLine();
                Author authorResult = session.get(Author.class,authorID);
                if(authorResult != null){
                    session.delete(authorResult);
                    System.out.println("IsDeleted!");
                }else{
                    System.out.println("Not found ID author");
                }
                transaction.commit();
                session.close();
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
}
