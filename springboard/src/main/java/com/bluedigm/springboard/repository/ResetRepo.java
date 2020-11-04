package com.bluedigm.springboard.repository;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bluedigm.springboard.entity.ResetDAO;

@Repository
public class ResetRepo {
	@Autowired
	SqlSession sql;
	static String namespace = "mappers.reset";

	public boolean insert(ResetDAO dao) {
		try {
			return sql.insert(namespace + ".insert", dao) > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(ResetDAO dao) {
		try {
			return sql.update(namespace + ".update", dao) > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(int user) {
		try {
			return sql.delete(namespace + ".delete", user) > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Optional<ResetDAO> select(int user) {
		try {
			return Optional.of(sql.selectOne(namespace + ".select", user));
		} catch (Exception e) {
			e.printStackTrace();
			return Optional.empty();
		}
	}

	public List<ResetDAO> search() {
		try {
			return sql.selectList(namespace + ".search");
		} catch (Exception e) {
			e.printStackTrace();
			return new LinkedList<ResetDAO>();
		}
	}
}
