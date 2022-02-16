package com.cjd.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class DBUtil {
	
   // 闁告梻濮惧ù鍥ㄣ仚閸楃偛袟闁告艾绉撮幏浼村极閻楀牆绁﹂幖瀛樻尭濠�鎾锤閿燂拷
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost:3306/g_design?useUnicode=true&characterEncoding=UTF-8";

   //  闁轰胶澧楀畵浣规償閹捐埖鏆忛柟鏉戝槻閹洜锟介潧妫涢悥锟�
   static final String USER = "root";
   static final String PASS = "";
	
	static {
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstmt;
	
	private void openConnection() {
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	//鍥炴粴
	public void connectionRollback() {
		try {
			conn.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	//鎻愪氦浜嬪姟顏勵潳
	public void commit() {
		try {
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//闁兼儳鍢茬欢鐩
	public Statement getStatement() {
		openConnection();
		try {
			stat = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stat;
	}
	
	//闁兼儳鍢茬欢鐩eparedStatement
	public PreparedStatement getPreparedStatement(String sql) {
		openConnection();
		try {
			pstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pstmt;
	}
	
	//闁稿繑濞婂Λ鏉懨归敓锟�
	public void closeResource() {
		try {
			if (pstmt != null && !pstmt.isClosed()) {
				pstmt.close();
			}
			
			if (stat != null && !stat.isClosed()) {
				stat.close();
			}
			
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
