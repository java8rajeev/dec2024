package com.rajeev.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rajeev.model.District;

public interface DistrictRepo extends JpaRepository<District,Long>{
	   List<District> findByStateStateId(Long stateId);
    
}
