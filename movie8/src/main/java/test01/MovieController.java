package test01;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/movie01/*")
public class MovieController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	MovieDAO movieDAO;
	
	public void init(ServletConfig config) throws ServletException {
		movieDAO = new MovieDAO();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextPage = "";
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String action = request.getPathInfo();
		System.out.println("action:"+action);
		
		if(action == null || action.equals("/movieList.do")) {
			List<Movie> movieList = movieDAO.selectMovieList();
			request.setAttribute("movieList", movieList);
			nextPage = "/test01/movieList.jsp";
			
		}else if(action.equals("/adminMovieList.do")) {
			List<Movie> movieList = movieDAO.selectMovieList();
			request.setAttribute("movieList", movieList);
			nextPage = "/test01/adminMovieList.jsp";
		
		}else if(action.equals("/addMovie.do")) {
			String title = request.getParameter("title");
			String genre = request.getParameter("genre");
			Movie movie = new Movie(title,genre);
			movieDAO.insertMovie(movie);
			request.setAttribute("msg", "save");
			nextPage = "/movie01/movieList.do";
		
		}else if(action.equals("/movieForm.do")) {
			nextPage="/test01/movieForm.jsp";
			
		}else if(action.equals("/deleteMovie.do")) {
			int id = (Integer.parseInt(request.getParameter("id")));
			movieDAO.deleteMovieById(id);
			request.setAttribute("msg", "deleted");
			nextPage = "/movie01/movieList.do";
			
		}else {
			List<Movie> movieList = movieDAO.selectMovieList();
			request.setAttribute("movieList", movieList);
			nextPage = "/test01/movieList.jsp";
		}
		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
		dispatch.forward(request, response);
	}

}
