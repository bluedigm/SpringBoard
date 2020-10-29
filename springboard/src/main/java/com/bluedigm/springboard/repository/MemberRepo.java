package com.bluedigm.springboard.repository;

import java.util.HashMap;
import java.util.LinkedList;
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
		try {
			return sql.insert(namespace + ".insert", dao) > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(MemberDAO dao) {
		try {
			return sql.update(namespace + ".update", dao) > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(int board, int user) {
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("boardId", board);
			map.put("userId", user);
			return sql.delete(namespace + ".delete", map) > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Optional<MemberDAO> select(int board, int user) {
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("boardId", board);
			map.put("userId", user);
			return Optional.of(sql.selectOne(namespace + ".select", map));
		} catch (Exception e) {
			e.printStackTrace();
			return Optional.empty();
		}
	}

	public List<MemberDAO> searchByBoard(int id) {
		try {
			return sql.selectList(namespace + ".searchBoard", id);
		} catch (Exception e) {
			e.printStackTrace();
			return new LinkedList<MemberDAO>();
		}
	}

	public List<MemberDAO> searchByUser(int id) {
		try {
			return sql.selectList(namespace + ".searchUser", id);
		} catch (Exception e) {
			e.printStackTrace();
			return new LinkedList<MemberDAO>();
		}
	}
}
