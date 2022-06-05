package ListVO;

public class ScheduleListVO {
	private int Schedule_id;
	private int Movie_id;
	private int Theater_id;
	private String Schedule_date;
	private String Schedule_day;
	private int Schedule_nth;
	private String Schedule_time;
	
	public int getId() {
		return Schedule_id;
	}
	public int getMovieId() {
		return Movie_id;
	}
	public int getTheaterId() {
		return Theater_id;
	}
	public String getDate() {
		return Schedule_date;
	}	
	public String getDay() {
		return Schedule_day;
	}	
	public int getNth() {
		return Schedule_nth;
	}
	public String getTime() {
		return Schedule_time;
	}
	
	public void setId(int sid) {
		this.Schedule_id= sid ;
	}
	public void setMovieId(int mid) {
		this.Movie_id = mid;
	}
	public void setTheaterId(int tid) {
		this.Theater_id= tid;
	}
	public void setDate(String date) {
		this.Schedule_date= date ;
	}	
	public void setDay(String day) {
		this.Schedule_day= day ;
	}	
	public void setNth(int n) {
		this.Schedule_nth= n ;
	}
	public void setTime(String time) {
		this.Schedule_time= time ;
	}
}