package com.ikm.assessment.controller;


import com.ikm.assessment.common.contract.CommonResponse;
import com.ikm.assessment.common.contract.Response;
import com.ikm.assessment.contract.ShopDetailsRequest;
import com.ikm.assessment.contract.ShopDetailsResponse;
import com.ikm.assessment.model.ShopDetails;
import com.ikm.assessment.service.ShopService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/merchant")
@RequiredArgsConstructor
public class ShopController {

    private final ShopService merchantService;


    @SneakyThrows
    @Operation(summary = "Save merchant")
    @PostMapping(value = {"/save-merchant-details"})
    public ResponseEntity<?> saveMerchantDetails(@Valid @RequestBody ShopDetailsRequest request){
        CommonResponse response =
                merchantService.saveDetails(request);
        return new ResponseEntity<>(
                Response.<CommonResponse>builder()
                        .payload(response)
                        .message("Saved Successfully")
                        .build(),
                HttpStatus.CREATED);
    }
    @GetMapping("/fetch-by-merchant/{shopId}")
    public ResponseEntity<Response<ShopDetailsResponse>> getById(
            @PathVariable("shopId") UUID shopId) {
        return new ResponseEntity<>(
                Response.<ShopDetailsResponse>builder()
                        .payload(merchantService.getDetailsById(shopId))
                        .message("record fetched successfully.")
                        .build(),
                HttpStatus.OK);
    }
    @DeleteMapping("/deleteMerchant/{id}")
    public ResponseEntity<Response<Void>> deleteMerchant(@PathVariable("id") UUID id) {
        merchantService.deleteMerchant(id);
        return ResponseEntity.ok(
                Response.<Void>builder()
                        .message("Record deleted successfully.")
                        .build()
        );
    }
    @GetMapping("/MerchantList")
    public ResponseEntity<List<ShopDetails>> getAllMerchants() {
        return ResponseEntity.ok(merchantService.getAllMerchants());

    }

}
