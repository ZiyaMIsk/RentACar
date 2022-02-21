package com.turkcell.RentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turkcell.RentACar.business.abstracts.CarService;
import com.turkcell.RentACar.business.dtos.car.CarDto;
import com.turkcell.RentACar.business.dtos.car.ListCarDto;
import com.turkcell.RentACar.business.exceptions.BusinessException;
import com.turkcell.RentACar.business.requests.create.CreateCarRequest;
import com.turkcell.RentACar.business.requests.delete.DeleteCarRequest;
import com.turkcell.RentACar.business.requests.update.UpdateCarRequest;
import com.turkcell.RentACar.core.utilites.mapping.abstracts.ModelMapperService;
import com.turkcell.RentACar.dataAccess.abstracts.CarDao;
import com.turkcell.RentACar.entities.Car;

@Service
public class CarManager implements CarService {
	
	private CarDao carDao;
	private ModelMapperService modelMapperService;
	
	@Autowired
	public CarManager(CarDao carDao, ModelMapperService modelMapperService) {
		this.carDao=carDao;
		this.modelMapperService=modelMapperService;
	}
	
	@Override
	public List<ListCarDto> listAll() {
		var result = this.carDao.findAll();
		List<ListCarDto> response = result.stream().map(car -> this.modelMapperService
				.forDto().map(car, ListCarDto.class)).collect(Collectors.toList());
		return response;
	}
	@Override
	public void create(CreateCarRequest createCarRequest) throws BusinessException {
		Car car = this.modelMapperService.forRequest().map(createCarRequest, Car.class);
		checkCarId(car.getCarId());
		this.carDao.save(car);
	}
	@Override
	public void update(UpdateCarRequest updateCarRequest) throws BusinessException {
		Car car = this.modelMapperService.forRequest().map(updateCarRequest, Car.class);
		checkCarId(updateCarRequest.getCarId());
		this.carDao.save(car);
	}
	
	@Override
	public void delete(DeleteCarRequest deleteCarRequest) throws BusinessException {
		Car car = this.modelMapperService.forRequest().map(deleteCarRequest, Car.class);
		checkCarId(car.getCarId());
		this.carDao.save(car);
	}
		
	@Override
	public CarDto getById(int carId) throws BusinessException {
		checkCarId(carId);
		Car result = this.carDao.getById(carId);
		CarDto response = this.modelMapperService.forDto().map(result, CarDto.class);
		return response;
	}
	
	private void checkCarName(Car car) throws BusinessException {
		if(this.carDao.existsByCarName(car.getCarName())){
			throw new BusinessException("Bu adda bir araba yoktur.");
		}
	}
	
	private void checkCarId(int carId) throws BusinessException {
		if(!this.carDao.existsByCarId(carId)){
			throw new BusinessException("Bu araba kiralandı.");
		}
	}
}
