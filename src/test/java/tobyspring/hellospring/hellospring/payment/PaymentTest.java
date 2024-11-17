package tobyspring.hellospring.hellospring.payment;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.*;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.*;

class PaymentTest {

    @Test
    void createPrepared() throws IOException {
        Clock fixed = Clock.fixed(Instant.now(), ZoneId.systemDefault());
        ExRateProvider exRateProviderStub = new ExRateProviderStub(BigDecimal.valueOf(1_000));
        Payment payment = Payment.createPrepared(1L, "USD", BigDecimal.TEN, exRateProviderStub, LocalDateTime.now(fixed));

        Assertions.assertThat(payment.getConvertedAmount()).isEqualByComparingTo(BigDecimal.valueOf(10_000));
        Assertions.assertThat(payment.getValidUntil()).isEqualTo(LocalDateTime.now(fixed).plusMinutes(30));
    }

    @Test
    void isValid() throws IOException {
        Clock fixed = Clock.fixed(Instant.now(), ZoneId.systemDefault());
        ExRateProvider exRateProviderStub = new ExRateProviderStub(BigDecimal.valueOf(1_000));
        Payment payment = Payment.createPrepared(1L, "USD", BigDecimal.TEN, exRateProviderStub, LocalDateTime.now(fixed));

        Assertions.assertThat(payment.isValid(fixed)).isTrue();
        Assertions.assertThat(payment.isValid(Clock.offset(fixed, Duration.of(30, ChronoUnit.MINUTES)))).isFalse();
    }
}