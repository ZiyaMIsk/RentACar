package com.turkcell.RentACar.core.utilites.mapping;


import org.modelmapper.ModelMapper;

public interface ModelMapperService {

	ModelMapper forRequest();

	ModelMapper forDto();
	

}
