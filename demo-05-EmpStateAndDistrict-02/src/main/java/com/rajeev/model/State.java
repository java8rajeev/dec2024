package com.rajeev.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="state")
public class State {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long stateId;
	@Column(name="state_name")
	private String stateName;
	@OneToMany(mappedBy="state",cascade=CascadeType.ALL)
	@JsonManagedReference
	private List<District> district;
	public Long getStateId() {
		return stateId;
	}
	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public List<District> getDistrict() {
		return district;
	}
	public void setDistrict(List<District> district) {
		this.district = district;
	}
	

}
