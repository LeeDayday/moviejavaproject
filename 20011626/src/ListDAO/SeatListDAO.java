package ListDAO;
import java.sql.*;
import java.util.ArrayList;

import ListVO.SeatListVO;
public class SeatListDAO {
	Connection con;
	Statement pst;
	ResultSet rs;
	
	public SeatListDAO() {
		con = Connectionz.getConnection();
	}
	
	public ArrayList<SeatListVO> getSeatList() {
		ArrayList<SeatListVO> list = new ArrayList<SeatListVO>();
		// 실행
		try {
			pst = con.createStatement();
			rs = pst.executeQuery("select * from Seat");

			while (rs.next()) {
				int id = rs.getInt(1);
				int tid = rs.getInt(2);
				boolean use = rs.getBoolean(3);
	
				// 값을 모델에 저장한다.
				SeatListVO vo = new SeatListVO();
				vo.setId(id);
				vo.setTheaterId(tid);
				vo.setSeat(use);
				
				// ArrayList에 모델추가한다.
				list.add(vo);

			}// while끝

		} catch (SQLException e) {
			return null;
		}
		return list;

	}
}
