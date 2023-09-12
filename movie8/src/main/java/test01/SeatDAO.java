package test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SeatDAO {
	List<Seat> seatlist = new ArrayList();
	private Connection conn;
	
	public SeatDAO() {
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
	
	public List<Seat> findById(String moviename){
		seatlist.clear();
		Seat seat = new Seat();
		try {
			String sql = "SELECT resid,seat,moviename,movieid FROM seat WHERE moviename=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, moviename);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				seat.setResid(rs.getInt("resid"));
				seat.setSeat(rs.getString("seat"));
				seat.setMoviename(rs.getString("moviename"));
				seat.setMovieid(rs.getInt("movieid"));
				seatlist.add(seat);
			}
			rs.close();
			pstmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return seatlist;
	}
	
	public Seat findByResId(int parseInt) {
		Seat seat = new Seat();
		try {
			String sql = "SELECT resid,seat,moviename,movieid FROM seat WHERE resid=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, parseInt);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				seat.setResid(rs.getInt("resid"));
				seat.setSeat(rs.getString("seat"));
				seat.setMoviename(rs.getString("moviename"));
				seat.setMovieid(rs.getInt("movieid"));
			}
			rs.close();
			pstmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return seat;
	}
	
	public void save(Seat r) { 
		try { 
			String sql = "INSERT INTO seat(resid,seat,moviename,movieid) VALUES(?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql); 
			pstmt.setInt(1, r.getResid()); 
			pstmt.setString(2, r.getSeat()); 
			pstmt.setString(3, r.getMoviename()); 
			pstmt.setInt(4, r.getMovieid()); 
			pstmt.executeUpdate();
			pstmt.close(); 
	    }catch(Exception e) { 
		    e.printStackTrace(); 
	    } 
	    return; 
	}
	 
	
	public boolean cancel(int cancel) {
		try {
			String sql = "DELETE FROM seat WHERE resid=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, cancel);
					pstmt.executeUpdate();
					pstmt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return true;
	}
}