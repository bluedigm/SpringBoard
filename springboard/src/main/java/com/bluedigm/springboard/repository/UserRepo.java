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

	public boolean update(String username, UserDAO dao) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("old", username);
		param.put("new", dao.getUsername());
		param.put("nickname", dao.getNickname());
		param.put("password", dao.getPassword());
		param.put("email", dao.getEmail());

		return sql.update(namespace + ".update", param) > 0;
	}

	public UserDAO select(String username) {
		return sql.selectOne(namespace + ".select", username);
	}

	public List<UserDAO> search(String username, String nickname, String email) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("username", username);
		param.put("nickname", nickname);
		param.put("email", email);
		return sql.selectList(namespace + ".search", param);
	}

	public boolean delete(String username) {
		return sql.delete(namespace + ".delete", username) > 0;
	}
}
