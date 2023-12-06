package Test;


import Model.OrderDetails;
import Model.TheOrder;
import Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.sql.Date;

public class Test {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        if(sessionFactory != null){
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            TheOrder order1 = new TheOrder();
            order1.setCustomerName("Nguyễn Văn A");
            order1.setPurchaseDate(new Date(111,5,12));

            OrderDetails orderDetails_1 = new OrderDetails();
            orderDetails_1.setProductName("Mì Hảo Hảo");
            orderDetails_1.setPrice(4500);
            orderDetails_1.setQuantity(5);
            orderDetails_1.setTotal(4500*5);
            orderDetails_1.setOrder(order1);

            OrderDetails orderDetails_2 = new OrderDetails();
            orderDetails_2.setProductName("TH True Milk");
            orderDetails_2.setPrice(7000);
            orderDetails_2.setQuantity(10);
            orderDetails_2.setTotal(7000*10);
            orderDetails_2.setOrder(order1);

            order1.addOrderDetails(orderDetails_1);
            order1.addOrderDetails(orderDetails_2);

            session.saveOrUpdate(order1);

//            TheOrder theOrder = session.load(TheOrder.class,2);
//            session.remove(theOrder);

            transaction.commit();
            session.close();
        }
    }
}
