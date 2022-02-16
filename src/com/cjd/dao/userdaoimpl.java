package com.cjd.dao;

import java.sql.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cjd.pojo.Admin;
import com.cjd.pojo.Student;
import com.cjd.pojo.Teacher;
import com.cjd.pojo.Title;
import com.cjd.utils.DBUtil;


public class userdaoimpl implements userDao {

	@Override
	public Admin selectALladmin(String name, String password) throws SQLException {
		// TODO Auto-generated method stub
		DBUtil dbUtil=new DBUtil();		
		String sql="select * from s_admin where name=? and password=?";
		PreparedStatement ps=(PreparedStatement)dbUtil.getPreparedStatement(sql);
		ps.setString(1, name);
		ps.setString(2, password);
		ResultSet rs=ps.executeQuery();
		Admin admin=new Admin();
		while(rs.next()) {
			admin.setName(rs.getString("name"));
			admin.setPassword(rs.getString("password"));
			return admin;
		}
		return null;
	}

	@Override
	public Student selectALlStudent(String name, String password) throws SQLException {
		// TODO Auto-generated method stub
		DBUtil dbUtil=new DBUtil();		
		String sql="\r\n"+"select * from s_student where name=? and password=?";
		PreparedStatement ps=(PreparedStatement)dbUtil.getPreparedStatement(sql);
		ps.setString(1, name);
		ps.setString(2, password);
		ResultSet rs=ps.executeQuery();
		Student student=new Student();
		while(rs.next()) {
			student.setStudentID(rs.getInt("studentID"));
			student.setName(rs.getString("name"));
			student.setPassword(rs.getString("password"));
			student.setTitleID(rs.getInt("titleID"));
			return student;
		}
		return null;
	}


	@Override
	public Teacher selectALlTeacher(String name, String password) throws SQLException {
		// TODO Auto-generated method stub
		DBUtil dbUtil=new DBUtil();		
		String sql="select * from s_teacher where name=? and password=?";
		PreparedStatement ps=(PreparedStatement)dbUtil.getPreparedStatement(sql);
		ps.setString(1, name);
		ps.setString(2, password);
		ResultSet rs=ps.executeQuery();
		Teacher teacher=new Teacher();
		while(rs.next()) {
			teacher.setTeacherID(rs.getString("teacherID"));
			teacher.setT_name(rs.getNString("name"));
			teacher.setPassword(rs.getNString("password"));
			System.out.println("dao"+teacher);
			return teacher;
		}
		return null;
	}
	
	@Override
	public List<Object> selectTeacherList() throws SQLException {
		// TODO Auto-generated method stub
		DBUtil dbUtil = new DBUtil();
		String sql = "select * from teacherinfo";
		Statement st = (Statement)dbUtil.getStatement();//Statement对象，用于执行不带参数的简单SQL语句。
		ResultSet rs = st.executeQuery(sql);
		//List<Object> list = null; //修改为下面这一行非空设定后，数据接口请求异常:parsererror 消失
		List<Object> list = new ArrayList<Object>();
		while(rs.next()) {
			Teacher teacher = new Teacher();
			teacher.setTeacherID(rs.getString("teacherID"));
			teacher.setT_name(rs.getString("t_name"));
			teacher.setT_sex(rs.getString("t_sex"));
			teacher.setT_age(rs.getInt("t_age"));
			teacher.setT_dept(rs.getString("t_dept"));
			teacher.setT_tel(rs.getString("t_tel"));
			teacher.setT_wechat(rs.getString("t_wechat"));
			teacher.setProfessional(rs.getString("professional"));
			list.add(teacher);
		}
		return list;
	}

	@Override
	public List<Object> selectTeacherList(String page,String limit) throws SQLException {
		// TODO Auto-generated method stub
		DBUtil dbUtil = new DBUtil();
		String sql = "select * from teacherinfo limit ?,?"; 
		PreparedStatement ps = (PreparedStatement)dbUtil.getPreparedStatement(sql);
		int page1 = Integer.parseInt(page);
		int limit1 = Integer.parseInt(limit);
		//ps.setInt(1, page1); //分别获取分页的页数page1和每页的数据条数limit1
		ps.setInt(1, (page1-1)*limit1); //不能直接用page1来显示数据，从0开始要用（page1-1）*limit1（每页数据行数），否则会出现显示异常
		
		ps.setInt(2, limit1);
		ResultSet rs =ps.executeQuery();
		//List<Object> list = null; //修改为下面这一行非空设定后，数据接口请求异常:parsererror 消失
		List<Object> list = new ArrayList<Object>();
		while(rs.next()) {
			Teacher teacher = new Teacher();
			teacher.setTeacherID(rs.getString("teacherId"));
			teacher.setT_name(rs.getString("tname"));
			teacher.setT_sex(rs.getString("tsex"));
			teacher.setT_age(rs.getInt("tage"));
			teacher.setT_dept(rs.getString("tdept"));
			teacher.setT_tel(rs.getString("tel"));
			teacher.setT_wechat(rs.getString("wechat"));
			teacher.setProfessional(rs.getString("professional"));
			list.add(teacher);
		}
		return list;	
	}

	@Override
	public int countTeacher() throws SQLException {
		// TODO Auto-generated method stub
		DBUtil dbUtil = new DBUtil();
		String sql = "select count(*) as sum from teacherinfo";
		Statement st = (Statement)dbUtil.getStatement();//Statement对象，用于执行不带参数的简单SQL语句。
		ResultSet rs = st.executeQuery(sql);
		while (rs.next()) {
			return rs.getInt("sum");
		}
	
		return 0;
  }

	@Override
	public int countStudent() throws SQLException {
		// TODO Auto-generated method stub
		DBUtil dbUtil = new DBUtil();
		String sql = "select count(*) as sum from studentinfo";
		Statement st = (Statement)dbUtil.getStatement();//Statement对象，用于执行不带参数的简单SQL语句。
		ResultSet rs = st.executeQuery(sql);
		while (rs.next()) {
			return rs.getInt("sum");
		}
	
		return 0;
	}

	@Override
	public List<Object> selectStudentList() throws SQLException {
		// TODO Auto-generated method stub
		DBUtil dbUtil = new DBUtil();
		String sql = "select * from studentinfo"; 
		PreparedStatement ps = (PreparedStatement)dbUtil.getPreparedStatement(sql);
	//	int page1 = Integer.parseInt(page);
	//	int limit1 = Integer.parseInt(limit);
		//ps.setInt(1, page1); //分别获取分页的页数page1和每页的数据条数limit1
	//	ps.setInt(1, (page1-1)*limit1); //不能直接用page1来显示数据，从0开始要用（page1-1）*limit1（每页数据行数），否则会出现显示异常
		
	//	ps.setInt(2, limit1);
		ResultSet rs =ps.executeQuery();
		//List<Object> list = null; //修改为下面这一行非空设定后，数据接口请求异常:parsererror 消失
		List<Object> list = new ArrayList<Object>();
		while(rs.next()) {
			Student student = new Student();
			student.setTeacherID(rs.getString("teacherID"));
			student.setName(rs.getString("name"));
			student.setSexString(rs.getString("sex"));
			student.setAge(rs.getInt("age"));
			student.setTitleID(rs.getInt("titleID"));
			student.setGrade(rs.getInt("grade"));
			student.setClazz(rs.getString("clazz"));
			student.setStudentID(rs.getInt("studentID"));
			list.add(student);
		}
		return list;
	}

	@Override
	public int addStudent(Student student) throws SQLException {
		// TODO Auto-generated method stub
		DBUtil dbUtil = new DBUtil();
		String sql = "insert into s_student(name,password,studentId) values(?,?,?)";
		
		PreparedStatement ps = (PreparedStatement)dbUtil.getPreparedStatement(sql);
	
		ps.setString(1, student.getName());
		ps.setString(2, student.getPassword());
		ps.setInt(3, student.getStudentID());
		
	
		int rs1 = ps.executeUpdate();
		
	//	System.out.println(rs1+"    test");
		if(rs1==1) {
			dbUtil.commit();
			String sql2 = "insert into studentinfo(name,studentId) values(?,?)";
			PreparedStatement ps2 = (PreparedStatement)dbUtil.getPreparedStatement(sql2);
			ps2.setString(1, student.getName());
			ps2.setInt(2, student.getStudentID());
			int rs2 = ps2.executeUpdate();   //出现过只有student表和teacher表更新而teacherInfo和studentInfo没有更新，原因在于更新数据库时使用的变量依然用成student的变量了，一定要记得看清楚
			System.out.println(rs2+"    test");
			if(rs2==1) {
				dbUtil.commit();
				return 1;
			}else {
				dbUtil.connectionRollback();
				return 0;
			}

		}else {
			dbUtil.connectionRollback();
			return 0;
		}
		
	}

	@Override
	public int addTeacher(Teacher teacher) throws SQLException {
		// TODO Auto-generated method stub
		DBUtil dbUtil = new DBUtil();
		String sql = "insert into s_teacher(name,password,teacherId) values(?,?,?)";
		
		PreparedStatement ps = (PreparedStatement)dbUtil.getPreparedStatement(sql);
		
		ps.setString(1, teacher.getT_name());
		ps.setString(2, teacher.getPassword());
		ps.setString(3, teacher.getTeacherID());
		
	
		int rs1 = ps.executeUpdate();
		
		if(rs1==1) {
		    dbUtil.commit();
		    String sql2 = "insert into teacherinfo(tname,teacherId) values(?,?)";
		    PreparedStatement ps2 = (PreparedStatement)dbUtil.getPreparedStatement(sql2);
			ps2.setString(1, teacher.getT_name());
			ps2.setString(2, teacher.getTeacherID());
			int rs2 = ps2.executeUpdate();
			if(rs2==1) {
				dbUtil.commit();
				return 1;
			}else {
				dbUtil.connectionRollback();
				return 0;
			}
			
		}else {
			dbUtil.connectionRollback();
			return 0;	
		}
	
	}

	@Override
	public List<Object> selectTitleList(String page, String limit) throws SQLException {
		// TODO Auto-generated method stub
		DBUtil dbUtil = new DBUtil();
		String sql = "select * from titleinfo limit ?,?"; 
		PreparedStatement ps = (PreparedStatement)dbUtil.getPreparedStatement(sql);
		int page1 = Integer.parseInt(page);
		int limit1 = Integer.parseInt(limit);
		//ps.setInt(1, page1); //分别获取分页的页数page1和每页的数据条数limit1
		ps.setInt(1, (page1-1)*limit1); //不能直接用page1来显示数据，从0开始要用（page1-1）*limit1（每页数据行数），否则会出现显示异常
		
		ps.setInt(2, limit1);
		ResultSet rs =ps.executeQuery();
		//List<Object> list = null; //修改为下面这一行非空设定后，数据接口请求异常:parsererror 消失
		List<Object> list = new ArrayList<Object>();
		while(rs.next()) {
			Title title = new Title();
			title.setTitleID(rs.getInt("titleID"));
			title.setType(rs.getString("type"));
			title.setName(rs.getString("name"));
			title.setTeacherID(rs.getString("teacherID"));
			list.add(title);
		}
		return list;
	}

	@Override
	public int countTitle() throws SQLException {
		// TODO Auto-generated method stub
		DBUtil dbUtil = new DBUtil();
		String sql = "select count(*) as sum from titleinfo";
		Statement st = (Statement)dbUtil.getStatement();//Statement对象，用于执行不带参数的简单SQL语句。
		ResultSet rs = st.executeQuery(sql);
		while (rs.next()) {
			return rs.getInt("sum");
		}
	
		return 0;
	}

	@Override
	public List<Object> selectTitleList(String name) throws SQLException {
		// TODO Auto-generated method stub
		DBUtil dbUtil = new DBUtil();
		String sql = "select * from titleinfo where name like '%"+name+"%'"; 
		PreparedStatement ps = (PreparedStatement)dbUtil.getPreparedStatement(sql);
		//int page1 = Integer.parseInt(page);
	//	int limit1 = Integer.parseInt(limit);
		//ps.setInt(1, page1); //分别获取分页的页数page1和每页的数据条数limit1
	//	ps.setInt(1, (page1-1)*limit1); //不能直接用page1来显示数据，从0开始要用（page1-1）*limit1（每页数据行数），否则会出现显示异常
		
	//	ps.setInt(2, limit1);
		ResultSet rs =ps.executeQuery();
		//List<Object> list = null; //修改为下面这一行非空设定后，数据接口请求异常:parsererror 消失
		List<Object> list = new ArrayList<Object>();
		while(rs.next()) {
			Title title = new Title();
			title.setTitleID(rs.getInt("titleID"));
			title.setType(rs.getString("type"));
			title.setName(rs.getString("name"));
			title.setTeacherID(rs.getString("teacherID"));
			list.add(title);
		}
		return list;
	}

	@Override
	public Admin selectAlAdmin(String name, String password) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Teacher selecALlTeacher(String name, String password) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	
}