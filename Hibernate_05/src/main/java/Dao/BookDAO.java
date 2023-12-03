package Dao;

import Model.Book;
import Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookDAO implements DAOInterface<Book> {
    @Override
    public List<Book> selectAll() {
        List<Book> list = new ArrayList<>();
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            if(sessionFactory != null){
                Session session = sessionFactory.openSession();
                Transaction transaction = session.beginTransaction();

                String hql = "From Book";
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
    public Book selectByID(Book book) {
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            if (sessionFactory != null){
                Session session = sessionFactory.openSession();
                Transaction transaction = session.beginTransaction();

                Scanner sc = new Scanner(System.in);
                System.out.print("Input book ID: ");
                String bookID = sc.nextLine();
                Book result = session.get(Book.class,bookID);

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
    public boolean insert(Book book) {
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            if (sessionFactory != null){
                Session session = sessionFactory.openSession();
                Transaction transaction = session.beginTransaction();

                Scanner sc = new Scanner(System.in);
                System.out.print("Input book id: ");
                String bookID = sc.nextLine();
                System.out.println("Input title book: ");
                String bookTitle = sc.nextLine();
                System.out.println("Input price: ");
                Double bookPrice = sc.nextDouble();
                Book book1 = new Book();
                book1.setBook_id(bookID);
                book1.setTitle(bookTitle);
                book1.setPrice(bookPrice);

                session.saveOrUpdate(book1);

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
    public boolean update(Book book) {
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            if (sessionFactory != null){
                Session session = sessionFactory.openSession();
                Transaction transaction = session.beginTransaction();

                Scanner sc = new Scanner(System.in);
                System.out.print("Input book ID to update: ");
                String bookID = sc.nextLine();
                Book bookResult = session.get(Book.class,bookID);
                if(bookResult != null){
                    System.out.print("Input price to update: ");
                    double priceBookToUpdate = sc.nextDouble();
                    bookResult.setPrice(priceBookToUpdate);
                }else {
                    System.out.println("Not found ID book");
                }

                session.saveOrUpdate(bookResult);

                transaction.commit();
                session.close();
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Book book) {
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            if (sessionFactory != null){
                Session session = sessionFactory.openSession();
                Transaction transaction = session.beginTransaction();

                Scanner sc = new Scanner(System.in);
                System.out.print("Input book ID to delete: ");
                String bookID = sc.nextLine();
                Book bookResult = session.get(Book.class,bookID);
                if(bookResult != null){
                    session.delete(bookResult);
                    System.out.println("IsDeleted!");
                }else{
                    System.out.println("Not found ID book");
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
