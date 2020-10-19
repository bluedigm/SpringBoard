package com.bluedigm.springboard.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bluedigm.springboard.entity.UserDAO;

@Repository
public class UserRepo {
	@Autowired
	SqlSession sql;
	static String namespace = "com.bluedigm.springboard.entity.UserDAO";

	public void insert(UserDAO user)
	{
		sql.insert(namespace+".insertUser",user);
	}
}