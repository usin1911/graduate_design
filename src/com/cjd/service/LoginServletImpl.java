package com.cjd.service;

import java.sql.SQLException;

import com.cjd.dao.userDao;
import com.cjd.dao.userdaoimpl;
import com.cjd.pojo.Admin;
import com.cjd.pojo.Student;
import com.cjd.pojo.Teacher;

public class LoginServletImpl implements LoginService {
	private userDao userDao=new userdaoimpl();
	
	@Override
	public Admin selectALladmin(String name, String password) throws SQLException {
		// TODO Auto-generated method stub
		return userDao.selectAlAdmin(name, password);
	}

	@Override
	public Student selectALlStudent(String name, String password) throws SQLException {
		// TODO Auto-generated method stub
		return userDao.selectALlStudent(name, password);
	}

	@Override
	public Teacher selectALlTeacher(String name, String password) throws SQLException {
		// TODO Auto-generated method stub
		return userDao.selecALlTeacher(name, password);
	}

}
