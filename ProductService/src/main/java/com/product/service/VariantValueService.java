package com.product.service;

import java.util.List;

import com.product.dto.VariantValueDto;
import com.product.request.AddVariantValueRequest;

public interface VariantValueService {

    VariantValueDto addVariantValue(AddVariantValueRequest request);

    List<VariantValueDto> getVariantValueById(Integer productVariantId);

}