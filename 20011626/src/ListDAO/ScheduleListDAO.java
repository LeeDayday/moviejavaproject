package ListDAO;
import java.sql.*;
import java.util.ArrayList;

import ListVO.ScheduleListVO;
public class ScheduleListDAO {
	Connection con;
	Statement pst;
	ResultSet rs;
	
	public ScheduleListDAO() {
		con = Connectionz.getConnection();
	}
	
	public ArrayList<ScheduleListVO> getScheduleList() {
		ArrayList<ScheduleListVO> list = new ArrayList<ScheduleListVO>();
		// 실행
		try {
			pst = con.createStatement();
			rs = pst.executeQuery("select * from Schedule");

			while (rs.next()) {
				int id = rs.getInt(1);
				int mid = rs.getInt(2);
				int tid = rs.getInt(3);
				String date = rs.getString(4);
				String day = rs.getString(5);
				int nth = rs.getInt(6);
				String time = rs.getString(7);

				// 값을 모델에 저장한다.
				ScheduleListVO vo = new ScheduleListVO();
				vo.setId(id);
				vo.setMovieId(mid);
				vo.setTheaterId(tid);
				vo.setDate(date);
				vo.setDay(day);
				vo.setNth(nth);
				vo.setTime(time);
				
				// ArrayList에 모델추가한다.
				list.add(vo);

			}// while끝

		} catch (SQLException e) {
			return null;
		}
		return list;

	}
}
