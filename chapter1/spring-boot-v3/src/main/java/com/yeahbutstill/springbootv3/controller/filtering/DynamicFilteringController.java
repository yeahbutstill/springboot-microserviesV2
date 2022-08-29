package com.yeahbutstill.springbootv3.controller.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.yeahbutstill.springbootv3.entity.SomeBean;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class DynamicFilteringController {

    @GetMapping("/filtering")
    public MappingJacksonValue filtering() {

        SomeBean someBean = new SomeBean("AAAAAAAAAAAAAAA", "BBBBBBBBBBBBBB", "CCCCCCCCCCCCCC");
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field3");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;

    }

    @GetMapping("/filtering-list")
    public MappingJacksonValue filteringList() {

        List<SomeBean> list = Arrays.asList(
                SomeBean.builder()
                        .field1("0AAAAAAAAAAAAAAA")
                        .field2("0BBBBBBBBBBBBBB")
                        .field3("0CCCCCCCCCCCCCC")
                        .build(),
                SomeBean.builder()
                        .field1("1AAAAAAAAAAAAAAA")
                        .field2("2BBBBBBBBBBBBBB")
                        .field3("3CCCCCCCCCCCCCC")
                        .build()
        );

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(list);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2", "field3");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
        mappingJacksonValue.setFilters(filters);

        return mappingJacksonValue;

    }

}
