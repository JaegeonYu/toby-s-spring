package tobyspring.hellospring.hellospring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import tobyspring.hellospring.hellospring.api.ApiTemplate;
import tobyspring.hellospring.hellospring.exrate.CachedExRateProvider;
import tobyspring.hellospring.hellospring.exrate.RestTemplateExRateProvider;
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
    ApiTemplate apiTemplate(){
        return new ApiTemplate();
    }

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
    @Bean
    ExRateProvider exRateProvider(){
        return new RestTemplateExRateProvider(restTemplate());
    }

    @Bean
    ExRateProvider cachedExRateProvider(){
        return new CachedExRateProvider(exRateProvider());
    }


    @Bean
    Clock clock(){
        return Clock.systemDefaultZone();
    }
}


