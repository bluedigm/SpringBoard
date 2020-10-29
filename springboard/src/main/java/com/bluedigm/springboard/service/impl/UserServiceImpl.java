package com.bluedigm.springboard.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluedigm.springboard.Useful;
import com.bluedigm.springboard.domain.SearchVO;
import com.bluedigm.springboard.domain.UserCreateVO;
import com.bluedigm.springboard.domain.UserDeleteVO;
import com.bluedigm.springboard.domain.UserHomeVO;
import com.bluedigm.springboard.domain.UserLoginVO;
import com.bluedigm.springboard.domain.UserResetVO;
import com.bluedigm.springboard.domain.UserUpdateVO;
import com.bluedigm.springboard.entity.UserDAO;
import com.bluedigm.springboard.repository.BoardRepo;
import com.bluedigm.springboard.repository.JoinRepo;
import com.bluedigm.springboard.repository.MemberRepo;
import com.bluedigm.springboard.repository.UserRepo;
import com.bluedigm.springboard.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	UserRepo userRepo;
	@Autowired
	BoardRepo boardRepo;
	@Autowired
	MemberRepo memberRepo;
	@Autowired
	JoinRepo joinRepo;

	@Transactional
	@Override
	public boolean create(UserCreateVO vo) {
		logger.info(Useful.getMethodName());
		if (vo.getPw().equals(vo.getUser().getPassword())) {
			return userRepo.insert(vo.getUser());
		}
		return false;
	}

	@Transactional
	@Override
	public boolean update(UserUpdateVO vo) {
		logger.info(Useful.getMethodName());
		if (vo.getPwNew().equals(vo.getUser().getPassword())) {
			Optional<UserDAO> old = userRepo.select(vo.getUser().getName());
			if (old.isPresent())
				if (vo.getPwOld().equals(old.get().getPassword())) {
					return userRepo.update(vo.getUser());
				}
		}
		return false;
	}

	@Transactional
	@Override
	public boolean delete(UserDeleteVO vo) {
		logger.info(Useful.getMethodName());
		if (vo.getPw().equals(vo.getUser().getPassword())) {
			Optional<UserDAO> old = userRepo.select(vo.getUser().getName());
			if (old.isPresent())
				if (vo.getPw().equals(old.get().getPassword()))
					return userRepo.delete(old.get().getId());
		}
		return false;
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<UserDAO> select(int id) {
		logger.info(Useful.getMethodName());
		Optional<UserDAO> old = userRepo.select(id);
		if (old.isPresent()) {
			return old;
		}
		return Optional.empty();
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<UserDAO> select(String name) {
		logger.info(Useful.getMethodName());
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional(readOnly = true)
	@Override
	public SearchVO<UserDAO> search() {
		logger.info(Useful.getMethodName());
		SearchVO<UserDAO> vo = new SearchVO<UserDAO>();
		vo.setList(userRepo.search());
		vo.setPage(1);
		vo.setPageMax(1);
		vo.setSize(vo.getList().size());
		return vo;
	}

	@Override
	public SearchVO<UserDAO> search(SearchVO<UserDAO> vo) {
		logger.info(Useful.getMethodName());
		vo.setList(userRepo.search(vo.getPage(), vo.getSize()));
		vo.setPageMax((int) Math.ceil(userRepo.count().get() / (double) vo.getSize()));
		vo.setSize(vo.getList().size());
		return vo;
	}

	@Transactional(readOnly = true)
	@Override
	public boolean verify(UserDAO user) {
		logger.info(Useful.getMethodName());
		Optional<UserDAO> dao = userRepo.select(user.getId());
		if (dao.isPresent())
			return dao.get().getUpdateAt().equals(user.getUpdateAt());
		return false;
	}

	@Override
	public UserHomeVO home(UserDAO user) {
		logger.info(Useful.getMethodName());
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean login(UserLoginVO vo) {
		logger.info(Useful.getMethodName());
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean logout() {
		logger.info(Useful.getMethodName());
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean reset(UserResetVO vo) {
		logger.info(Useful.getMethodName());
		// TODO Auto-generated method stub
		return false;
	}
}
