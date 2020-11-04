package com.bluedigm.springboard.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluedigm.springboard.Useful;
import com.bluedigm.springboard.domain.SearchVO;
import com.bluedigm.springboard.domain.UserCreateVO;
import com.bluedigm.springboard.domain.UserDeleteVO;
import com.bluedigm.springboard.domain.UserHomeVO;
import com.bluedigm.springboard.domain.UserLoginVO;
import com.bluedigm.springboard.domain.UserResetVO;
import com.bluedigm.springboard.domain.UserSearchVO;
import com.bluedigm.springboard.domain.UserUpdateVO;
import com.bluedigm.springboard.entity.UserDAO;
import com.bluedigm.springboard.repository.BoardRepo;
import com.bluedigm.springboard.repository.JoinRepo;
import com.bluedigm.springboard.repository.MemberRepo;
import com.bluedigm.springboard.repository.UserRepo;
import com.bluedigm.springboard.service.MailService;
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
	@Autowired
	MailService mailService;

	@Transactional
	@Override
	public boolean create(UserCreateVO vo) {
		logger.info(Useful.getMethodName());

		if (vo.getPw().equals(vo.getPwNew())) {
			UserDAO dao = new UserDAO();
			dao.setName(vo.getName());
			dao.setNick(vo.getNick());
			dao.setEmail(vo.getEmail());
			dao.setPassword(vo.getPw());

			if (userRepo.insert(dao)) {
				vo.setResult("ok");
				return true;
			} else {
				vo.setResult("Create failed");
			}
		} else {
			vo.setResult("Two passwords are not same");
		}
		return false;
	}

	@Transactional
	@Override
	public boolean update(UserUpdateVO vo) {
		logger.info(Useful.getMethodName());

		if (vo.getPw().equals(vo.getPwNew())) {
			Optional<UserDAO> old = userRepo.select(vo.getName());

			if (old.isPresent()) {

				if (vo.getPwOld().equals(old.get().getPassword())) {
					UserDAO dao = new UserDAO();
					dao.setId(old.get().getId());
					dao.setName(vo.getName());
					dao.setNick(vo.getNick());
					dao.setEmail(vo.getEmail());
					dao.setPassword(vo.getPw());

					if (userRepo.update(dao)) {
						vo.setResult("ok");
						return true;
					} else {
						vo.setResult("Update failed");
					}
				} else {
					vo.setResult("Password is not correct");
				}
			} else {
				vo.setResult("user is not exist");
			}
		} else {
			vo.setResult("Two passwords are not same");
		}
		return false;
	}

	@Transactional
	@Override
	public boolean delete(UserDeleteVO vo) {
		logger.info(Useful.getMethodName());

		if (vo.getPw().equals(vo.getPwOld())) {
			Optional<UserDAO> old = userRepo.select(vo.getName());

			if (old.isPresent()) {

				if (vo.getPw().equals(old.get().getPassword())) {
					if (userRepo.delete(old.get().getId())) {

						vo.setResult("ok");
						return true;
					} else {
						vo.setResult("Delete failed");
					}
				} else {
					vo.setResult("Password is not correct");
				}
			} else {
				vo.setResult("user is not exist");
			}
		} else {
			vo.setResult("Two passwords are not same");
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
		Optional<UserDAO> old = userRepo.select(name);

		if (old.isPresent()) {
			return old;
		}
		return Optional.empty();
	}

	@Transactional(readOnly = true)
	@Override
	public UserSearchVO search() {
		logger.info(Useful.getMethodName());
		UserSearchVO vo = new UserSearchVO();
		vo.setList(userRepo.search());
		vo.setPage(1);
		vo.setPageMax(1);
		vo.setSize(vo.getList().size());
		return vo;
	}

	@Override
	public UserSearchVO search(UserSearchVO vo) {
		logger.info(Useful.getMethodName());
		vo.setList(userRepo.search(vo.getPage(), vo.getSize()));
		vo.setPage(vo.getPage());
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

	@Transactional(readOnly = true)
	@Override
	public boolean login(UserLoginVO vo) {
		logger.info(Useful.getMethodName());
		Optional<UserDAO> old = userRepo.select(vo.getName());

		if (old.isPresent()) {

			if (vo.getPw().equals(old.get().getPassword())) {
				vo.setUser(old.get());
				vo.setResult("ok");
				return true;
			} else {
				vo.setResult("Password is not correct");
			}
		} else {
			vo.setResult("user is not exist");
		}
		return false;
	}

	@Transactional
	@Override
	public boolean reset(UserResetVO vo) {
		logger.info(Useful.getMethodName());
		mailService.simpleMail(userRepo.select(vo.getId()).get());
		return false;
	}
}
