package com.yeahbutstill.rest.webservices.limitsservice.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("limits-service")
@Getter
@Setter
public class Configuration {

    private Integer minimum;
    private Integer maximum;

}
