package test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservationDAO {
	List<Reservation> reservationList = new ArrayList();
	private Connection conn;
	
	public ReservationDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); //jdbc driver 등록
			conn = DriverManager.getConnection( //연결하기
					"jdbc:mysql://localhost:3306/servletex?useUnicode=true&characterEncoding=utf8",
					"root",
					"1234"
					);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Reservation> selectReservationList(){
		reservationList.clear();
		try {
			String sql = "SELECT resid,seat,movieName,movieId FROM reservation ORDER BY resid DESC";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Reservation reservation = new Reservation();
				reservation.setResid(rs.getInt("resid"));
				reservation.setSeat(rs.getString("seat"));
				reservation.setMovieName(rs.getString("movieName"));
				reservation.setMovieId(rs.getInt("movieId"));
				reservationList.add(reservation);
			}
			rs.close();
			pstmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return reservationList;
	}
	
	public List<Reservation> selectReservationByMovieName(String movieName){
		reservationList.clear();
		Reservation reservation = new Reservation();
		try {
			String sql = "SELECT resid,seat,movieName,movieId FROM reservation WHERE movieName=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, movieName);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				reservation.setResid(rs.getInt("resid"));
				reservation.setSeat(rs.getString("seat"));
				reservation.setMovieName(rs.getString("movieName"));
				reservation.setMovieId(rs.getInt("movieId"));
				reservationList.add(reservation);
			}
			rs.close();
			pstmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return reservationList;
	}
	
	public Reservation selectReservationByResid(int parseInt) {
		Reservation reservation = new Reservation();
		try {
			String sql = "SELECT resid,seat,movieName,movieId FROM reservation WHERE resid=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, parseInt);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				reservation.setResid(rs.getInt("resid"));
				reservation.setSeat(rs.getString("seat"));
				reservation.setMovieName(rs.getString("movieName"));
				reservation.setMovieId(rs.getInt("movieId"));
			}
			rs.close();
			pstmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return reservation;
	}
	
	public int insertNewReservation(Reservation r,String[] seat) {
		int resid = (int)(Math.random()*100000)+1;
		try {
			String sql = "INSERT INTO reservation(resid,seat,movieName,movieId) VALUES(?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			for(int i=0; i<seat.length; i++) {
			pstmt.setInt(1, resid);
			pstmt.setString(2, seat[i]);
			pstmt.setString(3, r.getMovieName());
			pstmt.setInt(4, r.getMovieId());
			pstmt.executeUpdate();
			}
			pstmt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return resid;
	}
	
	public boolean deleteReservationByResid(int resid) {
		try {
			String sql = "DELETE FROM reservation WHERE resid=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, resid);
					pstmt.executeUpdate();
					pstmt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return true;
	}
}