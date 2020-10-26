package com.bluedigm.springboard.repository;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bluedigm.springboard.entity.BoardDAO;
import com.bluedigm.springboard.entity.JoinDAO;
import com.bluedigm.springboard.entity.UserDAO;

@Repository
public class JoinRepo {
	@Autowired
	SqlSession sql;
	static String namespace = "mappers.join";
//
//	public Optional<Object> select(int user, int board) {
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("userId", user);
//		map.put("boardId", board);
//		return Optional.of(sql.selectOne(namespace + ".selectMember", map));
//	}
//
//	public List<JoinDAO> searchDetailAll(int board, int page, int size) {
//
//		try {
//			Map<String, Object> map = new HashMap<String, Object>();
//			map.put("boardId", board);
//			map.put("start", page * size);
//			map.put("size", size);
//			return sql.selectList(namespace + ".searchBoardLimit", map);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return new LinkedList<JoinDAO>();
//		}
//	}

	public List<JoinDAO> searchMember(UserDAO dao, int page, int size) {

		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", dao.getId());
			map.put("start", page * size);
			map.put("size", size);
			return sql.selectList(namespace + ".searchMemberByUserLimit", map);
		} catch (Exception e) {
			e.printStackTrace();
			return new LinkedList<JoinDAO>();
		}
	}

	public List<JoinDAO> searchNote(BoardDAO dao, int page, int size) {

		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", dao.getId());
			map.put("start", page * size);
			map.put("size", size);
			return sql.selectList(namespace + ".searchNoteByBoardLimit", map);
		} catch (Exception e) {
			e.printStackTrace();
			return new LinkedList<JoinDAO>();
		}
	}
}
