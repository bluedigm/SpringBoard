package com.bluedigm.springboard.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluedigm.springboard.domain.UserCreateVO;
import com.bluedigm.springboard.domain.UserDeleteVO;
import com.bluedigm.springboard.domain.UserHomeVO;
import com.bluedigm.springboard.domain.UserLoginVO;
import com.bluedigm.springboard.domain.UserProfileVO;
import com.bluedigm.springboard.domain.UserResetVO;
import com.bluedigm.springboard.domain.UserSearchVO;
import com.bluedigm.springboard.domain.UserUpdateVO;
import com.bluedigm.springboard.entity.JoinDAO;
import com.bluedigm.springboard.entity.UserDAO;
import com.bluedigm.springboard.repository.BoardRepo;
import com.bluedigm.springboard.repository.JoinRepo;
import com.bluedigm.springboard.repository.MemberRepo;
import com.bluedigm.springboard.repository.UserRepo;

@Service
public class UserService {
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	@Autowired
	UserRepo userRepo;
	@Autowired
	BoardRepo boardRepo;
	@Autowired
	MemberRepo memberRepo;
	@Autowired
	JoinRepo joinRepo;

	@Transactional
	public boolean create(UserCreateVO vo) {
		logger.info("Create vo");
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

	@Transactional(readOnly = true)
	public UserDeleteVO delete(int id) {
		logger.info("Delete id");
		Optional<UserDAO> dao = userRepo.select(id);
		if (dao.isPresent()) {
			UserDeleteVO vo = new UserDeleteVO();
			vo.setName(dao.get().getName());
			vo.setNick(dao.get().getNick());
			vo.setEmail(dao.get().getEmail());
			return vo;
		}
		return null;
	}

	@Transactional
	public boolean delete(Integer id, UserDeleteVO vo) {
		logger.info("Delete id vo");
		vo.setId(id);
		if (vo.getPw1().equals(vo.getPw2())) {
			Optional<UserDAO> dao = userRepo.select(vo.getId());
			if (dao.isPresent())
				if (dao.get().getPassword().equals(vo.getPw1()))
					return userRepo.delete(vo.getId());
		}
		return false;
	}

	@Transactional(readOnly = true)
	public boolean login(UserLoginVO vo) {
		logger.info("Login vo");
		Optional<UserDAO> dao = userRepo.select(vo.getName());
		if (dao.isPresent())
			if (dao.get().getPassword().equals(vo.getPw())) {
				vo.setId(dao.get().getId());
				vo.setDate(dao.get().getUpdateAt());
				return true;
			}
		return false;
	}

	@Transactional(readOnly = true)
	public UserHomeVO home(int id) {
		logger.info("Home id");
		Optional<UserDAO> dao = userRepo.select(id);
		if (dao.isPresent()) {
			UserHomeVO vo = new UserHomeVO();
			vo.setNick(dao.get().getNick());
			vo.setPage(1);
			vo.setSize(10);
			List<JoinDAO> data = joinRepo.searchMember(dao.get(), 0, 10);
			vo.setJoinList(data);
			Optional<Integer> count = boardRepo.count();
			vo.setPageMax(count.get() % 10 > 0 ? count.get() / 10 + 1 : count.get() / 10);
			return vo;
		}
		return null;
	}

	@Transactional(readOnly = true)
	public UserHomeVO home(int id, UserHomeVO vo) {
		logger.info("Home id");
		Optional<UserDAO> dao = userRepo.select(id);
		if (dao.isPresent()) {
			vo.setNick(dao.get().getNick());
			List<JoinDAO> data = joinRepo.searchMember(dao.get(), vo.getPage() - 1, vo.getSize());
			vo.setJoinList(data);
			Optional<Integer> count = boardRepo.count();
			vo.setPageMax(count.get() % vo.getSize() > 0 ? count.get() / vo.getSize() + 1 : count.get() / vo.getSize());
			return vo;
		}
		return null;
	}

	@Transactional(readOnly = true)
	public UserProfileVO profile(int id) {
		logger.info("Profile id");
		Optional<UserDAO> dao = userRepo.select(id);
		if (dao.isPresent()) {
			UserProfileVO vo = new UserProfileVO();
			vo.setName(dao.get().getName());
			vo.setNick(dao.get().getNick());
			vo.setEmail(dao.get().getEmail());
			vo.setCreateAt(dao.get().getCreateAt());
			vo.setUpdateAt(dao.get().getUpdateAt());
			return vo;
		}
		return null;
	}

	@Transactional
	public boolean reset(UserResetVO vo) {
		logger.info("Reset vo");
		if (vo.getPw1().equals(vo.getPw2())) {
			Optional<UserDAO> dao = userRepo.select(vo.getName());
			if (dao.isPresent()) {
				if (dao.get().getNick().equals(vo.getNick()) && dao.get().getEmail().equals(vo.getEmail())) {
					dao.get().setPassword(vo.getPw1());
					return userRepo.update(dao.get());
				}
			}
		}
		return false;
	}

	@Transactional(readOnly = true)
	public UserSearchVO search() {
		logger.info("Search");
		UserSearchVO vo = new UserSearchVO();
		vo.setPage(1);
		vo.setSize(10);
		vo.setUserList(userRepo.search(0, 10));
		Optional<Integer> count = userRepo.count();
		vo.setPageMax(count.get() % 10 > 0 ? count.get() / 10 + 1 : count.get() / 10);
		return vo;
	}

	@Transactional(readOnly = true)
	public UserSearchVO search(UserSearchVO vo) {
		logger.info("Search vo");
		vo.setUserList(userRepo.search(vo.getPage() - 1, vo.getSize()));
		Optional<Integer> count = userRepo.count();
		vo.setPageMax(count.get() % vo.getSize() > 0 ? count.get() / vo.getSize() + 1 : count.get() / vo.getSize());
		return vo;
	}

	@Transactional(readOnly = true)
	public UserUpdateVO edit(int id) {
		logger.info("Edit id");
		Optional<UserDAO> dao = userRepo.select(id);
		if (dao.isPresent()) {
			UserUpdateVO vo = new UserUpdateVO();
			vo.setName(dao.get().getName());
			vo.setNick(dao.get().getNick());
			vo.setEmail(dao.get().getEmail());
			return vo;
		}
		return null;
	}

	@Transactional
	public boolean edit(Integer id, UserUpdateVO vo) {
		logger.info("Edit id vo");
		vo.setId(id);
		if (vo.getPwNew1().equals(vo.getPwNew2())) {
			Optional<UserDAO> dao = userRepo.select(vo.getId());
			if (dao.isPresent())
				if (vo.getPwOld().equals(dao.get().getPassword())) {
					dao.get().setName(vo.getName());
					dao.get().setNick(vo.getNick());
					dao.get().setEmail(vo.getEmail());
					dao.get().setPassword(vo.getPwNew1());
					return userRepo.update(dao.get());
				}
		}
		return false;
	}

	@Transactional(readOnly = true)
	public boolean verify(int id, Date time) {
		logger.info("Verify");
		Optional<UserDAO> dao = userRepo.select(id);
		if (dao.isPresent())
			return dao.get().getUpdateAt().equals(time);
		return false;
	}

	@Transactional(readOnly = true)
	public Integer check(String name) {
		logger.info("Check name");
		Optional<UserDAO> dao = userRepo.select(name);
		if (dao.isPresent()) {
			return dao.get().getId();
		}
		return null;
	}

	@Transactional(readOnly = true)
	public String check(int id) {
		logger.info("Check id");
		Optional<UserDAO> dao = userRepo.select(id);
		if (dao.isPresent()) {
			return dao.get().getName();
		}
		return null;
	}
}
