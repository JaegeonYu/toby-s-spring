package tobyspring.hellospring.hellospring.exrate;

import tobyspring.hellospring.hellospring.api.*;
import tobyspring.hellospring.hellospring.payment.ExRateProvider;

import java.math.BigDecimal;

public class WebApiExRateProvider implements ExRateProvider {
    public WebApiExRateProvider(ApiTemplate apiTemplate) {
        this.apiTemplate = apiTemplate;
    }

    private final ApiTemplate apiTemplate;
    @Override
    public BigDecimal getExRate(String currency) {

        String url = "https://open.er-api.com/v6/latest/" + currency;
        return apiTemplate.getForExRate(url);

    }
}
