package test01;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/reservation01/*")
public class ReservationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	MovieDAO movieDAO;
	ReservationDAO reservationDAO;
	UserDAO userDAO;
	
	public void init(ServletConfig config) throws ServletException {
		movieDAO = new MovieDAO();
		reservationDAO = new ReservationDAO();
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
		
		if(action == null || action.equals("/reservationList.do")) {
			List<Reservation> reservationList = reservationDAO.selectReservationList();
			request.setAttribute("reservationList", reservationList);
			System.out.println(reservationList);
			nextPage = "/test01/reservationList.jsp";
			
		}else if(action.equals("/reservation.do")) {
			String movieName = request.getParameter("title");
			int movieId = (Integer.parseInt(request.getParameter("id")));
			List<Reservation> reservationList = reservationDAO.selectReservationByMovieName(movieName);
			request.setAttribute("movieName", movieName);
			request.setAttribute("movieId", movieId);
			request.setAttribute("reservationList", reservationList);
			System.out.println("reservationList="+reservationList);
			nextPage = "/test01/seat.jsp";
			
		}else if(action.equals("/newReservation.do")) {
			String[] seat = request.getParameterValues("seat");
			String movieName = request.getParameter("movieName");
			int movieId = (Integer.parseInt(request.getParameter("movieId")));
			Reservation reservation = new Reservation();
			reservation.setMovieName(movieName);
			reservation.setMovieId(movieId);
			int resid = reservationDAO.insertNewReservation(reservation, seat);
			request.setAttribute("resid", resid);
			request.setAttribute("reservation", reservation);
			request.setAttribute("seat", seat);
			nextPage="/test01/newReservation.jsp";
		
		}else if(action.equals("/confirmation.do")) {
			nextPage = "/test01/confirmation.jsp";
			
		}else if(action.equals("/okConfirmation.do")) {
			Reservation reservation = new Reservation();
			int resid = (Integer.parseInt(request.getParameter("resid")));
			reservation = reservationDAO.selectReservationByResid(resid);
			System.out.println(reservation.getResid());
			request.setAttribute("reservation", reservation);
			nextPage="/test01/okConfirmation.jsp";
			
		}else if(action.equals("/cancellation.do")) {
			nextPage = "/reservation01/reservationList.do";

		}else if(action.equals("/okCancellation.do")) {
			int resid = (Integer.parseInt(request.getParameter("resid")));
			reservationDAO.deleteReservationByResid(resid);
			nextPage = "/test01/okCancellation.jsp";
			
		}else {
			List<Movie> movieList = movieDAO.selectMovieList();
			request.setAttribute("movieList", movieList);
			nextPage = "/test01/reservation.jsp";
		}
		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
		dispatch.forward(request, response);
	
	}

}
