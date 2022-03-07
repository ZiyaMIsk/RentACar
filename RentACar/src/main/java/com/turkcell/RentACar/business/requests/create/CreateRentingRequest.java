package com.turkcell.RentACar.business.requests.create;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRentingRequest {
	private LocalDate rentDate;
	private LocalDate returnDate;
	private  int customerId;
	private int carId;

}
