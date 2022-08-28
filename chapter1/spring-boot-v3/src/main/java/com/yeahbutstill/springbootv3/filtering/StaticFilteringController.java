package com.yeahbutstill.springbootv3.filtering;

import com.yeahbutstill.springbootv3.entity.SomeBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StaticFilteringController {

    @GetMapping("/filtering")
    private SomeBean filtering() {
        return SomeBean.builder()
                .field("AAAAAAAAAAAAAAA")
                .field2("BBBBBBBBBBBBBB")
                .field3("CCCCCCCCCCCCCC")
                .build();
    }

}
