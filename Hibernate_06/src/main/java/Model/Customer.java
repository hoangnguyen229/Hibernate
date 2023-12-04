package Model;

import javax.persistence.*;
import java.util.List;


@Entity
public class Customer {
    @Id
    private String id;
    private String name;
    private String email;
    @OneToMany(mappedBy = "customer") // có khách hàng thì mới có đơn hàng
    private List<MyOrder> orderList;

    public Customer() {
    }

    public Customer(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<MyOrder> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<MyOrder> orderList) {
        this.orderList = orderList;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", orderList=" + orderList.size() +
                '}';
    }
}
