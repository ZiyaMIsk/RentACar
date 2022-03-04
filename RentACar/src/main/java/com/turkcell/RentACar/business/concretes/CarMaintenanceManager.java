package com.turkcell.RentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turkcell.RentACar.business.abstracts.CarMaintenanceService;
import com.turkcell.RentACar.business.dtos.brand.BrandDto;
import com.turkcell.RentACar.business.dtos.brand.ListBrandDto;
import com.turkcell.RentACar.business.dtos.carMaintenance.CarMaintenanceDto;
import com.turkcell.RentACar.business.dtos.carMaintenance.ListCarMaintenanceDto;
import com.turkcell.RentACar.business.requests.create.CreateBrandRequest;
import com.turkcell.RentACar.business.requests.create.CreateCarMaintenanceRequest;
import com.turkcell.RentACar.business.requests.update.UpdateBrandRequest;
import com.turkcell.RentACar.business.requests.update.UpdateCarMaintenanceRequest;
import com.turkcell.RentACar.core.utilites.mapping.abstracts.ModelMapperService;
import com.turkcell.RentACar.core.utilites.results.DataResult;
import com.turkcell.RentACar.core.utilites.results.ErrorDataResult;
import com.turkcell.RentACar.core.utilites.results.ErrorResult;
import com.turkcell.RentACar.core.utilites.results.Result;
import com.turkcell.RentACar.core.utilites.results.SuccessDataResult;
import com.turkcell.RentACar.core.utilites.results.SuccessResult;
import com.turkcell.RentACar.dataAccess.abstracts.CarMaintenanceDao;
import com.turkcell.RentACar.entities.Brand;
import com.turkcell.RentACar.entities.CarMaintenance;

@Service
public class CarMaintenanceManager implements CarMaintenanceService {

	private CarMaintenanceDao carMaintenanceDao;
	private ModelMapperService modelMapperService;
	

	@Autowired
	public CarMaintenanceManager(CarMaintenanceDao carMaintenanceDao, ModelMapperService modelMapperService) {
		this.carMaintenanceDao=carMaintenanceDao;
		this.modelMapperService=modelMapperService;
	}
	
	@Override     
	public DataResult<List<ListCarMaintenanceDto>> listAll() { 
		List<CarMaintenance> carMaintenanceList = this.carMaintenanceDao.findAll();  
		List<ListCarMaintenanceDto> response = carMaintenanceList.stream()                 
				.map(carMaintenance -> modelMapperService.forDto().map(carMaintenance, ListCarMaintenanceDto.class))    
				.collect(Collectors.toList());          
		return new SuccessDataResult<List<ListCarMaintenanceDto>>(response);   
		
		}

	@Override    
	public Result create(CreateCarMaintenanceRequest createCarMaintananceRequest) {  
		
		CarMaintenance carMaintanance = this.modelMapperService.forRequest().map(createCarMaintananceRequest,     
				CarMaintenance.class);                    
		this.carMaintenanceDao.save(carMaintanance);         
		return new SuccessResult("eklendi.");    
		}

	
	@Override
	public Result update(UpdateCarMaintenanceRequest updateCarMaintenanceRequest) {
		if (!checkBrandId(updateBrandRequest.getBrandId()).isSuccess()) {
			return new ErrorResult(checkBrandId(updateBrandRequest.getBrandId()).getMessage());
		}
		if (!checkBrandName(updateBrandRequest.getBrandName()).isSuccess()) {
			return new ErrorResult(checkBrandName(updateBrandRequest.getBrandName()).getMessage());
		}
		Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
		this.brandDao.save(brand);
		return new SuccessDataResult<UpdateBrandRequest>(updateBrandRequest,
				"Data updated to: " + brand.getBrandName());
	}

	@Override
	public Result delete(int carMaintenanceId) {
		if (!checkBrandId(brandId).isSuccess()) {
			return new ErrorResult(checkBrandId(brandId).getMessage());
		}
		String brandNameBeforeDelete = this.brandDao.findByBrandId(brandId).getBrandName();
		this.brandDao.deleteById(brandId);
		return new SuccessResult("Data deleted : " + brandNameBeforeDelete);
	}

	@Override
	public DataResult<CarMaintenanceDto> getAllByCarId(int id) {
		if (!checkBrandId(brandId).isSuccess()) {
			return new ErrorDataResult<BrandDto>(checkBrandId(brandId).getMessage());
		}
		Brand brand = this.brandDao.getById(brandId);
		BrandDto brandDto = this.modelMapperService.forDto().map(brand, BrandDto.class);
		return new SuccessDataResult<BrandDto>(brandDto, "Data getted by id");
	}

}
