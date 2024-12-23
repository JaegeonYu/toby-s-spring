package tobyspring.hellospring.hellospring;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;
import tobyspring.hellospring.hellospring.data.OrderRepository;
import tobyspring.hellospring.hellospring.order.Order;

import java.io.IOException;
import java.math.BigDecimal;

public class DataClient {
    public static void main(String[] args) throws IOException {
        BeanFactory beanFactory = new AnnotationConfigApplicationContext(DataConfig.class);
        OrderRepository orderRepository = beanFactory.getBean(OrderRepository.class);
        JpaTransactionManager transactionManager = beanFactory.getBean(JpaTransactionManager.class);
        try{
            new TransactionTemplate(transactionManager).execute(status -> {
                Order order = new Order("100", BigDecimal.TEN);
                orderRepository.save(order);

                Order order2 = new Order("100", BigDecimal.ONE);
                orderRepository.save(order2);

                return null;
            });
        }catch (DataIntegrityViolationException e){
            System.out.println("주문번호 중복 복구 작업");
        }





    }
}