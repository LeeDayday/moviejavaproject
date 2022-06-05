package ListVO;

public class TheaterListVO {
	private int theater_id;
	private int theater_seats;
	private boolean theater_use;
	public int getId() {
		return theater_id;
	}
	public int getSeats() {
		return theater_seats;
	}
	public boolean getUse() {
		return theater_use;
	}
	
	public void setId(int id) {
		this.theater_id = id;
	}
	public void setSeats(int seats) {
		this.theater_seats=  seats;
	}
	public void setUse(boolean use) {
		this.theater_use = use;
	}
}