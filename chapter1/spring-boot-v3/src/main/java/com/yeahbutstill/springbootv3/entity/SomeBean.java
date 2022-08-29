package com.yeahbutstill.springbootv3.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonFilter("SomeBeanFilter")
public class SomeBean {

    @NotNull
    @NotBlank
    @NotEmpty
    private String field1;

    @NotNull
    @NotBlank
    @NotEmpty
    private String field2;

    @NotNull
    @NotBlank
    @NotEmpty
    private String field3;

}
