package ListVO;

public class TicketListVO {
	private int ticket_id;
	private int schedule_id;
	private int theater_id;
	private int seat_id;
	private int res_id;
	private boolean ticket_print;
	private int ticket_price;
	private int ticket_saleprice;
	public int getId() {
		return ticket_id;
	}
	public int getScheduleId() {
		return schedule_id;
	}
	public int getTheaterId() {
		return theater_id;
	}
	public int getSeatId() {
		return seat_id;
	}
	public int getResId() {
		return res_id;
	}
	public boolean getPrint() {
		return ticket_print;
	}
	public int getPrice() {
		return ticket_price;
	}
	public int getSaleprice() {
		return ticket_saleprice;
	}

	public void setId(int id) {
		this.ticket_id = id;
	}
	public void setScheduleId(int id) {
		this.schedule_id= id ;
	}
	public void setTheaterId(int id) {
		this.theater_id= id ;
	}
	public void setSeatId(int id) {
		this.seat_id= id ;
	}
	public void setResId(int id) {
		this.res_id = id;
	}
	public void setPrint(boolean print) {
		this.ticket_print= print ;
	}
	public void setPrice(int price) {
		this.ticket_price= price ;
	}
	public void setSaleprice(int saleprice) {
		this.ticket_saleprice= saleprice ;
	}
}
