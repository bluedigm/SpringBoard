package com.bluedigm.springboard.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bluedigm.springboard.entity.MemberDAO;
import com.bluedigm.springboard.entity.join.MemberJoin;

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

	public boolean delete(int id) {
		return sql.delete(namespace + ".delete", id) > 0;
	}

	public MemberDAO select(int user, int board) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", user);
		map.put("boardId", board);
		return sql.selectOne(namespace + ".select", map);
	}

	public List<MemberJoin> searchJoin(int id) {
		return sql.selectList(namespace + ".selectJoin",id);
	}

	public List<MemberDAO> searchU(int id) {
		return sql.selectList(namespace + ".searchU");
	}

	public List<MemberDAO> searchB(int id) {
		return sql.selectList(namespace + ".searchB");
	}
}
