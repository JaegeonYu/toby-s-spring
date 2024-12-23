package tobyspring.hellospring.hellospring.order;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "orders")
public class Order {
    @Id @GeneratedValue
    private Long id;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", no='" + no + '\'' +
                ", total=" + total +
                '}';
    }

    public Order() {
    }

    public Order(String no, BigDecimal total) {
        this.no = no;
        this.total = total;
    }

    @Column(unique = true)
    private String no;
    private BigDecimal total;

}
