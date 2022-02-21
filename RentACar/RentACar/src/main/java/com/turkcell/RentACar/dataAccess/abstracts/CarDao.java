package com.turkcell.RentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turkcell.RentACar.entities.Car;

@Repository
public interface CarDao extends JpaRepository<Car, Integer>{
	
	boolean existsByCarName(String name);
	boolean existsByCarId(int id);
}
