package com.yeahbutstill.currencyexchangeservice.controller;

import com.yeahbutstill.currencyexchangeservice.bean.CurrencyExchange;
import com.yeahbutstill.currencyexchangeservice.dao.CurrencyExchangeDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/yeahbutstill/api/v1")
public class CurrencyExchangeController {

    @Autowired
    private CurrencyExchangeDao dao;
    @Autowired
    private Environment environment;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {

        CurrencyExchange currencyExchange = dao.findByFromAndTo(from, to);
        if (currencyExchange == null) {
            throw new RuntimeException("Unable to Find data for " + from + " to " + to);
        }
        String port = environment.getProperty("local.server.port");
        currencyExchange.setEnvironment(port);

        return currencyExchange;
    }

}
