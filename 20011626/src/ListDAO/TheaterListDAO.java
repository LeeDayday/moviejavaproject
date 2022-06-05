package ListDAO;
import java.sql.*;
import java.util.ArrayList;

import ListVO.TheaterListVO;
public class TheaterListDAO {
	Connection con;
	Statement pst;
	ResultSet rs;
	
	public TheaterListDAO() {
		con = Connectionz.getConnection();
	}
	
	public ArrayList<TheaterListVO> getTheaterList() {
		ArrayList<TheaterListVO> list = new ArrayList<TheaterListVO>();
		// 실행
		try {
			pst = con.createStatement();
			rs = pst.executeQuery("select * from Theater");

			while (rs.next()) {
				int id = rs.getInt(1);
				int seats = rs.getInt(2);
				boolean use = rs.getBoolean(3);
	
				// 값을 모델에 저장한다.
				TheaterListVO vo = new TheaterListVO();
				vo.setId(id);
				vo.setSeats(seats);
				vo.setUse(use);
				// ArrayList에 모델추가한다.
				list.add(vo);

			}// while끝

		} catch (SQLException e) {
			return null;
		}
		return list;

	}
}
