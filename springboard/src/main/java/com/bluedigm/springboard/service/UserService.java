package com.bluedigm.springboard.service;

import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluedigm.springboard.domain.UserCreateVO;
import com.bluedigm.springboard.domain.UserDeleteVO;
import com.bluedigm.springboard.domain.UserLoginVO;
import com.bluedigm.springboard.entity.UserDAO;
import com.bluedigm.springboard.repository.UserRepo;

@Service
public class UserService {
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	@Autowired
	UserRepo userRepo;

	public UserCreateVO create(UserCreateVO user) {
		UserDAO dao = new UserDAO();
		dao.setUsername(user.getUsername());
		dao.setNickname(user.getNickname());
		dao.setEmail(user.getEmail());
		dao.setPassword(user.getPassword1());
		userRepo.insert(dao);
		return user;
	}

	public void delete(UserDeleteVO user) {

	}

	public void login(UserLoginVO user) {

	}

	public void portal(UserCreateVO user) {

	}

	public void profile(UserCreateVO user) {

	}

	public List<UserCreateVO> search() {
		return new LinkedList<UserCreateVO>();
	}

	public UserCreateVO update(UserCreateVO user) {
		return user;
	}
}
