package com.bluedigm.springboard.service;

import java.util.Optional;

import com.bluedigm.springboard.domain.UserCreateVO;
import com.bluedigm.springboard.domain.UserDeleteVO;
import com.bluedigm.springboard.domain.UserHomeVO;
import com.bluedigm.springboard.domain.UserLoginVO;
import com.bluedigm.springboard.domain.UserResetVO;
import com.bluedigm.springboard.domain.UserSearchVO;
import com.bluedigm.springboard.domain.UserUpdateVO;
import com.bluedigm.springboard.entity.UserDAO;

public interface UserService {

	public boolean create(UserCreateVO vo);

	public boolean update(UserUpdateVO vo);

	public boolean delete(UserDeleteVO vo);

	public Optional<UserDAO> select(int id);

	public Optional<UserDAO> select(String name);

	public UserSearchVO search();

	public UserSearchVO search(UserSearchVO vo);

	public boolean verify(UserDAO user);

	public UserHomeVO home(UserDAO user);

	public boolean login(UserLoginVO vo);

	public boolean reset(UserResetVO vo);
}
