package com.product.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.product.dto.VariantValueDto;
import com.product.entity.ProductAttributeValue;
import com.product.entity.ProductVariant;
import com.product.entity.VariantValue;
import com.product.exception.ProductException;
import com.product.repository.ProductAttributeValueRepo;
import com.product.repository.ProductVariantRepo;
import com.product.repository.VariantValueRepo;
import com.product.request.AddVariantValueRequest;
import com.product.service.VariantValueService;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

@Service
public class VariantValueServiceImp implements VariantValueService {

    @Autowired
    private VariantValueRepo vvrepo;

    @Autowired
    private ProductVariantRepo pvrepo;

    @Autowired
    private ProductAttributeValueRepo avrepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public VariantValueDto addVariantValue(AddVariantValueRequest request) {
        ProductVariant variant =pvrepo.findById(request.getProductVariantId()).orElseThrow(() -> new ProductException("Product Variant Not Found!",HttpStatus.NOT_FOUND));
               
        VariantValue variantValue = null;
        for(String valuename: request.getValueName()) {
        	ProductAttributeValue attributeValue=avrepo.findByValueName(valuename).orElseThrow(()->new ProductException("Product Attribute Value Not Found!", HttpStatus.NOT_FOUND));
        	variantValue=new VariantValue();
        	variantValue.setProductVariant(variant);
        	variantValue.setProductattributevalue(attributeValue);
        	variantValue=vvrepo.save(variantValue);
        }
        VariantValueDto dto = new VariantValueDto();
        dto.setVariantValueId(variantValue.getVariantValueId());
        dto.setProductVariantId(variantValue.getProductVariant().getProductVariantId());
        dto.setAttributeValueId(variantValue.getProductattributevalue().getAttributeValueId());
        return dto;
    }

	@Override
	public List<VariantValueDto> getVariantValueById(Integer productVariantId) {
		List<VariantValue> variantValue=vvrepo.findByProductVariant_ProductVariantId(productVariantId);
		if(variantValue.isEmpty()) {
			throw new ProductException("Variant Values Not Found!", HttpStatus.NOT_FOUND);
		}
		return variantValue.stream().map(value->{
			VariantValueDto vvdto=new VariantValueDto();
			vvdto.setVariantValueId(value.getVariantValueId());
			vvdto.setAttributeValueId(value.getProductattributevalue().getAttributeValueId());
			vvdto.setProductVariantId(value.getProductVariant().getProductVariantId());
			return vvdto;
		}).toList();
	}

//    @Override
//    public VariantValueDto getVariantValueById(Integer variantValueId) {
//
//        VariantValue variantValue =vvrepo.findById(variantValueId).orElseThrow(() -> new ProductException("Variant Value Not Found!",HttpStatus.NOT_FOUND));
//
//        VariantValueDto dto = new VariantValueDto();
//
//        dto.setVariantValueId(variantValue.getVariantValueId());
//        dto.setProductVariantId(variantValue.getProductVariant().getProductVariantId());
//        dto.setAttributeValueId(variantValue.getProductattributevalue().getAttributeValueId());
//
//        return dto;
//    }
}