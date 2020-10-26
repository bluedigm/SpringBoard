package com.bluedigm.springboard.service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluedigm.springboard.domain.BoardCreateVO;
import com.bluedigm.springboard.domain.BoardHomeVO;
import com.bluedigm.springboard.domain.BoardSearchVO;
import com.bluedigm.springboard.domain.UserDeleteVO;
import com.bluedigm.springboard.domain.UserLoginVO;
import com.bluedigm.springboard.domain.UserProfileVO;
import com.bluedigm.springboard.domain.UserSearchVO;
import com.bluedigm.springboard.domain.UserUpdateVO;
import com.bluedigm.springboard.entity.BoardDAO;
import com.bluedigm.springboard.entity.MemberDAO;
import com.bluedigm.springboard.entity.NoteDAO;
import com.bluedigm.springboard.entity.UserDAO;
import com.bluedigm.springboard.entity.join.MemberJoin;
import com.bluedigm.springboard.entity.join.NoteJoin;
import com.bluedigm.springboard.repository.BoardRepo;
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

	public boolean create(BoardCreateVO vo) {
		BoardDAO dao = new BoardDAO();
		dao.setLink(vo.getLink());
		dao.setTitle(vo.getTitle());
		dao.setText(vo.getText());
		if (boardRepo.insert(dao)) {
			Optional<BoardDAO> dao2 = boardRepo.select(dao.getLink());
			vo.setBoardId(dao2.get().getId());
			MemberDAO dao3 = new MemberDAO();
			dao3.setUserId(vo.getUserId());
			dao3.setBoardId(vo.getBoardId());
			if (memberRepo.insert(dao3)) {
				dao3 = memberRepo.select(vo.getUserId(), vo.getBoardId());
				dao3.setFlagOp(true);
				return memberRepo.update(dao3);
			}
		}
		return false;
	}

	public UserDeleteVO delete(int id) {
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

	public boolean delete(UserDeleteVO vo) {
		if (vo.getPw1().equals(vo.getPw2())) {
			Optional<UserDAO> dao = userRepo.select(vo.getId());
			if (dao.isPresent())
				if (dao.get().getPassword().equals(vo.getPw1()))
					return userRepo.delete(vo.getId());
		}
		return false;
	}

	public boolean login(UserLoginVO vo) {
		Optional<UserDAO> dao = userRepo.select(vo.getName());
		if (dao.isPresent())
			if (dao.get().getPassword().equals(vo.getPw())) {
				vo.setId(dao.get().getId());
				vo.setDate(dao.get().getUpdateAt());
				return true;
			}
		return false;
	}

	public BoardHomeVO home(String link) {
		Optional<BoardDAO> board = boardRepo.select(link);
		BoardHomeVO vo = new BoardHomeVO();
		vo.setTitle(board.get().getTitle());
		vo.setText(board.get().getText());
		List<NoteJoin> data = noteRepo.searchDetailAll(board.get().getId(), 0, 10);
		if (!data.isEmpty()) {
			vo.setNoteList(data);
		}
		return vo;
	}

	public BoardSearchVO search() {
		BoardSearchVO vo = new BoardSearchVO();
		vo.setPage(1);
		vo.setSize(10);
		vo.setBoardList(boardRepo.searchAll(0, 10));
		Optional<Integer> count = boardRepo.count();
		vo.setPageMax(count.get() % 10 > 0 ? count.get() / 10 + 1 : count.get() / 10);
		return vo;
	}

	public BoardSearchVO search(BoardSearchVO vo) {
		vo.setBoardList(boardRepo.searchAll(vo.getPage() - 1, vo.getSize()));
		Optional<Integer> count = boardRepo.count();
		vo.setPageMax(count.get() % vo.getSize() > 0 ? count.get() / vo.getSize() + 1 : count.get() / vo.getSize());
		return vo;
	}

	public UserUpdateVO update(int id) {
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

	public Integer check(String link) {
		Optional<BoardDAO> board = boardRepo.select(link);
		if (board.isPresent()) {
			return board.get().getId();
		}
		return null;
	}

	public String check(int id) {
		Optional<BoardDAO> board = boardRepo.select(id);
		if (board.isPresent()) {
			return board.get().getLink();
		}
		return null;
	}
}
