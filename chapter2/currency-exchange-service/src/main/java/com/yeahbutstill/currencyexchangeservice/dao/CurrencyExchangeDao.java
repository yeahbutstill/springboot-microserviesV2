package com.yeahbutstill.currencyexchangeservice.dao;

import com.yeahbutstill.currencyexchangeservice.bean.CurrencyExchange;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyExchangeDao extends PagingAndSortingRepository<CurrencyExchange, String > {

    CurrencyExchange findByFromAndTo(String from, String to);

}
