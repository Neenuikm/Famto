package com.ikm.assessment.service;

import com.ikm.assessment.common.contract.CommonResponse;
import com.ikm.assessment.common.exceptionHandler.NotFoundException;
import com.ikm.assessment.contract.CategoryDetailsRequest;
import com.ikm.assessment.contract.ShopDetailsRequest;
import com.ikm.assessment.contract.ShopDetailsResponse;
import com.ikm.assessment.model.CategoryDetails;
import com.ikm.assessment.model.ShopDetails;
import com.ikm.assessment.repository.CategoryRepository;
import com.ikm.assessment.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryService {

    private final CategoryRepository categoryRepository;

    private  final ModelMapper modelMapper = new ModelMapper();

    public CommonResponse saveDetails(CategoryDetailsRequest request){
        CategoryDetails categoryDetails=modelMapper.map(request, CategoryDetails.class);
        categoryRepository.save(categoryDetails);
        return CommonResponse.builder()
                .id(categoryDetails.getCategoryId())
                .name(categoryDetails.getName())
                .build();

    }

}
