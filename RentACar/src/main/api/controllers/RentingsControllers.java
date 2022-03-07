package com.turkcell.RentACar.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.RentACar.business.abstracts.RentingService;
import com.turkcell.RentACar.business.requests.create.CreateRentingRequest;
import com.turkcell.RentACar.core.utilites.results.Result;

@RestController
@RequestMapping("/api/rentings")
public class RentingsControllers {

	private RentingService rentingService;
	
	@Autowired
	public RentingsControllers(RentingService rentingService) {
		this.rentingService=rentingService;
	}
	
	
	@PostMapping("/create")
	public Result create(@RequestBody CreateRentingRequest createRentingRequest){
		return this.rentingService.create(createRentingRequest);
	}
	
	
	
}
