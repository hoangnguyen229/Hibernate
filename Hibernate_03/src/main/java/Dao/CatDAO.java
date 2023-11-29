package Dao;

import Model.Cat;
import Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class CatDAO implements DAOInterface<Cat> {
    @Override
    public List<Cat> selectAll() {
        List<Cat> list = new ArrayList<>();
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            if(sessionFactory != null){
                Session session = sessionFactory.openSession();
                Transaction transaction = session.beginTransaction();

//                Thực thi câu lệnh HQL
                String hql = "from Cat";
                Query query = session.createQuery(hql);
                list = query.getResultList();

                transaction.commit();
                session.close();
            }
            else {
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Cat selectByID(Cat cat) {
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            if(sessionFactory!=null) {
                Session session = sessionFactory.openSession();
                Transaction tr = session.beginTransaction();

                Cat result = session.get(Cat.class, 1);
                // find
                // load

                tr.commit();
                session.close();
                return  result;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean insert(Cat cat) {
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            if(sessionFactory != null){
                Session session = sessionFactory.openSession();
                Transaction transaction = session.beginTransaction();

//                Thực thi câu lệnh HQL
//                Chỉ lưu khi chưa tồn tại
//                session.save(cat);
//                Thêm mới khi chưa tồn tại, cập nhật dữ liệu khi đã tồn tại
                session.saveOrUpdate(cat);

                transaction.commit();
                session.close();
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean saveOrUpDate(Cat cat){
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            if(sessionFactory != null){
                Session session = sessionFactory.openSession();
                Transaction transaction = session.beginTransaction();

//                Thực thi câu lệnh HQL
//                Chỉ lưu khi chưa tồn tại
//                session.save(cat);
//                session.persist(cat); giống save nhưng sẽ không trả về ID, không quăng ra lỗi
//                Thêm mới khi chưa tồn tại, cập nhật dữ liệu khi đã tồn tại
                session.saveOrUpdate(cat);

                transaction.commit();
                session.close();
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    @Override
    public boolean update(Cat cat) {
        return saveOrUpDate(cat);
    }

    @Override
    public boolean delete(Cat cat) {
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            if(sessionFactory != null){
                Session session = sessionFactory.openSession();
                Transaction transaction = session.beginTransaction();

                session.delete(cat);

                transaction.commit();
                session.close();
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
