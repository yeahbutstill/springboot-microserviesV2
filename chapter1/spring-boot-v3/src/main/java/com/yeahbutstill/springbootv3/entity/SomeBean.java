package com.yeahbutstill.springbootv3.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties({"field", "field"})
public class SomeBean {

    @NotNull
    @NotBlank
    @NotEmpty
    private String field;

    @NotNull
    @NotBlank
    @NotEmpty
    private String field2;

    @NotNull
    @NotBlank
    @NotEmpty
    private String field3;

}
