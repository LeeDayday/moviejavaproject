package ListDAO;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ListVO.ReservationListVO;
public class ReservationListDAO {
	Connection con;
	Statement pst;
	ResultSet rs;
	
	public ReservationListDAO() {
		con = Connectionz.getConnection();
	}
	
	public ArrayList<ReservationListVO> getReservationList() {
		ArrayList<ReservationListVO> list = new ArrayList<ReservationListVO>();
		// 실행
		try {
			pst = con.createStatement();
			rs = pst.executeQuery("select * from Reservation");

			while (rs.next()) {
				int rid = rs.getInt(1);
				String payment = rs.getString(2);
				int cost = rs.getInt(3);
				boolean paid = rs.getBoolean(4);
				int mid = rs.getInt(5);
				String date = rs.getString(6);
				
				// 값을 모델에 저장한다.
				ReservationListVO vo = new ReservationListVO();
				vo.setResId(rid);
				vo.setPayment(payment);
				vo.setCost(cost);
				vo.setPaid(paid);
				vo.setMemberId(mid);
				vo.setDate(date);

				// ArrayList에 모델추가한다.
				list.add(vo);

			}// while끝

		} catch (SQLException e) {
			return null;
		}
		return list;

	}
}