package com.rajeev.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rajeev.model.District;
import com.rajeev.repo.DistrictRepo;
import com.rajeev.service.DistrictService;

@Service
public class DistrictServiceImpl implements DistrictService{

	@Autowired
	private DistrictRepo repo;
	@Override
	public List<District> getDistrictsByStateId(Long stateId) {
		// TODO Auto-generated method stub
		return repo.findByStateStateId(stateId);
	}

}
