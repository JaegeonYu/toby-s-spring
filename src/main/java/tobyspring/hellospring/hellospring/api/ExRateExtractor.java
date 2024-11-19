package tobyspring.hellospring.hellospring.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import tobyspring.hellospring.hellospring.exrate.ExRateData;

import java.math.BigDecimal;

public interface ExRateExtractor {
    public BigDecimal extractExRate(String response) throws JsonProcessingException;
}
