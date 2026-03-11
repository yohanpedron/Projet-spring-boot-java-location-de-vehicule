package com.accenture.repository;

import com.accenture.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleDao extends JpaRepository<Vehicle,Integer> {
}
