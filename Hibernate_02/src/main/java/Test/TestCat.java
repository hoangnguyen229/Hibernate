package Test;

import Dao.CatDAO;
import Model.Cat;
import java.sql.Date;
import Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class TestCat {
    public static void main(String[] args) {
        CatDAO cat_Dao = new CatDAO();

//        Test SelectAll()
//        List<Cat> list = cat_Dao.selectAll();
//        for (Cat cat: list) {
//            System.out.println(cat);
//        }

//        Test select by id
//        Cat c = new Cat();
//        c.setId(3);
//        Cat c1 = cat_Dao.selectByID(c);
//        System.out.println(c1);

//        Test insert
        Cat c3 = new Cat("Meo Mum 1",  new Date(System.currentTimeMillis()),true);
        Cat c4 = new Cat("Meo Mum Mim",  new Date(System.currentTimeMillis()),false);
        c3.setId(10);
//        cat_Dao.insert(c3);

//        Test Delete
        cat_Dao.delete(c3);
    }
}
