package tobyspring.hellospring.hellospring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tobyspring.hellospring.hellospring.exrate.CachedExRateProvider;
import tobyspring.hellospring.hellospring.exrate.WebApiExRateProvider;
import tobyspring.hellospring.hellospring.payment.ExRateProvider;
import tobyspring.hellospring.hellospring.payment.ExRateProviderStub;
import tobyspring.hellospring.hellospring.payment.PaymentService;

import java.math.BigDecimal;

@Configuration
public class TestObjectFactory {
    @Bean
    PaymentService paymentService(){
        return new PaymentService(exRateProvider());
    }

    @Bean
    ExRateProvider exRateProvider(){
        return new ExRateProviderStub(BigDecimal.valueOf(1_000));
    }


}
