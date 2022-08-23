package com.yeahbutstill.currencyexchangeservice.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@SQLDelete(sql = "UPDATE currency_exchange SET status_record='INACTIVE' WHERE id=?")
@Where(clause = "status_record='ACTIVE'")
public class CurrencyExchange extends BaseEntity {

    @Column(name = "currency_from")
    private String from;

    @Column(name = "currency_to")
    private String to;

    private BigDecimal conversionMultiple;
    private String environment;

}
