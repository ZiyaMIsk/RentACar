package com.turkcell.RentACar.business.abstracts;

import java.util.List;

import com.turkcell.RentACar.business.dtos.car.CarDto;
import com.turkcell.RentACar.business.dtos.car.ListCarDto;
import com.turkcell.RentACar.business.exceptions.BusinessException;
import com.turkcell.RentACar.business.requests.create.CreateCarRequest;
import com.turkcell.RentACar.business.requests.delete.DeleteCarRequest;
import com.turkcell.RentACar.business.requests.update.UpdateCarRequest;

public interface CarService {
	
	List<ListCarDto> listAll();
	void create(CreateCarRequest createCarRequest) throws BusinessException;
	void update(UpdateCarRequest updateCarRequest) throws BusinessException;
	void delete(DeleteCarRequest deleteCarRequest) throws BusinessException;
	CarDto getById(int carId) throws BusinessException;

}
