package com.bluedigm.springboard.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluedigm.springboard.domain.UserCreateVO;
import com.bluedigm.springboard.domain.UserDeleteVO;
import com.bluedigm.springboard.domain.UserLoginVO;
import com.bluedigm.springboard.domain.UserProfileVO;
import com.bluedigm.springboard.domain.UserSearchVO;
import com.bluedigm.springboard.domain.UserUpdateVO;
import com.bluedigm.springboard.entity.UserDAO;
import com.bluedigm.springboard.repository.UserRepo;

@Service
public class UserService {
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	@Autowired
	UserRepo userRepo;

	public boolean create(UserCreateVO vo) {
		if (vo.getPw1().equals(vo.getPw2())) {
			UserDAO dao = new UserDAO();
			dao.setName(vo.getName());
			dao.setNick(vo.getNick());
			dao.setEmail(vo.getEmail());
			dao.setPassword(vo.getPw1());
			return userRepo.insert(dao);
		}
		return false;
	}

	public UserDeleteVO delete(int id) {
		UserDAO dao = userRepo.select(id);
		if (dao != null) {
			UserDeleteVO vo = new UserDeleteVO();
			vo.setName(dao.getName());
			vo.setNick(dao.getNick());
			vo.setEmail(dao.getEmail());
			return vo;
		}
		return null;
	}

	public boolean delete(UserDeleteVO vo) {
		if (vo.getPw1().equals(vo.getPw2())) {
			UserDAO dao = userRepo.select(vo.getId());
			if (dao != null)
				if (dao.getPassword().equals(vo.getPw1()))
					return userRepo.delete(vo.getId());
		}
		return false;
	}

	public boolean login(UserLoginVO vo) {
		UserDAO dao = userRepo.select(vo.getName());
		if (dao != null)
			if (dao.getPassword().equals(vo.getPw())) {
				vo.setId(dao.getId());
				vo.setDate(dao.getUpdateAt());
				return true;
			}
		return false;
	}

	public UserProfileVO profile(int id) {
		UserDAO dao = userRepo.select(id);
		if (dao != null) {
			UserProfileVO vo = new UserProfileVO();
			vo.setName(dao.getName());
			vo.setNick(dao.getNick());
			vo.setEmail(dao.getEmail());
			vo.setCreateAt(dao.getCreateAt());
			vo.setUpdateAt(dao.getUpdateAt());
			return vo;
		}
		return null;
	}

	public UserSearchVO search() {
		UserSearchVO vo = new UserSearchVO();
		vo.setUserPage(1);
		vo.setUserSize(10);
		vo.setUserList(userRepo.searchAll(0, 10));
		int count = userRepo.count();
		vo.setUserMaxPage(count % 10 > 0 ? count / 10 + 1 : count / 10);
		return vo;
	}

	public UserSearchVO search(UserSearchVO vo) {

		vo.setUserList(userRepo.searchAll(vo.getUserPage()-1, vo.getUserSize()));
		int count = userRepo.count();
		vo.setUserMaxPage(count % vo.getUserSize() > 0 ? count / vo.getUserSize() + 1 : count / vo.getUserSize());
		return vo;
	}

	public UserUpdateVO update(int id) {
		UserDAO dao = userRepo.select(id);
		if (dao != null) {
			UserUpdateVO vo = new UserUpdateVO();
			vo.setName(dao.getName());
			vo.setNick(dao.getNick());
			vo.setEmail(dao.getEmail());
			return vo;
		}
		return null;
	}

	public boolean update(UserUpdateVO vo) {
		if (vo.getPwNew1().equals(vo.getPwNew2())) {
			UserDAO dao = userRepo.select(vo.getId());
			if (dao != null)
				if (vo.getPwOld().equals(dao.getPassword())) {
					dao.setName(vo.getName());
					dao.setNick(vo.getNick());
					dao.setEmail(vo.getEmail());
					dao.setPassword(vo.getPwNew1());
					return userRepo.update(dao);
				}
		}
		return false;
	}

	public boolean verify(int id, Date time) {
		UserDAO dao = userRepo.select(id);
		if (dao != null)
			return dao.getUpdateAt().equals(time);
		return false;
	}
}
