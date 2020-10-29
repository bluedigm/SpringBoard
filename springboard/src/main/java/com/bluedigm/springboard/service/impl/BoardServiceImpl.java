package com.bluedigm.springboard.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluedigm.springboard.domain.BoardCreateVO;
import com.bluedigm.springboard.domain.BoardDeleteVO;
import com.bluedigm.springboard.domain.BoardHomeVO;
import com.bluedigm.springboard.domain.BoardUpdateVO;
import com.bluedigm.springboard.domain.SearchVO;
import com.bluedigm.springboard.entity.BoardDAO;
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
		// TODO Auto-generated method stub
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

	@Override
	public Optional<BoardDAO> select(String link) {
		// TODO Auto-generated method stub
		return null;
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
