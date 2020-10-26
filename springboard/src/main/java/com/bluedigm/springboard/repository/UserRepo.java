package com.bluedigm.springboard.repository;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
		try {
			return sql.insert(namespace + ".insert", dao) > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(UserDAO dao) {
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

	public Optional<UserDAO> select(int id) {
		try {
			return Optional.of(sql.selectOne(namespace + ".selectId", id));
		} catch (Exception e) {
			e.printStackTrace();
			return Optional.empty();
		}
	}

	public Optional<UserDAO> select(String name) {
		try {
			return Optional.of(sql.selectOne(namespace + ".selectName", name));
		} catch (Exception e) {
			e.printStackTrace();
			return Optional.empty();
		}
	}

	public List<UserDAO> search() {
		try {
			return sql.selectList(namespace + ".search");
		} catch (Exception e) {
			e.printStackTrace();
			return new LinkedList<UserDAO>();
		}
	}

	public List<UserDAO> search(int page, int size) {

		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("start", page * size);
			map.put("size", size);
			return sql.selectList(namespace + ".searchLimit", map);
		} catch (Exception e) {
			e.printStackTrace();
			return new LinkedList<UserDAO>();
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
