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
			// ����
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
		
					// ���� �𵨿� �����Ѵ�.
					TicketListVO vo = new TicketListVO();
					vo.setId(id);
					vo.setScheduleId(scid);
					vo.setTheaterId(tid);
					vo.setSeatId(seid);
					vo.setResId(rid);
					vo.setPrint(print);
					vo.setPrice(price);
					vo.setSaleprice(saleprice);
					// ArrayList�� ���߰��Ѵ�.
					list.add(vo);

				}// while��

			} catch (SQLException e) {
				return null;
			}
			return list;

		}
	}
