package tobyspring.hellospring.hellospring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tobyspring.hellospring.hellospring.exrate.CachedExRateProvider;
import tobyspring.hellospring.hellospring.exrate.WebApiExRateProvider;
import tobyspring.hellospring.hellospring.payment.ExRateProvider;
import tobyspring.hellospring.hellospring.payment.ExRateProviderStub;
import tobyspring.hellospring.hellospring.payment.PaymentService;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;

@Configuration
public class TestObjectFactory {
    @Bean
    PaymentService paymentService(){
        return new PaymentService(exRateProvider(), clock());
    }

    @Bean
    ExRateProvider exRateProvider(){
        return new ExRateProviderStub(BigDecimal.valueOf(1_000));
    }

    @Bean
    Clock clock(){
        return Clock.fixed(Instant.now(), ZoneId.systemDefault());
    }
}
