package com.rajeev.service;

import java.util.List;

import com.rajeev.model.District;

public interface DistrictService {
	List<District> getDistrictsByStateId(Long stateId);

}
