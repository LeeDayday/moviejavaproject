package ListVO;

public class MovieListVO {
	private int Movie_id;
	private String Movie_title;
	private int Movie_time;
	private String Movie_grade;
	private String Movie_dir;
	private String Movie_actor;
	private String Movie_genre;
	private String Movie_info;
	private String Movie_date;
	
	public int getId() {
		return Movie_id;
	}
	public String getTitle() {
		return Movie_title;
	}
	public int getTime() {
		return Movie_time;
	}
	public String getGrade() {
		return Movie_grade;
	}
	public String getDir() {
		return Movie_dir;
	}
	public String getActor() {
		return Movie_actor;
	}
	public String getGenre() {
		return Movie_genre;
	}
	public String getInfo() {
		return Movie_info;
		
	}
	public String getDate() {
		return Movie_date;
	}
	public void setId(int id) {
		this.Movie_id= id ;
	}
	public void setTitle(String title) {
		this.Movie_title= title ;
	}
	public void setTime(int time) {
		this.Movie_time= time ;
	}
	public void setGrade(String grade) {
		this.Movie_grade= grade ;
	}
	public void setDir(String dir) {
		this.Movie_dir= dir ;
	}
	public void setActor(String actor) {
		this.Movie_actor = actor;
	}
	public void setGenre(String genre) {
		this.Movie_genre= genre ;
	}
	public void setInfo(String info) {
		this.Movie_info = info;
	}
	public void setDate(String date) {
		this.Movie_date = date;
	}
}


