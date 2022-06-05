package ListVO;

public class ReservationListVO {
	private int Res_id;
	private String Res_payment;
	private int Res_cost;
	private boolean Res_paid;
	private int Member_id;
	private String Res_date;
	
	public int getId() {
		return Res_id;
	}
	public String getPayment() {
		return Res_payment;
	}	
	public int getCost() {
		return Res_cost;
	}	
	public boolean getPaid() {
		return Res_paid;
	}
	public int getMemberId() {
		return Member_id;
	}
	public String getDate() {
		return Res_date;
	}
	
	public void setResId(int rid) {
		this.Res_id = rid;
	}
	public void setPayment(String payment) {
		this.Res_payment = payment;
	}	
	public void setCost(int cost) {
		this.Res_cost= cost ;
	}	
	public void setPaid(boolean paid) {
		this.Res_paid= paid ;
	}
	public void setMemberId(int mid) {
		this.Member_id = mid;
	}
	public void setDate(String date) {
		this.Res_date = date;
	}
	
}
