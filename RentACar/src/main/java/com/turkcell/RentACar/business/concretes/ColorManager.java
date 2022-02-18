package com.turkcell.RentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turkcell.RentACar.business.abstracts.ColorService;
import com.turkcell.RentACar.business.dtos.ColorDto;
import com.turkcell.RentACar.business.dtos.ListColorDto;
import com.turkcell.RentACar.business.requests.CreateColorRequest;
import com.turkcell.RentACar.core.utilites.mapping.ModelMapperService;
import com.turkcell.RentACar.dataAccess.abstracts.ColorDao;
import com.turkcell.RentACar.entities.Color;

@Service
public class ColorManager implements ColorService{

	private ColorDao colorDao;
	private ModelMapperService modelMapperService;
	
	@Autowired
	public ColorManager(ColorDao colorDao, ModelMapperService modelMapperService) {
		this.colorDao = colorDao;
		this.modelMapperService = modelMapperService;
	}
	@Override
	public List<ListColorDto> listAll() {
		var result = this.colorDao.findAll();
		
		List<ListColorDto> response = result.stream().map(color -> this.modelMapperService
				.forDto().map(color, ListColorDto.class)).collect(Collectors.toList());
		return response;
	}
	@Override
	public void create(CreateColorRequest createColorRequest) throws Exception {
		Color color = this.modelMapperService.forRequest().map(createColorRequest, Color.class);
		checkColorName(createColorRequest);
		this.colorDao.save(color);
		
	}
	@Override
	public ColorDto getById(int colorId) throws Exception {
		checkColorId(colorId);
		Color result = this.colorDao.getById(colorId);
		ColorDto response = this.modelMapperService.forDto().map(result, ColorDto.class);
		return response;
	}
	
	private void checkColorName(CreateColorRequest createColorRequest) throws Exception {
		if(this.colorDao.existsByColorName(createColorRequest.getColorName())) {
			throw new Exception("Bu renk bulunmamaktadır.");
		}
	}
	
	private void checkColorId(int colorId) throws Exception {
		if(!this.colorDao.existsByColorId(colorId)){
			throw new Exception("Böyle bir renk yoktur.");
		}
	}

}
