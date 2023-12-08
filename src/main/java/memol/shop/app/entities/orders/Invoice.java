package memol.shop.app.entities.orders;

import memol.shop.app.entities.people.Customer;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Invoice {

    @Id
    @GeneratedValue
    private long id;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @OneToMany
    @JoinColumn(name = "order_items")
    private List<OrderItem> orderItems;

    private Date invoiceDate;
    private Date payDate;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }


}
