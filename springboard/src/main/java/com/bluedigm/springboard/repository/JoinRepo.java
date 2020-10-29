package com.bluedigm.springboard.repository;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bluedigm.springboard.entity.BoardDAO;
import com.bluedigm.springboard.entity.JoinDAO;
import com.bluedigm.springboard.entity.UserDAO;

@Repository
public class JoinRepo {
	@Autowired
	SqlSession sql;
	static String namespace = "mappers.join";

	public List<JoinDAO> searchMember(int id, int page, int size) {

		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", id);
			map.put("start", page * size);
			map.put("size", size);
			return sql.selectList(namespace + ".searchMemberByUserLimit", map);
		} catch (Exception e) {
			e.printStackTrace();
			return new LinkedList<JoinDAO>();
		}
	}

	public List<JoinDAO> searchNote(int id, int page, int size) {

		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", id);
			map.put("start", page * size);
			map.put("size", size);
			return sql.selectList(namespace + ".searchNoteByBoardLimit", map);
		} catch (Exception e) {
			e.printStackTrace();
			return new LinkedList<JoinDAO>();
		}
	}
}
