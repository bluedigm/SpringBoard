package com.bluedigm.springboard.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bluedigm.springboard.entity.UserDAO;

@Repository
public class UserRepo {
	@Autowired
	SqlSession sql;
	static String namespace = "mappers.user";

	public boolean insert(UserDAO dao) {
		return sql.insert(namespace + ".insert", dao) > 0;
	}

	public boolean update(UserDAO dao) {
		return sql.update(namespace + ".update", dao) > 0;
	}

	public UserDAO select(int id) {
		return sql.selectOne(namespace + ".select", id);
	}

	public UserDAO select(String name) {
		return sql.selectOne(namespace + ".selectName", name);
	}

	public List<UserDAO> search(UserDAO dao) {
		return sql.selectList(namespace + ".search", dao);
	}

	public List<UserDAO> searchAll() {
		return sql.selectList(namespace + ".searchAll");
	}

	public List<UserDAO> searchAll(int page, int size) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", page * size);
		map.put("size", size);
		return sql.selectList(namespace + ".searchLimitAll", map);
	}

	public List<UserDAO> searchAll(String opt, String value, int page, int size) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(opt, "%" + value + "%");
		map.putIfAbsent("name", "%");
		map.putIfAbsent("nick", "%");
		map.putIfAbsent("email", "%");
		map.put("start", page * size);
		map.put("size", size);
		return sql.selectList(namespace + ".searchLimitLikeAll", map);
	}

	public int count() {
		return sql.selectOne(namespace + ".count");
	}

	public boolean delete(int id) {
		return sql.delete(namespace + ".delete", id) > 0;
	}
}
