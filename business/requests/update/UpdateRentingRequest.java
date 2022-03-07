package com.turkcell.RentACar.business.requests.update;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRentingRequest {
	
	@NotNull
	private int id;
	@NotNull
	private LocalDate rentDate;
	@Nullable
	private LocalDate returnDate;
	@NotNull
	private int customerId;
	@NotNull
	private int carId;

}
