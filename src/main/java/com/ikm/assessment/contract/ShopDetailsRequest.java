package com.ikm.assessment.contract;

import jakarta.validation.constraints.*;
import lombok.*;

import java.util.UUID;


@Builder
@Getter
@AllArgsConstructor
public class ShopDetailsRequest {

    private UUID shopId;

    @NotBlank(message = "shopName cannot be empty")
    private String shopName;
    @NotBlank(message = "phoneNumber cannot be empty")
    private String phoneNumber;
    @NotBlank(message = "ownerName cannot be empty")
    private String ownerName;
    @NotBlank(message = "registrationNumber cannot be empty")
    private String registrationNumber;

    private final CategoryDetailsRequest categoryDetailsRequest;

}
