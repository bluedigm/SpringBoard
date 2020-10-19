package com.bluedigm.springboard;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/*.xml" })
public class DataSourceTest {

	final String DRIVER = "com.mysql.cj.jdbc.Driver";
	final String URL = "jdbc:mysql://vip.sejong.ac.kr:3306/springboard?serverTimezone=UTC";
	final String USER = "vip";
	final String PW = "vip.sejong.ac.kr";

	@Autowired
	SqlSessionFactory sqlFactory;

	@Test
	public void testJDBC() throws Exception {
		Class.forName(DRIVER);
		try {
			Connection con = DriverManager.getConnection(URL, USER, PW);
			System.out.println("jdbc:" + con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Autowired
	DataSource data;

	@Test
	public void testDS() throws Exception {
		try {
			Connection con = data.getConnection();
			System.out.println("datasource:" + con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testFactory() throws Exception {
		try {
//			String resource = "file:"
//					+ "\\src\\main\\resources\\mybatis.xml";
//			InputStream inputStream = Resources.getResourceAsStream(resource);
//			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			System.out.println("sqlfactory:" + sqlFactory);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSession() throws Exception {
		try {
			SqlSession sqlSession = sqlFactory.openSession();
			System.out.println("sqlsseion:" + sqlSession);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
