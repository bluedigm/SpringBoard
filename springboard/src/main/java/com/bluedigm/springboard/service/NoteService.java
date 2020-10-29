package com.bluedigm.springboard.service;

import java.util.Optional;

import com.bluedigm.springboard.domain.BoardHomeVO;
import com.bluedigm.springboard.domain.NoteCreateVO;
import com.bluedigm.springboard.domain.NoteDeleteVO;
import com.bluedigm.springboard.domain.NoteHomeVO;
import com.bluedigm.springboard.domain.NoteUpdateVO;
import com.bluedigm.springboard.domain.SearchVO;
import com.bluedigm.springboard.entity.BoardDAO;
import com.bluedigm.springboard.entity.NoteDAO;
import com.bluedigm.springboard.entity.UserDAO;

public interface NoteService {

	public boolean create(NoteCreateVO vo);

	public boolean update(NoteUpdateVO vo);

	public boolean delete(NoteDeleteVO vo);

	public Optional<NoteDAO> select(int id);

	public SearchVO<NoteDAO> search();

	public SearchVO<NoteDAO> search(SearchVO<NoteDAO> vo);

	public boolean verify(NoteDAO note);

	public NoteHomeVO home(UserDAO user, BoardDAO board, NoteDAO note);
}
