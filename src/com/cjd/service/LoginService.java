package com.cjd.service;

import java.sql.SQLException;

import com.cjd.pojo.Admin;
import com.cjd.pojo.Student;
import com.cjd.pojo.Teacher;

public interface LoginService {
	public Admin selectALladmin(String name,String password) throws SQLException;
	public Student selectALlStudent(String name,String password) throws SQLException;
	public Teacher selectALlTeacher(String name,String password) throws SQLException;
}
