package ListDAO;
import java.sql.*;
import java.util.ArrayList;

import ListVO.TicketListVO;
public class TicketListDAO {
		Connection con;
		Statement pst;
		ResultSet rs;
		
		public TicketListDAO() {
			con = Connectionz.getConnection();
		}	
		public ArrayList<TicketListVO> getTicketList() {
			ArrayList<TicketListVO> list = new ArrayList<TicketListVO>();
			// 실행
			try {
				pst = con.createStatement();
				rs = pst.executeQuery("select * from Ticket");

				while (rs.next()) {
					int id = rs.getInt(1);
					int scid = rs.getInt(2);
					int tid = rs.getInt(3);
					int seid = rs.getInt(4);
					int rid = rs.getInt(5);
					boolean print = rs.getBoolean(6);
					int price = rs.getInt(7);
					int saleprice = rs.getInt(8);
		
					// 값을 모델에 저장한다.
					TicketListVO vo = new TicketListVO();
					vo.setId(id);
					vo.setScheduleId(scid);
					vo.setTheaterId(tid);
					vo.setSeatId(seid);
					vo.setResId(rid);
					vo.setPrint(print);
					vo.setPrice(price);
					vo.setSaleprice(saleprice);
					// ArrayList에 모델추가한다.
					list.add(vo);

				}// while끝

			} catch (SQLException e) {
				return null;
			}
			return list;

		}
	}
