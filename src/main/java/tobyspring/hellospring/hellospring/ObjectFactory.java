package tobyspring.hellospring.hellospring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
public class ObjectFactory {
    @Bean
    PaymentService paymentService(){
        return new PaymentService(exRateProvider());
    }

    @Bean
    ExRateProvider exRateProvider(){
        return new WebApiExRateProvider();
    }

    @Bean
    OrderService orderService(){
        return new OrderService(exRateProvider());
    }
}

class OrderService{
    ExRateProvider exRateProvider;

    public OrderService(ExRateProvider exRateProvider) {
        this.exRateProvider = exRateProvider;
    }
}
