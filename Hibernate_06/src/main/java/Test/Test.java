package Test;


import Model.Customer;
import Model.MyOrder;
import Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        if(sessionFactory != null){
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            Customer customer1 = new Customer("001","Nguyễn Văn A","a123@gmail.com");
            MyOrder order1 = new MyOrder("1","TP.HCM",customer1);
            MyOrder order2 = new MyOrder("2","TP.HCM",customer1);
            MyOrder order3 = new MyOrder("3","TP.HCM",customer1);
            MyOrder order4 = new MyOrder("4","TP.HCM",customer1);

            List<MyOrder> orderList = new ArrayList<>();
            orderList.add(order1);
            orderList.add(order2);
            orderList.add(order3);
            orderList.add(order4);

            customer1.setOrderList(orderList);

            session.saveOrUpdate(customer1);

            for (MyOrder mo : orderList) {
                session.saveOrUpdate(mo);
            }

            Customer customer2 = new Customer("002","Trần Thị B","b113@gmail.com");
            session.saveOrUpdate(customer2);

            String  hql = "FROM Customer c WHERE size(c.orderList) > 0";
            List<Customer> results = session.createQuery(hql).list();

            for (Customer rs: results) {
                System.out.println(rs.toString());
            }

            transaction.commit();
            session.close();
        }
    }
}
