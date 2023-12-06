package Model;

import javax.persistence.*;

@Entity
public class OrderDetails {
    @Id
    @GeneratedValue
    private int id;
    private String productName;
    private double quantity;
    private double price;
    private double total;
    @ManyToOne
    @JoinColumn(name = "theOrder_id")
    private TheOrder order;

    public OrderDetails() {
    }

    public OrderDetails(int id, String productName, double quantity, double price, double total, TheOrder order) {
        this.id = id;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.total = total;
        this.order = order;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public TheOrder getOrder() {
        return order;
    }

    public void setOrder(TheOrder order) {
        this.order = order;
    }
}
