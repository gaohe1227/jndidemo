package com.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
/**
 * 
 * jndi测试类
 *
 * @author <a href="mailto:904724283@qq.com">gaohe</a>
 * @version 2016年11月9日
 */
public class DataBaseConnection {
	public static Connection getConnection() throws NamingException, SQLException {
		Connection conn = null;
		String jndi = "jdbc/mysql";
		Context initContext = new InitialContext();
		Context envContext = (Context) initContext.lookup("java:/comp/env");// 固定，不需要修改
		DataSource ds = (DataSource) envContext.lookup(jndi);
		if (ds != null) {

			conn = ds.getConnection();
		}

		return conn;
	}

	public static List<String> selectById(int id) throws InstantiationException, IllegalAccessException, NamingException, SQLException {
		Connection con = null;

		con = getConnection();

		List<String> list = new ArrayList<String>();
		String sql = "select * from user where userId=?";

		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			list.add(rs.getString(1));
			list.add(rs.getString(2));
			list.add(rs.getString(3));
			System.out.println(rs.getString(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
		}

		return list;
	}
}
