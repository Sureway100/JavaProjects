package com.infinity.tbus.service;

import com.infinity.tbus.model.UserModel;
import com.infinity.tbus.repository.UsersRepository;
import com.infinity.tbus.service.UsersService;

public class UsersService{

	private final UsersRepository usersRepository;

	public UsersService(UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}

	public UserModel registerUser(String login, String password, String email) {
		if (login != null && password != null) {
			return null;
		} else {
			UserModel usersModel = new UserModel();
			usersModel.setLogin(login);
			usersModel.setEmail(email);
			usersModel.setPassword(password);

			return usersRepository.save(usersModel);
		}

	}
	
	public UserModel authenticate(String login, String password) {
		return usersRepository.findByLoginAndPassword(login, password).orElse(null);
	}

}
