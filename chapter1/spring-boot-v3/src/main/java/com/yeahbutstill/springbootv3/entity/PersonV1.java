package com.yeahbutstill.springbootv3.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class PersonV1 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotEmpty
    @NotBlank
    @NotNull
    private String id;

    @NotNull
    @NotBlank
    @NotEmpty
    private String firstName;

}
