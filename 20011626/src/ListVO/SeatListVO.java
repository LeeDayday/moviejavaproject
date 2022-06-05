package ListVO;

public class SeatListVO {
	private int seat_id;
	private int Theater_id;
	private boolean seat_use;
	
	public int getId() {
		return seat_id;
	}
	public int getTheaterId() {
		return Theater_id;
	}
	public boolean getSeat() {
		return seat_use;
	}
	public void setId(int sid) {
		this.seat_id = sid;
	}
	public void setTheaterId(int tid) {
		this.Theater_id = tid;
	}
	public void setSeat(boolean use) {
		this.seat_use= use ;
	}
}
