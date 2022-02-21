package com.turkcell.RentACar.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="cars")
@Entity
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="car_id")
	private int carId;
	
	@Column(name="car_name")
	private String carName;
	
	@Column(name="daily_price")
	private double dailyPrice;
	
	@Column(name="model_Year")
	private int modelYear;
	
	@Column(name="description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name="brand_id")
	private Brand brand;

	@OneToMany(mappedBy = "car")
	private List<Color> colors;
	
}
