package com.bluedigm.springboard;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.bluedigm.springboard.entity.UserDAO;
import com.bluedigm.springboard.repository.UserRepo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/*.xml" })
public class UserTest {
	@Autowired
	UserRepo userRepo;
	static String namespace = "mappers.user";

	@Test
	@Transactional
	public void testInsert() throws Exception {
		try {
			UserDAO dao = new UserDAO();
			dao.setEmail("");
			dao.setPassword("");
			userRepo.insert(dao);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	@Transactional
	public void testUpdate() throws Exception {
		try {
			UserDAO dao = new UserDAO();
			dao.setEmail("");
			dao.setPassword("");
			userRepo.insert(dao);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	@Transactional
	public void testSelect() throws Exception {
		try {
			UserDAO dao = new UserDAO();
			dao.setEmail("");
			dao.setPassword("");
			userRepo.insert(dao);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	@Transactional
	public void testDelete() throws Exception {
		try {
			UserDAO dao = new UserDAO();
			dao.setEmail("");
			dao.setPassword("");
			userRepo.insert(dao);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
