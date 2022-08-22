package com.yeahbutstill.rest.webservices.limitsservice.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Limits {

    private Integer minimum;
    private Integer maximum;

}
