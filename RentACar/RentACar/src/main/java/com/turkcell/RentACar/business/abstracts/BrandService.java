package com.turkcell.RentACar.business.abstracts;

import java.util.List;

import com.turkcell.RentACar.business.dtos.brand.BrandDto;
import com.turkcell.RentACar.business.dtos.brand.ListBrandDto;
import com.turkcell.RentACar.business.exceptions.BusinessException;
import com.turkcell.RentACar.business.requests.create.CreateBrandRequest;
import com.turkcell.RentACar.business.requests.delete.DeleteBrandRequest;
import com.turkcell.RentACar.business.requests.update.UpdateBrandRequest;

public interface BrandService {

	List<ListBrandDto> listAll();
	void create(CreateBrandRequest createBrandRequest) throws BusinessException;
	void delete(DeleteBrandRequest deleteBrandRequest) throws BusinessException;
	void update(UpdateBrandRequest updateBrandRequest) throws BusinessException;
	BrandDto getById(int brandId) throws BusinessException;
}
