package com.bluedigm.springboard.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bluedigm.springboard.entity.MemberDAO;

@Repository
public class MemberRepo {
	@Autowired
	SqlSession sql;
	static String namespace = "mappers.member";

	public boolean insert(MemberDAO dao) {
		return sql.insert(namespace + ".insert", dao) > 0;
	}

	public boolean update(MemberDAO dao) {
		return sql.update(namespace + ".update", dao) > 0;
	}

	public boolean delete(int user, int board) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", user);
		map.put("boardId", board);
		return sql.delete(namespace + ".delete", map) > 0;
	}

	public Optional<MemberDAO> select(int user, int board) {
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("userId", user);
			map.put("boardId", board);
			return Optional.of(sql.selectOne(namespace + ".select", map));
		} catch (Exception e) {
			e.printStackTrace();
			return Optional.empty();
		}
	}

	public List<MemberDAO> searchU(int user) {
		return sql.selectList(namespace + ".searchUser", user);
	}

	public List<MemberDAO> searchB(int board) {
		return sql.selectList(namespace + ".searchBoard", board);
	}
}
