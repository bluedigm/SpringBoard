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

	public UserDAO select(String username) {
		return sql.selectOne(namespace + "select", username);
	}

	public List<UserDAO> search(String username, String nickname, String email) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("username", username);
		param.put("nickname", nickname);
		param.put("email", email);
		return sql.selectList(namespace + ".search", param);
	}

	public void delete(UserDAO dao) {
		sql.delete(namespace + ".delete", dao);
	}
}
