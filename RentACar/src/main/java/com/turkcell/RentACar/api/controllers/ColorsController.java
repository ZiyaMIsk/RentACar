package com.turkcell.RentACar.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.RentACar.business.abstracts.ColorService;
import com.turkcell.RentACar.business.dtos.ColorDto;
import com.turkcell.RentACar.business.dtos.ListColorDto;
import com.turkcell.RentACar.business.requests.CreateColorRequest;


@RestController
@RequestMapping
public class ColorsController {
	
	
	private ColorService colorService;
	
	
	@Autowired
	public ColorsController(ColorService colorService) {
		this.colorService=colorService;
	}
	
	@GetMapping("/listallcolors")
	public List<ListColorDto> listAll(){
		return this.colorService.listAll();
	}
	
	@PostMapping("/createcolor")
	public void create(@RequestBody CreateColorRequest createColorRequest) throws Exception {
		this.colorService.create(createColorRequest);
	}
	
	@GetMapping("/getbycolordid")
	public ColorDto getById (@RequestParam int colorId) throws Exception{
		return this.colorService.getById(colorId);
	}

}
