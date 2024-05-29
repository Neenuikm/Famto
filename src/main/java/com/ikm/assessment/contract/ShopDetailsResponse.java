package com.ikm.assessment.contract;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShopDetailsResponse {

    private String shopName;
    private String phoneNumber;
    private String ownerName;
    private String registrationNumber;


}
