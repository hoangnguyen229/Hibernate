package Model;

import javax.persistence.*;


@Entity
public class MyOrder {
    @Id
    private String order_id;
    private String address;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public MyOrder() {
    }

    public MyOrder(String order_id, String address, Customer customer) {
        this.order_id = order_id;
        this.address = address;
        this.customer = customer;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
