package com.turkcell.RentACar.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.RentACar.business.abstracts.BrandService;
import com.turkcell.RentACar.business.dtos.brand.BrandDto;
import com.turkcell.RentACar.business.dtos.brand.ListBrandDto;
import com.turkcell.RentACar.business.exceptions.BusinessException;
import com.turkcell.RentACar.business.requests.create.CreateBrandRequest;
import com.turkcell.RentACar.business.requests.delete.DeleteBrandRequest;
import com.turkcell.RentACar.business.requests.update.UpdateBrandRequest;

@RestController
@RequestMapping("/api/brands")
public class BrandsController {
	
	private BrandService brandService;

	@Autowired
	public BrandsController(BrandService brandService) {
		this.brandService = brandService;
	}
	
	@GetMapping("/listall")
	public List<ListBrandDto> listAll(){
		return this.brandService.listAll();
	}
	
	@PostMapping("/create")
	public void create(@RequestBody CreateBrandRequest createBrandRequest) throws BusinessException {
		this.brandService.create(createBrandRequest);
	}
	
	@PutMapping("/update")
	public void update(@RequestParam UpdateBrandRequest updateBrandRequest) throws BusinessException {
		this.brandService.update(updateBrandRequest);
	}
	
	@DeleteMapping("/delete")
    public void delete(@RequestBody DeleteBrandRequest deleteBrandRequest) throws BusinessException {
        this.brandService.delete(deleteBrandRequest);
    }
	@GetMapping("/getbyid")
	public BrandDto getById(@RequestParam int brandId) throws BusinessException{
		return this.brandService.getById(brandId);
	}	
}
