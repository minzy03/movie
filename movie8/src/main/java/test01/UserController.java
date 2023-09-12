package test01;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import test01.User;
import test01.UserDAO;

@WebServlet("/user01/*")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	UserDAO userDAO;

	public void init(ServletConfig config) throws ServletException {
		userDAO = new UserDAO();
		System.out.println("UserDAO init 생성자 생성");
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextPage = "";
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String action = request.getPathInfo();
		System.out.println("action : " + action);
		
		if (action == null || action.equals("/userList.do")) {
			List<User> userList = userDAO.selectUserList();
			request.setAttribute("userList", userList);
			nextPage = "/test01/userList.jsp";	
			
		}else if (action.equals("/addUser.do")){
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			User user = new User(id,pwd,name,email);
			userDAO.insertUser(user);
			nextPage = "/user01/userList.do";
			
		} else if (action.equals("/userForm.do")) {
			nextPage="/test01/userForm.jsp";
			
		} else if (action.equals("/loginForm.do")) {
			nextPage="/test01/loginForm.jsp";	
			
		} else if (action.equals("/login.do")) {
			nextPage="/test01/userMenu.jsp";		
			
		}else if(action.equals("/deleteUser.do")) {
			String id = request.getParameter("id");
			userDAO.deleteUserById(id);
			request.setAttribute("msg","deleted");
			nextPage= "/user01/userList.do";
			
		}else {
			List<User> userList = userDAO.selectUserList();
			request.setAttribute("userList", userList);
			nextPage="/test01/userList.jsp";
		}
		
		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
		dispatch.forward(request, response);
	}
}

