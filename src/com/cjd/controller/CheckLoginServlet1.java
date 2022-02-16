package com.cjd.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cjd.pojo.Admin;
import com.cjd.pojo.Student;
import com.cjd.pojo.Teacher;
import com.cjd.service.LoginService;
import com.cjd.service.LoginServletImpl;

/**
 * Servlet implementation class CheckLoginServlet1
 */
@WebServlet("/CheckLoginServlet1")
public class CheckLoginServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private LoginService loginService=new LoginServletImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckLoginServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String entity=request.getParameter("entity");
		if (entity.equals("管理员")) {
			Admin admin;
			try {
				admin=loginService.selectALladmin(name, password);
				if (admin!=null) {
					HttpSession session = request.getSession();
					session.setAttribute("admin", admin);
					System.out.print(admin);
					response.getWriter().write("success");
				}else {
					response.getWriter().write("fail");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if (entity.equals("学生")) {
			Student student;
			try {
				student=loginService.selectALlStudent(name, password);
				if (student!=null) {
					HttpSession session = request.getSession();
					session.setAttribute("student", student);
					System.out.print(student);
					response.getWriter().write("success");
				}else {
					response.getWriter().write("fail");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if (entity.equals("教师")) {
			Teacher teacher;
			try {
				teacher=loginService.selectALlTeacher(name, password);
				if (teacher!=null) {
					System.out.print(teacher);
					HttpSession session = request.getSession();
					session.setAttribute("teacher", teacher);
					response.getWriter().write("success");
				}else {
					response.getWriter().write("fail");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
