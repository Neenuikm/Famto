package com.ikm.assessment.contract;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDetailsRequest {

    private UUID categoryId;
    private String name;
}
