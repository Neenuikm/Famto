package com.ikm.assessment.service;

import com.ikm.assessment.common.contract.CommonResponse;
import com.ikm.assessment.common.exceptionHandler.NotFoundException;
import com.ikm.assessment.contract.ShopDetailsRequest;
import com.ikm.assessment.contract.ShopDetailsResponse;
import com.ikm.assessment.model.ShopDetails;
import com.ikm.assessment.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ShopService {

    private final ShopRepository shopRepository;

    private  final ModelMapper modelMapper = new ModelMapper();

    public CommonResponse saveDetails(ShopDetailsRequest request){

        ShopDetails shopDetails;

        if (shopRepository.existsByRegistrationNumber(request.getRegistrationNumber())) {
            throw new IllegalArgumentException("Registration number already exists");
        }
        shopDetails = modelMapper.map(request, ShopDetails.class);
        shopRepository.save(shopDetails);
        return CommonResponse.builder()
                .id(shopDetails.getShopId())
                .name(shopDetails.getOwnerName())
                .build();

    }

    public ShopDetailsResponse getDetailsById(UUID shopId) {
        return mapToResponse(
                shopRepository
                        .findById(shopId)
                        .orElseThrow(() -> new NotFoundException(shopId)));
    }

    private ShopDetailsResponse mapToResponse(ShopDetails details) {
        ShopDetailsResponse response =
                modelMapper.map(details, ShopDetailsResponse.class);

        return response;
    }

    public void deleteMerchant(UUID id) {
        shopRepository.deleteById(id);
    }

    public List<ShopDetails> getAllMerchants() {
        return shopRepository.findAll();

    }
}
