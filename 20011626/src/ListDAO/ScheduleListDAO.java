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
		// ����
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

				// ���� �𵨿� �����Ѵ�.
				ScheduleListVO vo = new ScheduleListVO();
				vo.setId(id);
				vo.setMovieId(mid);
				vo.setTheaterId(tid);
				vo.setDate(date);
				vo.setDay(day);
				vo.setNth(nth);
				vo.setTime(time);
				
				// ArrayList�� ���߰��Ѵ�.
				list.add(vo);

			}// while��

		} catch (SQLException e) {
			return null;
		}
		return list;

	}
}
