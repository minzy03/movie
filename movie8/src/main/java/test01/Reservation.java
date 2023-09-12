package test01;

public class Reservation {
	private int num;
	private int resid; //예매발급번호
	private String seat; //고객좌석명
	private String movieName; //영화명
	private int movieId; //영화아이디
	private String userId;
	
	public Reservation() {
	}
	public Reservation(String seat, String movieName, int movieId) {
		super();
		this.seat = seat;
		this.movieName = movieName;
		this.movieId = movieId;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getResid() {
		return resid;
	}
	public void setResid(int resid) {
		this.resid = resid;
	}
	public String getSeat() {
		return seat;
	}
	public void setSeat(String seat) {
		this.seat = seat;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	@Override
	public String toString() {
		return "Reservation [num=" + num + ", resid=" + resid + ", seat=" + seat + ", movieName=" + movieName
				+ ", movieId=" + movieId + ", userId=" + userId + "]";
	}
	
}