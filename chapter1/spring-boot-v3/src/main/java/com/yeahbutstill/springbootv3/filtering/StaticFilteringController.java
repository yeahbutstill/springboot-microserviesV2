package com.yeahbutstill.springbootv3.filtering;

import com.yeahbutstill.springbootv3.entity.SomeBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

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

    @GetMapping("/filtering-list")
    private List<SomeBean> filteringList() {
        return Arrays.asList(
                SomeBean.builder()
                    .field("0AAAAAAAAAAAAAAA")
                    .field2("0BBBBBBBBBBBBBB")
                    .field3("0CCCCCCCCCCCCCC")
                    .build(),
                SomeBean.builder()
                        .field("1AAAAAAAAAAAAAAA")
                        .field2("2BBBBBBBBBBBBBB")
                        .field3("3CCCCCCCCCCCCCC")
                        .build()
        );
    }

}
