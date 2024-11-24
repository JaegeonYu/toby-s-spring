package tobyspring.hellospring.hellospring.data;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceContext;
import tobyspring.hellospring.hellospring.order.Order;

import java.math.BigDecimal;

public class OrderRepository {
    @PersistenceContext
    EntityManager em;


    public void save(Order order){
        em.persist(order);
    }
}
