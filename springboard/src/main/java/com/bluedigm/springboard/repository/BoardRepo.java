package com.bluedigm.springboard.repository;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

	public Optional<BoardDAO> select(int id) {
		try {
			return Optional.of(sql.selectOne(namespace + ".selectId", id));
		} catch (Exception e) {
			e.printStackTrace();
			return Optional.empty();
		}
	}

	public Optional<BoardDAO> select(String link) {
		try {
			return Optional.of(sql.selectOne(namespace + ".selectLink", link));
		} catch (Exception e) {
			e.printStackTrace();
			return Optional.empty();
		}
	}

	public List<BoardDAO> search() {
		try {
			return sql.selectList(namespace + ".search");
		} catch (Exception e) {
			e.printStackTrace();
			return new LinkedList<BoardDAO>();
		}
	}

	public List<BoardDAO> search(int page, int size) {
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("start", page * size);
			map.put("size", size);
			return sql.selectList(namespace + ".searchLimit", map);
		} catch (Exception e) {
			e.printStackTrace();
			return new LinkedList<BoardDAO>();
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
