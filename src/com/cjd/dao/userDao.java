package com.cjd.dao;

import java.sql.SQLException;
import java.util.List;

import com.cjd.pojo.Admin;
import com.cjd.pojo.Student;
import com.cjd.pojo.Teacher;

public interface userDao {
	public Admin selectAlAdmin(String name,String password) throws SQLException;
	public Student selectALlStudent(String name,String password)throws SQLException;
	public Teacher selecALlTeacher(String name,String password)throws SQLException;
	public List<Object> selectTeacherList() throws SQLException;
	public List<Object> selectTeacherList(String page,String limit) throws SQLException;
	public List<Object> selectTitleList(String page,String limit) throws SQLException;
	public List<Object> selectTitleList(String name) throws SQLException;
	public List<Object> selectStudentList() throws SQLException;
	public int countTeacher() throws SQLException;
	public int countStudent() throws SQLException;
	public int countTitle() throws SQLException;
	public int addStudent(Student student) throws SQLException;
	public int addTeacher(Teacher teacher) throws SQLException;
	Admin selectALladmin(String name, String password) throws SQLException;
	Teacher selectALlTeacher(String name, String password) throws SQLException;
	
}
