package aldovalzani.e_commerceClasses;

import java.time.LocalDate;
import java.util.List;

public class Order {
    private static long idCounter = 0;
    private Long id;
    private String status;
    private LocalDate orderDate;
    private List<Product> products;
    private Customer customer;

    public Order(String status, LocalDate orderDate, List<Product> products, Customer customer) {
        this.id = ++idCounter;
        this.status = status;
        this.orderDate = orderDate;
        this.products = products;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", orderDate=" + orderDate +
                ", products=" + products +
                ", customer=" + customer +
                '}';
    }
}

