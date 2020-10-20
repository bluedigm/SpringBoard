package com.bluedigm.springboard.service;

import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluedigm.springboard.domain.UserVO;
import com.bluedigm.springboard.repository.UserRepo;

@Service
public class UserService {
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	@Autowired
	UserRepo userRepo;

	public UserVO insert(UserVO user) {
		return user;
	}

	public void delete(UserVO user) {

	}

	public List<UserVO> search() {
		return new LinkedList<UserVO>();
	}

	public UserVO update(UserVO user) {
		return user;
	}
}
