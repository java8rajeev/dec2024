package com.rajeev.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rajeev.model.User;

public interface UserRepo extends JpaRepository<User,Long>{
        User findByuserName(String userName);
}
