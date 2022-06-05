package ListVO;
public class MemberListVO {
	private int Member_id;
	private String Member_name;
	private String Member_phone;
	private String Member_mail;
	
	public int getId() {
		return Member_id;
	}
	public String getName() {
		return Member_name;
	}	
	public String getPhone() {
		return Member_phone;
	}	
	public String getMail() {
		return Member_mail;
	}	
	public void setId(int Member_id) {
		this.Member_id =  Member_id;
	}
	public void setName(String Member_name) {
		this.Member_name =  Member_name;
	}	
	public void setPhone(String Member_phone) {
		this.Member_phone = Member_phone;
	}	
	public void setMail(String Member_mail) {
		this.Member_mail = Member_mail;
	}	
}
