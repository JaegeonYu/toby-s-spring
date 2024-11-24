package tobyspring.hellospring.hellospring;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tobyspring.hellospring.hellospring.order.Order;

import java.io.IOException;
import java.math.BigDecimal;

public class DataClient {
    public static void main(String[] args) throws IOException {
        BeanFactory beanFactory = new AnnotationConfigApplicationContext(DataConfig.class);
        EntityManagerFactory emf = beanFactory.getBean(EntityManagerFactory.class);

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Order order = new Order("100", BigDecimal.TEN);
        em.persist(order);

        System.out.println(order);

        em.getTransaction().commit();
        em.close();



    }
}