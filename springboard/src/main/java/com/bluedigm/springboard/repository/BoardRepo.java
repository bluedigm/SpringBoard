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

@Repository
public class BoardRepo {
	@Autowired
	SqlSession sql;
	static String namespace = "mappers.board";

	public boolean insert(BoardDAO dao) {
		try {
			return sql.insert(namespace + ".insert", dao) > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(BoardDAO dao) {
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
	public Optional<BoardDAO> select(int id) {
		try {
			return Optional.ofNullable(sql.selectOne(namespace + ".select", id));
		} catch (Exception e) {
			e.printStackTrace();
			return Optional.empty();
		}
	}

	@Transactional(readOnly = true)
	public Optional<BoardDAO> select(String link) {
		try {
			return Optional.ofNullable(sql.selectOne(namespace + ".selectLink", link));
		} catch (Exception e) {
			e.printStackTrace();
			return Optional.empty();
		}
	}

	@Transactional(readOnly = true)
	public List<BoardDAO> searchAll() {
		try {
			return sql.selectList(namespace + ".searchAll");
		} catch (Exception e) {
			e.printStackTrace();
			return new LinkedList<BoardDAO>();
		}
	}

	@Transactional(readOnly = true)
	public List<BoardDAO> searchAll(int page, int size) {

		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("start", page * size);
			map.put("size", size);
			return sql.selectList(namespace + ".searchLimitAll", map);
		} catch (Exception e) {
			e.printStackTrace();
			return new LinkedList<BoardDAO>();
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
