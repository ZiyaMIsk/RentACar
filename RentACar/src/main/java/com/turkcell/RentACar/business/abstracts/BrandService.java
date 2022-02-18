package com.turkcell.RentACar.business.abstracts;

import java.util.List;

import com.turkcell.RentACar.business.dtos.BrandDto;
import com.turkcell.RentACar.business.dtos.ListBrandDto;
import com.turkcell.RentACar.business.requests.CreateBrandRequest;

public interface BrandService {

	List<ListBrandDto> listAll();

	void create(CreateBrandRequest createBrandRequest) throws Exception;

	BrandDto getById(int brandId) throws Exception;


}
