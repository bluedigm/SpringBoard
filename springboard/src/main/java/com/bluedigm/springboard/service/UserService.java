package com.bluedigm.springboard.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluedigm.springboard.domain.UserCreateVO;
import com.bluedigm.springboard.domain.UserDeleteVO;
import com.bluedigm.springboard.domain.UserHomeVO;
import com.bluedigm.springboard.domain.UserLoginVO;
import com.bluedigm.springboard.domain.UserProfileVO;
import com.bluedigm.springboard.domain.UserSearchVO;
import com.bluedigm.springboard.domain.UserUpdateVO;
import com.bluedigm.springboard.entity.BoardDAO;
import com.bluedigm.springboard.entity.UserDAO;
import com.bluedigm.springboard.entity.join.MemberJoin;
import com.bluedigm.springboard.repository.BoardRepo;
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

	public boolean create(UserCreateVO vo) {
		logger.info("User Service - Create vo");
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
		logger.info("User Service - Delete id");
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

	public boolean delete(Integer id, UserDeleteVO vo) {
		logger.info("User Service - Delete id vo");
		vo.setId(id);
		if (vo.getPw1().equals(vo.getPw2())) {
			Optional<UserDAO> dao = userRepo.select(vo.getId());
			if (dao.isPresent())
				if (dao.get().getPassword().equals(vo.getPw1()))
					return userRepo.delete(vo.getId());
		}
		return false;
	}

	public boolean login(UserLoginVO vo) {
		logger.info("User Service - Login vo");
		Optional<UserDAO> dao = userRepo.select(vo.getName());
		if (dao.isPresent())
			if (dao.get().getPassword().equals(vo.getPw())) {
				vo.setId(dao.get().getId());
				vo.setDate(dao.get().getUpdateAt());
				return true;
			}
		return false;
	}

	public UserHomeVO home(int id) {
		logger.info("User Service - Home id");
		Optional<UserDAO> dao = userRepo.select(id);
		if (dao.isPresent()) {
			UserHomeVO vo = new UserHomeVO();
			vo.setNick(dao.get().getNick());
			vo.setPage(1);
			vo.setSize(10);

			List<MemberJoin> data = memberRepo.searchJoin(id);
			vo.setJoinList(data);
			Optional<Integer> count = boardRepo.count();
			vo.setPageMax(count.get() % 10 > 0 ? count.get() / 10 + 1 : count.get() / 10);
			return vo;
		}
		return null;
	}

	public UserHomeVO home(int id, UserHomeVO vo) {
		logger.info("User Service - Home id");
		Optional<UserDAO> dao = userRepo.select(id);
		if (dao.isPresent()) {
			vo.setNick(dao.get().getNick());
			List<MemberJoin> data = memberRepo.searchJoin(id);
			vo.setJoinList(data);
			Optional<Integer> count = boardRepo.count();
			vo.setPageMax(count.get() % vo.getSize() > 0 ? count.get() / vo.getSize() + 1 : count.get() / vo.getSize());
			return vo;
		}
		return null;
	}

	public UserProfileVO profile(int id) {
		logger.info("User Service - Profile id");
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

	public UserSearchVO search() {
		logger.info("User Service - Search");
		UserSearchVO vo = new UserSearchVO();
		vo.setPage(1);
		vo.setSize(10);
		vo.setUserList(userRepo.searchAll(0, 10));
		Optional<Integer> count = userRepo.count();
		vo.setPageMax(count.get() % 10 > 0 ? count.get() / 10 + 1 : count.get() / 10);
		return vo;
	}

	public UserSearchVO search(UserSearchVO vo) {
		logger.info("User Service - Search vo");
		vo.setUserList(userRepo.searchAll(vo.getPage() - 1, vo.getSize()));
		Optional<Integer> count = userRepo.count();
		vo.setPageMax(count.get() % vo.getSize() > 0 ? count.get() / vo.getSize() + 1 : count.get() / vo.getSize());
		return vo;
	}

	public UserUpdateVO edit(int id) {
		logger.info("User Service - Edit id");
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

	public boolean edit(Integer id, UserUpdateVO vo) {
		logger.info("User Service - Edit id vo");
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

	public boolean verify(int id, Date time) {
		logger.info("User Service - Verify");
		Optional<UserDAO> dao = userRepo.select(id);
		if (dao.isPresent())
			return dao.get().getUpdateAt().equals(time);
		return false;
	}
}
