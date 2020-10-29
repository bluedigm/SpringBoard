package com.bluedigm.springboard.service;

import java.util.Optional;

import com.bluedigm.springboard.domain.BoardCreateVO;
import com.bluedigm.springboard.domain.BoardDeleteVO;
import com.bluedigm.springboard.domain.BoardHomeVO;
import com.bluedigm.springboard.domain.BoardUpdateVO;
import com.bluedigm.springboard.domain.SearchVO;
import com.bluedigm.springboard.entity.BoardDAO;
import com.bluedigm.springboard.entity.UserDAO;

public interface BoardService {

	public boolean create(BoardCreateVO vo);

	public boolean update(BoardUpdateVO vo);

	public boolean delete(BoardDeleteVO vo);

	public Optional<BoardDAO> select(int id);

	public Optional<BoardDAO> select(String link);

	public SearchVO<BoardDAO> search();

	public SearchVO<BoardDAO> search(SearchVO<BoardDAO> vo);

	public boolean verify(UserDAO user, BoardDAO board);

	public BoardHomeVO home(UserDAO user, BoardDAO board);

	public boolean join(UserDAO user, BoardDAO board, boolean flag);

	public boolean leave(UserDAO user, BoardDAO board);
}
