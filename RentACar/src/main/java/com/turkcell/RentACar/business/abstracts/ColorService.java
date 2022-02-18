package com.turkcell.RentACar.business.abstracts;

import java.util.List;

import com.turkcell.RentACar.business.dtos.ColorDto;
import com.turkcell.RentACar.business.dtos.ListColorDto;
import com.turkcell.RentACar.business.requests.CreateColorRequest;

public interface ColorService {
	
	List<ListColorDto> listAll();
	void create(CreateColorRequest createColorRequest) throws Exception;
	ColorDto getById(int colorId) throws Exception;

}
