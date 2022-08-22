package com.yeahbutstill.rest.webservices.limitsservice.bean;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Limits {

    private Integer minimum;
    private Integer maximum;

}
