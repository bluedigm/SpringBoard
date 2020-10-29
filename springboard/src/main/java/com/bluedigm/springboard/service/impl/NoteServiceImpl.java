package com.bluedigm.springboard.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluedigm.springboard.domain.BoardHomeVO;
import com.bluedigm.springboard.domain.NoteCreateVO;
import com.bluedigm.springboard.domain.NoteDeleteVO;
import com.bluedigm.springboard.domain.NoteHomeVO;
import com.bluedigm.springboard.domain.NoteUpdateVO;
import com.bluedigm.springboard.domain.SearchVO;
import com.bluedigm.springboard.entity.BoardDAO;
import com.bluedigm.springboard.entity.NoteDAO;
import com.bluedigm.springboard.entity.UserDAO;
import com.bluedigm.springboard.repository.BoardRepo;
import com.bluedigm.springboard.repository.MemberRepo;
import com.bluedigm.springboard.repository.NoteRepo;
import com.bluedigm.springboard.repository.UserRepo;
import com.bluedigm.springboard.service.NoteService;

@Service
public class NoteServiceImpl implements NoteService {
	private static final Logger logger = LoggerFactory.getLogger(NoteServiceImpl.class);
	@Autowired
	UserRepo userRepo;
	@Autowired
	BoardRepo boardRepo;
	@Autowired
	MemberRepo memberRepo;
	@Autowired
	NoteRepo noteRepo;

	@Override
	public boolean create(NoteCreateVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(NoteUpdateVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(NoteDeleteVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Optional<NoteDAO> select(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SearchVO<NoteDAO> search() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SearchVO<NoteDAO> search(SearchVO<NoteDAO> vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean verify(NoteDAO note) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public NoteHomeVO home(UserDAO user, BoardDAO board, NoteDAO note) {
		// TODO Auto-generated method stub
		return null;
	}
}
