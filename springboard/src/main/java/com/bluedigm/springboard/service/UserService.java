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
import com.bluedigm.springboard.domain.UserProfileVO;
import com.bluedigm.springboard.domain.UserUpdateVO;
import com.bluedigm.springboard.entity.UserDAO;
import com.bluedigm.springboard.repository.UserRepo;

@Service
public class UserService {
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	@Autowired
	UserRepo userRepo;

	public boolean create(UserCreateVO vo) {
		UserDAO dao = new UserDAO();
		dao.setUsername(vo.getUsername());
		dao.setNickname(vo.getNickname());
		dao.setEmail(vo.getEmail());
		dao.setPassword(vo.getPassword1());
		return userRepo.insert(dao);
	}

	public UserDeleteVO delete(String username) {
		if (username != null) {
			UserDAO dao = userRepo.select(username);
			UserDeleteVO vo = new UserDeleteVO();
			vo.setUsername(dao.getUsername());
			vo.setNickname(dao.getNickname());
			return vo;
		}
		return null;
	}

	public boolean delete(UserDeleteVO vo) {
		if (vo.getPassword1().equals(vo.getPassword2())) {
			UserDAO dao = userRepo.select(vo.getUsername());
			if (dao != null)
				if (dao.getPassword().equals(vo.getPassword1()))
					return userRepo.delete(vo.getUsername());
		}
		return false;
	}

	public boolean login(UserLoginVO vo) {
		UserDAO dao = userRepo.select(vo.getUsername());
		if (dao != null)
			return dao.getPassword().equals(vo.getPassword());
		return false;
	}

	public void portal(String username) {

	}

	public UserProfileVO profile(String username) {
		if (username != null) {
			UserDAO dao = userRepo.select(username);
			UserProfileVO vo = new UserProfileVO();
			vo.setUsername(dao.getUsername());
			vo.setNickname(dao.getNickname());
			vo.setEmail(dao.getEmail());
			vo.setCreateAt(dao.getCreateAt());
			vo.setUpdateAt(dao.getUpdateAt());
			return vo;
		}
		return null;
	}

	public List<UserCreateVO> search() {
		return new LinkedList<UserCreateVO>();
	}

	public UserUpdateVO update(String username) {
		if (username != null) {
			UserDAO dao = userRepo.select(username);
			UserUpdateVO vo = new UserUpdateVO();
			vo.setUsername(dao.getUsername());
			vo.setNickname(dao.getNickname());
			vo.setEmail(dao.getEmail());
			return vo;
		}
		return null;
	}

	public boolean update(String username, UserUpdateVO vo) {
		if (username != null) {
			UserDAO dao = userRepo.select(username);
			if (vo.getPasswordOld().equals(dao.getPassword())) {
				dao.setUsername(vo.getUsername());
				dao.setNickname(vo.getNickname());
				dao.setEmail(vo.getEmail());
				dao.setPassword(vo.getPasswordNew1());
			}
			return userRepo.update(username, dao);
		}
		return false;
	}
}
