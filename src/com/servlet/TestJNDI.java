package com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.DataBaseConnection;

/**
 * 
 * 测试jndi
 *
 * @author <a href="mailto:904724283@qq.com">gaohe</a>
 * @version 2016年11月9日
 */
@WebServlet("/testJNDI")
public class TestJNDI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestJNDI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	 
				try {
					List<String> strs=	DataBaseConnection.selectById(1);
					for (String string : strs) {
						System.out.println(string);
					}
				}
				catch (InstantiationException | IllegalAccessException | NamingException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
