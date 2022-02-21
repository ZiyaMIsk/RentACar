package com.turkcell.RentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turkcell.RentACar.business.abstracts.BrandService;
import com.turkcell.RentACar.business.dtos.brand.BrandDto;
import com.turkcell.RentACar.business.dtos.brand.ListBrandDto;
import com.turkcell.RentACar.business.exceptions.BusinessException;
import com.turkcell.RentACar.business.requests.create.CreateBrandRequest;
import com.turkcell.RentACar.business.requests.delete.DeleteBrandRequest;
import com.turkcell.RentACar.business.requests.update.UpdateBrandRequest;
import com.turkcell.RentACar.core.utilites.mapping.abstracts.ModelMapperService;
import com.turkcell.RentACar.dataAccess.abstracts.BrandDao;
import com.turkcell.RentACar.entities.Brand;

@Service
public class BrandManager implements BrandService {
	
	private BrandDao brandDao;
	private ModelMapperService modelMapperService;
	
	@Autowired
	public BrandManager(BrandDao brandDao, ModelMapperService modelMapperService) {
		this.brandDao=brandDao;
		this.modelMapperService=modelMapperService;
	}
	
	@Override
	public List<ListBrandDto> listAll() {
		var result = this.brandDao.findAll();
		List<ListBrandDto> response = result.stream().map(brand -> this.modelMapperService
				.forDto().map(brand, ListBrandDto.class)).collect(Collectors.toList());
		return response;
	}
	
	@Override
	public void create(CreateBrandRequest createBrandRequest) throws BusinessException {
		Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);
		checkBrandName(brand);
		this.brandDao.save(brand);
	}
	
	@Override
	public void update(UpdateBrandRequest updateBrandRequest) throws BusinessException {
		Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
		checkBrandId(updateBrandRequest.getBrandId());
		this.brandDao.save(brand);
	}
	
	@Override
    public void delete(DeleteBrandRequest deleteBrandRequest) throws BusinessException {
        Brand brand = this.modelMapperService.forRequest().map(deleteBrandRequest, Brand.class);
        checkBrandName(brand);
        this.brandDao.delete(brand);
    }
	
	@Override
	public BrandDto getById(int brandId) throws BusinessException {
		checkBrandId(brandId);
		Brand result = this.brandDao.getById(brandId);
		BrandDto response = this.modelMapperService.forDto().map(result, BrandDto.class);
		return response;
	}
		
	private void checkBrandName(Brand brand) throws BusinessException {
		if(this.brandDao.existsByBrandName(brand.getBrandName())) {
			throw new BusinessException("Bu marka alınmıştır.");
		}
	}
	
	private void checkBrandId(int brandId) throws BusinessException {
		if(!this.brandDao.existsByBrandId(brandId)){
			throw new BusinessException("Bu marka kiralandı maalesef.");
		}
	}
}
