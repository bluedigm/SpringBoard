package com.bluedigm.springboard.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluedigm.springboard.Useful;
import com.bluedigm.springboard.domain.BoardCreateVO;
import com.bluedigm.springboard.domain.BoardDeleteVO;
import com.bluedigm.springboard.domain.BoardHomeVO;
import com.bluedigm.springboard.domain.BoardUpdateVO;
import com.bluedigm.springboard.domain.SearchVO;
import com.bluedigm.springboard.entity.BoardDAO;
import com.bluedigm.springboard.entity.MemberDAO;
import com.bluedigm.springboard.entity.UserDAO;
import com.bluedigm.springboard.repository.BoardRepo;
import com.bluedigm.springboard.repository.JoinRepo;
import com.bluedigm.springboard.repository.MemberRepo;
import com.bluedigm.springboard.repository.NoteRepo;
import com.bluedigm.springboard.repository.UserRepo;
import com.bluedigm.springboard.service.BoardService;

@Service
public class BoardServiceImpl implements BoardService {
	private static final Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);
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

	@Override
	public boolean create(BoardCreateVO vo) {
		logger.info(Useful.getMethodName());

		BoardDAO dao = new BoardDAO();
		dao.setLink(vo.getLink());
		dao.setTitle(vo.getTitle());
		dao.setText(vo.getText());

		if (boardRepo.insert(dao)) {
			MemberDAO dao2 = new MemberDAO();
			dao2.setBoardId(dao.getId());
			dao2.setUserId(vo.getUserId());
			dao2.setOpFlag(true);

			if (memberRepo.insert(dao2)) {
				vo.setBoardId(dao.getId());
			}
			vo.setResult("ok");
			return true;
		} else {
			vo.setResult("Create failed");
		}
		return false;
	}

	@Override
	public boolean update(BoardUpdateVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(BoardDeleteVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Optional<BoardDAO> select(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<BoardDAO> select(String link) {
		logger.info(Useful.getMethodName());
		Optional<BoardDAO> old = boardRepo.select(link);

		if (old.isPresent()) {
			return old;
		}
		return Optional.empty();
	}

	@Override
	public SearchVO<BoardDAO> search() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SearchVO<BoardDAO> search(SearchVO<BoardDAO> vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean verify(UserDAO user, BoardDAO board) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public BoardHomeVO home(UserDAO user, BoardDAO board) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean join(UserDAO user, BoardDAO board, boolean flag) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean leave(UserDAO user, BoardDAO board) {
		// TODO Auto-generated method stub
		return false;
	}
}
