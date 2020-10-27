package com.bluedigm.springboard.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluedigm.springboard.Useful;
import com.bluedigm.springboard.domain.BoardCreateVO;
import com.bluedigm.springboard.domain.BoardHomeVO;
import com.bluedigm.springboard.domain.BoardSearchVO;
import com.bluedigm.springboard.domain.UserDeleteVO;
import com.bluedigm.springboard.domain.UserUpdateVO;
import com.bluedigm.springboard.entity.BoardDAO;
import com.bluedigm.springboard.entity.JoinDAO;
import com.bluedigm.springboard.entity.MemberDAO;
import com.bluedigm.springboard.entity.UserDAO;
import com.bluedigm.springboard.repository.BoardRepo;
import com.bluedigm.springboard.repository.JoinRepo;
import com.bluedigm.springboard.repository.MemberRepo;
import com.bluedigm.springboard.repository.NoteRepo;
import com.bluedigm.springboard.repository.UserRepo;

@Service
public class BoardService {
	private static final Logger logger = LoggerFactory.getLogger(BoardService.class);
	@Autowired
	UserRepo userRepo;
	@Autowired
	BoardRepo boardRepo;
	@Autowired
	MemberRepo memberRepo;
	@Autowired
	NoteRepo noteRepo;
	@Autowired
	JoinRepo joinRepo;

	@Transactional
	public boolean create(BoardCreateVO vo) {
		logger.info("Create vo");
		BoardDAO dao = new BoardDAO();
		dao.setLink(vo.getLink());
		dao.setTitle(vo.getTitle());
		dao.setText(vo.getText());
		return boardRepo.insert(dao);
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
	public boolean delete(UserDeleteVO vo) {
		logger.info(Useful.getMethodName());
		if (vo.getPw1().equals(vo.getPw2())) {
			Optional<UserDAO> dao = userRepo.select(vo.getId());
			if (dao.isPresent())
				if (dao.get().getPassword().equals(vo.getPw1()))
					return userRepo.delete(vo.getId());
		}
		return false;
	}

	@Transactional(readOnly = true)
	public BoardHomeVO home(String user, String link) {
		logger.info(Useful.getMethodName());
		BoardHomeVO vo = new BoardHomeVO();
		if (user != null) {
			Optional<UserDAO> daoU = userRepo.select(user);
			Optional<BoardDAO> daoB = boardRepo.select(link);
			if (daoB.isPresent() && daoU.isPresent()) {
				vo.setTitle(daoB.get().getTitle());
				vo.setText(daoB.get().getText());
				vo.setLink(daoB.get().getLink());
				Optional<MemberDAO> member = memberRepo.select(daoU.get().getId(), daoB.get().getId());
				if (member.isPresent()) {
					vo.setMember(true);
				}
				List<JoinDAO> data = joinRepo.searchNote(daoB.get(), 0, 10);
				if (!data.isEmpty()) {
					vo.setList(data);
				}
			}
		}
		return vo;
	}

	@Transactional
	public boolean join(String user, String link, boolean flag) {
		logger.info("Join user link");
		if (user != null && link != null) {
			Optional<UserDAO> u = userRepo.select(user);
			Optional<BoardDAO> b = boardRepo.select(link);
			if (u.isPresent() && b.isPresent()) {
				MemberDAO dao = new MemberDAO();
				dao.setUserId(u.get().getId());
				dao.setBoardId(b.get().getId());
				dao.setFlagOp(flag);
				return memberRepo.insert(dao);
			}
		}
		return false;
	}

	@Transactional
	public boolean leave(String user, String link) {
		logger.info("Leave user link");
		logger.info("Join user link");
		if (user != null && link != null) {
			Optional<UserDAO> u = userRepo.select(user);
			Optional<BoardDAO> b = boardRepo.select(link);
			if (u.isPresent() && b.isPresent()) {
				return memberRepo.delete(u.get().getId(), b.get().getId());
			}
		}
		return false;
	}

	@Transactional(readOnly = true)
	public BoardSearchVO search() {
		logger.info("Search vo");
		BoardSearchVO vo = new BoardSearchVO();
		vo.setPage(1);
		vo.setSize(10);
		vo.setList(boardRepo.search(0, 10));
		Optional<Integer> count = boardRepo.count();
		vo.setPageMax(count.get() % 10 > 0 ? count.get() / 10 + 1 : count.get() / 10);
		return vo;
	}

	@Transactional(readOnly = true)
	public BoardSearchVO search(BoardSearchVO vo) {
		logger.info("Search vo");
		vo.setList(boardRepo.search(vo.getPage() - 1, vo.getSize()));
		Optional<Integer> count = boardRepo.count();
		vo.setPageMax(count.get() % vo.getSize() > 0 ? count.get() / vo.getSize() + 1 : count.get() / vo.getSize());
		return vo;
	}

	public UserUpdateVO update(int id) {
		logger.info("Update id");
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

	public boolean update(UserUpdateVO vo) {
		logger.info("Update vo");
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
	public boolean verify(String board) {
		logger.info("Verify");
		Optional<BoardDAO> dao = boardRepo.select(board);
		return dao.isPresent();
	}

	@Transactional(readOnly = true)
	public Integer getLink2Id(String link) {
		logger.info("Check link");
		Optional<BoardDAO> dao = boardRepo.select(link);
		if (dao.isPresent()) {
			return dao.get().getId();
		}
		return null;
	}

	@Transactional(readOnly = true)
	public String getId2Link(int id) {
		logger.info("Check id");
		Optional<BoardDAO> dao = boardRepo.select(id);
		if (dao.isPresent()) {
			return dao.get().getLink();
		}
		return null;
	}
}
