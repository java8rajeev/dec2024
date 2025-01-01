package com.rajeev.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rajeev.model.State;

public interface StateRepo extends JpaRepository<State,Long>{

}
