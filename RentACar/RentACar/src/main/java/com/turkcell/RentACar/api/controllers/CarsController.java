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

import com.turkcell.RentACar.business.abstracts.CarService;
import com.turkcell.RentACar.business.dtos.car.CarDto;
import com.turkcell.RentACar.business.dtos.car.ListCarDto;
import com.turkcell.RentACar.business.exceptions.BusinessException;
import com.turkcell.RentACar.business.requests.create.CreateCarRequest;
import com.turkcell.RentACar.business.requests.delete.DeleteCarRequest;
import com.turkcell.RentACar.business.requests.update.UpdateCarRequest;



@RestController
@RequestMapping("/api/cars")
public class CarsController {
	
	private CarService carService;

	@Autowired
	public CarsController(CarService carService) {
		this.carService = carService;
	}
	
	@GetMapping("/listall")
	public List<ListCarDto> listAll(){
		return this.carService.listAll();
	}
	
	@PostMapping("/create")
	public void create(@RequestBody CreateCarRequest createCarRequest) throws BusinessException {
		this.carService.create(createCarRequest);
	}
	@PutMapping("/update")
	public void update(@RequestBody UpdateCarRequest updateCarRequest) throws BusinessException {
		this.carService.update(updateCarRequest);
	}
		
	@DeleteMapping("/deletecar")
    public void delete(@RequestBody DeleteCarRequest deleteCarRequest) throws BusinessException {
        this.carService.delete(deleteCarRequest);
    }
	
	@GetMapping("/getbyid")
	public CarDto getById(@RequestParam int carId) throws Exception{
		return this.carService.getById(carId);
	}
	
}
