package com.turkcell.RentACar.business.requests.create;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarRequest {
	
	private String carName;
	private double dailyPrice;
	private int modelYear;
	private String description;
	private int brandId;
	private int colorId;
}
