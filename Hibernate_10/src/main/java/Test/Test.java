package Test;


import Model.OrderDetails;
import Model.TheOrder;
import Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        if(sessionFactory != null){
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

//            TheOrder order1 = new TheOrder();
//            order1.setCustomerName("Nguyễn Văn A");
//            order1.setPurchaseDate(new Date(111,5,12));
//
//            for (int i = 0; i < 10000; i++) {
//                OrderDetails orderDetails_1 = new OrderDetails();
//                orderDetails_1.setProductName(i+"");
//                orderDetails_1.setPrice(4500);
//                orderDetails_1.setQuantity(5);
//                orderDetails_1.setTotal(4500*5);
//                orderDetails_1.setOrder(order1);
//                order1.addOrderDetails(orderDetails_1);
//            }


//            session.saveOrUpdate(order1);

//            TheOrder theOrder = session.load(TheOrder.class,2);
//            session.remove(theOrder);

            long start = System.currentTimeMillis();
            TheOrder theOrder = session.load(TheOrder.class,1);
            long end = System.currentTimeMillis();
            System.out.println(theOrder.toString());
            List<OrderDetails> list = theOrder.getOrderDetailsList();
            for (OrderDetails orderDetails: list) {
                System.out.println(orderDetails.toString());
            }
            System.out.println("Command execution time: "+(end-start));

            transaction.commit();
            session.close();
        }
    }
}
