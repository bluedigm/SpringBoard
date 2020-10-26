package com.bluedigm.springboard.repository;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bluedigm.springboard.entity.BoardDAO;
import com.bluedigm.springboard.entity.NoteDAO;
import com.bluedigm.springboard.entity.join.NoteJoin;

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

	@Transactional(readOnly = true)
	public Optional<NoteDAO> select(int id) {
		try {
			return Optional.ofNullable(sql.selectOne(namespace + ".select", id));
		} catch (Exception e) {
			e.printStackTrace();
			return Optional.empty();
		}
	}

	@Transactional(readOnly = true)
	public Optional<NoteDAO> select(String link) {
		try {
			return Optional.ofNullable(sql.selectOne(namespace + ".selectLink", link));
		} catch (Exception e) {
			e.printStackTrace();
			return Optional.empty();
		}
	}

	@Transactional(readOnly = true)
	public List<NoteDAO> searchAll() {
		try {
			return sql.selectList(namespace + ".searchAll");
		} catch (Exception e) {
			e.printStackTrace();
			return new LinkedList<NoteDAO>();
		}
	}

	@Transactional(readOnly = true)
	public List<NoteDAO> searchAll(int page, int size) {

		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("start", page * size);
			map.put("size", size);
			return sql.selectList(namespace + ".searchLimitAll", map);
		} catch (Exception e) {
			e.printStackTrace();
			return new LinkedList<NoteDAO>();
		}
	}

	@Transactional(readOnly = true)
	public List<NoteDAO> searchAll(int id, int page, int size) {

		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("boardId",id);
			map.put("start", page * size);
			map.put("size", size);
			return sql.selectList(namespace + ".searchLimitBoardAll", map);
		} catch (Exception e) {
			e.printStackTrace();
			return new LinkedList<NoteDAO>();
		}
	}
	@Transactional(readOnly = true)
	public List<NoteJoin> searchDetailAll(int id, int page, int size) {

		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("boardId",id);
			map.put("start", page * size);
			map.put("size", size);
			return sql.selectList(namespace + ".searchLimitBoardDetailAll", map);
		} catch (Exception e) {
			e.printStackTrace();
			return new LinkedList<NoteJoin>();
		}
	}
	@Transactional(readOnly = true)
	public Optional<Integer> count() {
		try {
			return Optional.ofNullable(sql.selectOne(namespace + ".count"));
		} catch (Exception e) {
			e.printStackTrace();
			return Optional.empty();
		}
	}
}
