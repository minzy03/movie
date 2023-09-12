package test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieDAO {
	List<Movie> movieList = new ArrayList();
	public Connection conn;
	
	public MovieDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); //jdbc driver 등록
			conn = DriverManager.getConnection( //연결하기
					"jdbc:mysql://localhost:3306/servletex",
					"root",
					"1234"
					);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List selectMovieList() {
		movieList.clear();
		try {
			String sql = "SELECT id,title,genre FROM movie ORDER BY id DESC";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Movie movie = new Movie();
				movie.setId(rs.getInt("id"));
				movie.setTitle(rs.getString("title"));
				movie.setGenre(rs.getString("genre"));
				movieList.add(movie);
			}
			rs.close();
			pstmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return movieList;
	}
	
	public Movie selectMovieById(int _movie) {
		Movie movie = new Movie();
		try {
			String sql = "SELECT id,title,genre FROM movie WHERE id=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, _movie);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				movie.setId(rs.getInt("id"));
				movie.setTitle(rs.getString("title"));
				movie.setGenre(rs.getString("genre"));
			}
			rs.close();
			pstmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return movie;
	}
	
	public int insertMovie(Movie movie) {
		System.out.print(movie.getTitle());
		int id = (int)(Math.random()*100000)+1;
		try {
			String sql = "INSERT INTO movie(id,title,genre) VALUES(?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.setString(2, movie.getTitle());
			pstmt.setString(3, movie.getGenre());
			pstmt.executeUpdate();
			pstmt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return id;
	}
	
	public boolean deleteMovieById(int id) {
		try {
			String sql = "DELETE FROM movie WHERE id=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			pstmt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return true;
	}

}