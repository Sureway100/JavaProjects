package com.infinity.tbus.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infinity.tbus.model.UserModel;

public interface UsersRepository extends JpaRepository<UserModel, Integer>{
	
	//apart from default crud methods, we need one custom crud method
	Optional<UserModel>findByLoginAndPassword(String login, String password);

}
