package tobyspring.hellospring.hellospring;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.math.BigDecimal;

public class Client {
    public static void main(String[] args) throws IOException {
//        PaymentService paymentService = new WebApiExRatePaymentService();


        ObjectFactory objectFactory = new ObjectFactory();
        PaymentService paymentService = objectFactory.paymentService();
        Payment payment = paymentService.prepare(100L, "USD", BigDecimal.valueOf(50.7));
        System.out.println(payment);
    }
}
