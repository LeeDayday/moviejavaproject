package ListDAO;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ListVO.MemberListVO;
/**
 * MemberList�� ���õ� DB���� ����
 */
public class MemberListDAO {
	Connection con;
	Statement pst;
	ResultSet rs;
	
	public MemberListDAO() {
		con = Connectionz.getConnection();
	}
	
	public ArrayList<MemberListVO> getMemberList() {
		ArrayList<MemberListVO> list = new ArrayList<MemberListVO>();
		// ����
		try {
			pst = con.createStatement();
			rs = pst.executeQuery("select * from Member");

			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String phone = rs.getString(3);
				String mail = rs.getString(4);

				// ���� �𵨿� �����Ѵ�.
				MemberListVO vo = new MemberListVO();
				vo.setId(id);
				vo.setName(name);
				vo.setPhone(phone);
				vo.setMail(mail);

				// ArrayList�� ���߰��Ѵ�.
				list.add(vo);

			}// while��

		} catch (SQLException e) {
			return null;
		}
		return list;

	}
}
