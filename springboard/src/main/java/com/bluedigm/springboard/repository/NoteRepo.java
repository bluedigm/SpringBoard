package com.bluedigm.springboard.repository;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bluedigm.springboard.entity.NoteDAO;

@Repository
public class NoteRepo {
	@Autowired
	SqlSession sql;
	static String namespace = "mappers.note";

	public boolean insert(NoteDAO dao) {
		try {
			return sql.insert(namespace + ".insert", dao) > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(NoteDAO dao) {
		try {
			return sql.update(namespace + ".update", dao) > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(int id) {
		try {
			return sql.delete(namespace + ".delete", id) > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Optional<NoteDAO> select(int id) {
		try {
			return Optional.of(sql.selectOne(namespace + ".selectId", id));
		} catch (Exception e) {
			e.printStackTrace();
			return Optional.empty();
		}
	}

	public List<NoteDAO> search(int board) {
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("boardId", board);
			return sql.selectList(namespace + ".searchBoard", map);
		} catch (Exception e) {
			e.printStackTrace();
			return new LinkedList<NoteDAO>();
		}
	}

	public List<NoteDAO> search(int board, int page, int size) {
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("boardId", board);
			map.put("start", page * size);
			map.put("size", size);
			return sql.selectList(namespace + ".searchBoardLimit", map);
		} catch (Exception e) {
			e.printStackTrace();
			return new LinkedList<NoteDAO>();
		}
	}

	public Optional<Integer> count() {
		try {
			return Optional.of(sql.selectOne(namespace + ".count"));
		} catch (Exception e) {
			e.printStackTrace();
			return Optional.empty();
		}
	}
}
