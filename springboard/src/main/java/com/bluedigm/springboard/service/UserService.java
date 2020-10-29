package com.bluedigm.springboard.service;

import java.util.Optional;

import com.bluedigm.springboard.domain.SearchVO;
import com.bluedigm.springboard.domain.UserCreateVO;
import com.bluedigm.springboard.domain.UserDeleteVO;
import com.bluedigm.springboard.domain.UserHomeVO;
import com.bluedigm.springboard.domain.UserLoginVO;
import com.bluedigm.springboard.domain.UserResetVO;
import com.bluedigm.springboard.domain.UserUpdateVO;
import com.bluedigm.springboard.entity.UserDAO;

public interface UserService {

	public boolean create(UserCreateVO vo);

	public boolean update(UserUpdateVO vo);

	public boolean delete(UserDeleteVO vo);

	public Optional<UserDAO> select(int id);

	public Optional<UserDAO> select(String name);

	public SearchVO<UserDAO> search();

	public SearchVO<UserDAO> search(SearchVO<UserDAO> vo);

	public boolean verify(UserDAO user);

	public UserHomeVO home(UserDAO user);

	public boolean login(UserLoginVO vo);

	public boolean logout();

	public boolean reset(UserResetVO vo);
}
