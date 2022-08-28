package com.yeahbutstill.springbootv3.entity.versioning;

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
public class Name {

    @NotEmpty
    @NotBlank
    @NotNull
    private String firstName;

    @NotEmpty
    @NotBlank
    @NotNull
    private String lastName;

}
