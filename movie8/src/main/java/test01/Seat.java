package test01;

public class Seat {
	private int num;
	private int resid;
	private String seat;
	private String moviename;
	private int movieid;
	
	public Seat(int resid, String seat, String moviename, int movieid) {
		this.resid = resid;
		this.seat = seat;
		this.moviename = moviename;
		this.movieid = movieid;
	}
	
	public Seat() {
		
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

	public String getMoviename() {
		return moviename;
	}

	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}

	public int getMovieid() {
		return movieid;
	}

	public void setMovieid(int movieid) {
		this.movieid = movieid;
	}
	
}
