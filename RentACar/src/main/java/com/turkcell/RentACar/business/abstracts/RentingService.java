package com.turkcell.RentACar.business.abstracts;

import com.turkcell.RentACar.business.requests.create.CreateRentingRequest;
import com.turkcell.RentACar.core.utilites.results.Result;

public interface RentingService {
	
	Result create(CreateRentingRequest createRentingRequest);
	

}
