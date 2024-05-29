package com.ikm.assessment.controller;


import com.ikm.assessment.common.contract.CommonResponse;
import com.ikm.assessment.common.contract.Response;
import com.ikm.assessment.contract.CategoryDetailsRequest;
import com.ikm.assessment.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService service;


    @SneakyThrows
    @Operation(summary = "Save category")
    @PostMapping(value = {"/save-category-details"})
    public ResponseEntity<?> saveCategoryDetails(@Valid @RequestBody CategoryDetailsRequest request){
        CommonResponse response =
                service.saveDetails(request);
        return new ResponseEntity<>(
                Response.<CommonResponse>builder()
                        .payload(response)
                        .message("Saved Successfully")
                        .build(),
                HttpStatus.CREATED);
    }

}
