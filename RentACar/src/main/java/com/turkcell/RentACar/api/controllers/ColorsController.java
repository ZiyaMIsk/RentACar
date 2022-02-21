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

import com.turkcell.RentACar.business.abstracts.ColorService;
import com.turkcell.RentACar.business.dtos.color.ColorDto;
import com.turkcell.RentACar.business.dtos.color.ListColorDto;
import com.turkcell.RentACar.business.exceptions.BusinessException;
import com.turkcell.RentACar.business.requests.create.CreateColorRequest;
import com.turkcell.RentACar.business.requests.delete.DeleteColorRequest;
import com.turkcell.RentACar.business.requests.update.UpdateColorRequest;

@RestController
@RequestMapping
public class ColorsController {
	
	private ColorService colorService;
	
	@Autowired
	public ColorsController(ColorService colorService) {
		this.colorService=colorService;
	}
	
	@GetMapping("/listall")
	public List<ListColorDto> listAll(){
		return this.colorService.listAll();
	}
	
	@PostMapping("/create")
	public void create(@RequestBody CreateColorRequest createColorRequest) throws BusinessException {
		this.colorService.create(createColorRequest);
	}
	
	@PutMapping("/update")
	public void update(@RequestParam UpdateColorRequest updateColorRequest) throws BusinessException {
		this.colorService.update(updateColorRequest);
	}
	
	@DeleteMapping("/delete")
    public void delete(@RequestBody DeleteColorRequest deleteColorRequest) throws BusinessException {
        this.colorService.delete(deleteColorRequest);
    }
	
	@GetMapping("/getbyid")
	public ColorDto getById (@RequestParam int colorId) throws BusinessException{
		return this.colorService.getById(colorId);
	}
}
