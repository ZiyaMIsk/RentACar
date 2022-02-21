package com.turkcell.RentACar.business.abstracts;

import java.util.List;

import com.turkcell.RentACar.business.dtos.color.ColorDto;
import com.turkcell.RentACar.business.dtos.color.ListColorDto;
import com.turkcell.RentACar.business.exceptions.BusinessException;
import com.turkcell.RentACar.business.requests.create.CreateColorRequest;
import com.turkcell.RentACar.business.requests.delete.DeleteColorRequest;
import com.turkcell.RentACar.business.requests.update.UpdateColorRequest;

public interface ColorService {
	
	List<ListColorDto> listAll();
	void create(CreateColorRequest createColorRequest) throws BusinessException;
	void delete(DeleteColorRequest deleteColorRequest) throws BusinessException;
	void update(UpdateColorRequest updateColorRequest) throws BusinessException;
	ColorDto getById(int colorId) throws BusinessException;

}
