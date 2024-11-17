package tobyspring.hellospring.hellospring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tobyspring.hellospring.hellospring.exrate.CachedExRateProvider;
import tobyspring.hellospring.hellospring.payment.ExRateProvider;
import tobyspring.hellospring.hellospring.exrate.WebApiExRateProvider;
import tobyspring.hellospring.hellospring.payment.PaymentService;

import java.time.Clock;

@Configuration
public class ObjectFactory {
    @Bean
    PaymentService paymentService(){
        return new PaymentService(exRateProvider(), clock());
    }

    @Bean
    ExRateProvider exRateProvider(){
        return new WebApiExRateProvider();
    }

    @Bean
    ExRateProvider cachedExRateProvider(){
        return new CachedExRateProvider(exRateProvider());
    }

    @Bean
    OrderService orderService(){
        return new OrderService(exRateProvider());
    }

    @Bean
    Clock clock(){
        return Clock.systemDefaultZone();
    }
}

class OrderService{
    ExRateProvider exRateProvider;

    public OrderService(ExRateProvider exRateProvider) {
        this.exRateProvider = exRateProvider;
    }
}
