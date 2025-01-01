package com.rajeev.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="district")
public class District {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long districtId;
	@Column(name="district_name")
	private String districtName;
	@ManyToOne
	@JoinColumn(name="state_id")
	@JsonBackReference
	private State state;
	public Long getDistrictId() {
		return districtId;
	}
	public void setDistrictId(Long districtId) {
		this.districtId = districtId;
	}
	public String getDistrictName() {
		return districtName;
	}
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}


}
