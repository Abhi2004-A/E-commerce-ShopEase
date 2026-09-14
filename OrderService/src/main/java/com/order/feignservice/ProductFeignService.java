package com.order.feignservice;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.order.response.ApiResponse;

@FeignClient(name="ProductService", url = "http://localhost:8082/product")
public interface ProductFeignService {
	
	@GetMapping("/getproduct")
	public List<ApiResponse> getAllProduct();

}
