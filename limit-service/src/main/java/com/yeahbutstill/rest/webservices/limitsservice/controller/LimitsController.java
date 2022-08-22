package com.yeahbutstill.rest.webservices.limitsservice.controller;

import com.yeahbutstill.rest.webservices.limitsservice.bean.Limits;
import com.yeahbutstill.rest.webservices.limitsservice.configuration.Configuration;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/limits/api/v1")
@RequiredArgsConstructor
public class LimitsController {


    private final Configuration configuration;

    @GetMapping("/limits")
    public Limits retrieveLimits() {

        return Limits.builder()
                .minimum(configuration.getMinimum())
                .maximum(configuration.getMaximum())
                .build();

    }

}
