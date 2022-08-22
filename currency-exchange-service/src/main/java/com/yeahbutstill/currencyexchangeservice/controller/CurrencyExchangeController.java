package com.yeahbutstill.currencyexchangeservice.controller;

import com.yeahbutstill.currencyexchangeservice.bean.CurrencyExchange;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@Slf4j
@RestController
@RequestMapping("/currency-xchange/api/v1")
public class CurrencyExchangeController {

    @Autowired
    private Environment environment;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange currencyExchange(@PathVariable String from, @PathVariable String to) {

        return CurrencyExchange.builder()
                .id(1000L)
                .from(from)
                .to(to)
                .conversionMultiple(BigDecimal.valueOf(0.000067041269))
                .environment(environment.getProperty("local.server.port"))
                .build();

    }

}
