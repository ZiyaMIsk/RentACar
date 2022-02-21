package com.turkcell.RentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turkcell.RentACar.business.abstracts.ColorService;
import com.turkcell.RentACar.business.dtos.color.ColorDto;
import com.turkcell.RentACar.business.dtos.color.ListColorDto;
import com.turkcell.RentACar.business.exceptions.BusinessException;
import com.turkcell.RentACar.business.requests.create.CreateColorRequest;
import com.turkcell.RentACar.business.requests.delete.DeleteColorRequest;
import com.turkcell.RentACar.business.requests.update.UpdateColorRequest;
import com.turkcell.RentACar.core.utilites.mapping.abstracts.ModelMapperService;
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
	public void create(CreateColorRequest createColorRequest) throws BusinessException {
		Color color = this.modelMapperService.forRequest().map(createColorRequest, Color.class);
		checkColorName(color);
		this.colorDao.save(color);	
	}
	
	@Override
	public void update(UpdateColorRequest updateColorRequest) throws BusinessException {
		Color color = this.modelMapperService.forRequest().map(updateColorRequest, Color.class);
		checkColorId(updateColorRequest.getColorId());
		this.colorDao.save(color);
	}
	
	@Override
	public void delete(DeleteColorRequest deleteColorRequest) throws BusinessException {
		Color color = this.modelMapperService.forRequest().map(deleteColorRequest, Color.class);
        checkColorName(color);
        this.colorDao.delete(color);    	
	}
	
	@Override
	public ColorDto getById(int colorId) throws BusinessException {
		checkColorId(colorId);
		Color result = this.colorDao.getById(colorId);
		ColorDto response = this.modelMapperService.forDto().map(result, ColorDto.class);
		return response;
	}
		
	private void checkColorName(Color color) throws BusinessException {
		if(this.colorDao.existsByColorName(color.getColorName())) {
			throw new BusinessException("Bu renk bulunmamaktadır.");
		}
	}
	
	private void checkColorId(int colorId) throws BusinessException {
		if(!this.colorDao.existsByColorId(colorId)){
			throw new BusinessException("Böyle bir renk yoktur.");
		}
	}
}
