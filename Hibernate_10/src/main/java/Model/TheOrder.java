package Model;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
public class TheOrder {
    @Id
    @GeneratedValue
    private int id;
    private String customerName;
    private Date purchaseDate;
    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
            //fetch = FetchType.EAGER
            // khuyên dùng LAZY
    )
//    @OneToMany(mappedBy = "order",cascade = CascadeType.PERSIST)
//    @OneToMany(mappedBy = "order",cascade = CascadeType.MERGE)
//    @OneToMany(mappedBy = "order",cascade = CascadeType.REMOVE)
    private List<OrderDetails> orderDetailsList = new ArrayList<OrderDetails>();

    public TheOrder() {
    }

    public TheOrder(int id, String customerName, Date dateOfBirth, List<OrderDetails> orderDetailsList) {
        this.id = id;
        this.customerName = customerName;
        this.purchaseDate = dateOfBirth;
        this.orderDetailsList = orderDetailsList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public List<OrderDetails> getOrderDetailsList() {
        return orderDetailsList;
    }

    public void setOrderDetailsList(List<OrderDetails> orderDetailsList) {
        this.orderDetailsList = orderDetailsList;
    }
    public void addOrderDetails(OrderDetails orderDetails){
        this.orderDetailsList.add(orderDetails);
    }

    @Override
    public String toString() {
        return "TheOrder{" +
                "id=" + id +
                ", customerName='" + customerName + '\'' +
                ", purchaseDate=" + purchaseDate +
                '}';
    }
}
