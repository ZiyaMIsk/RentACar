package com.turkcell.RentACar.api.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.RentACar.business.abstracts.BrandService;
import com.turkcell.RentACar.business.dtos.BrandDto;
import com.turkcell.RentACar.business.dtos.ListBrandDto;
import com.turkcell.RentACar.business.requests.CreateBrandRequest;






@RestController
@RequestMapping("/api/brands")
public class BrandsController {
	
	
	private BrandService brandService;

	@Autowired
	public BrandsController(BrandService brandService) {
		this.brandService = brandService;
	}
	
	@GetMapping("/listallbrands")
	public List<ListBrandDto> listAll(){
		return this.brandService.listAll();
	}
	
	@PostMapping("/createbrand")
	public void create(@RequestBody CreateBrandRequest createBrandRequest) throws Exception {
		this.brandService.create(createBrandRequest);
	}
	
	@GetMapping("/getbybrandid")
	public BrandDto getById(@RequestParam int brandId) throws Exception{
		return this.brandService.getById(brandId);
	}

}
