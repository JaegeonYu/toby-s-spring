package tobyspring.hellospring.hellospring;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tobyspring.hellospring.hellospring.data.OrderRepository;
import tobyspring.hellospring.hellospring.order.Order;

import java.io.IOException;
import java.math.BigDecimal;

public class DataClient {
    public static void main(String[] args) throws IOException {
        BeanFactory beanFactory = new AnnotationConfigApplicationContext(DataConfig.class);
        OrderRepository orderRepository = beanFactory.getBean(OrderRepository.class);

        Order order = new Order("100", BigDecimal.TEN);
        orderRepository.save(order);

        Order order2 = new Order("100", BigDecimal.ONE);
        orderRepository.save(order2);

    }
}