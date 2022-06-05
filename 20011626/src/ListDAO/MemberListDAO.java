package ListDAO;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ListVO.MemberListVO;
/**
 * MemberList에 관련된 DB연동 역할
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
		// 실행
		try {
			pst = con.createStatement();
			rs = pst.executeQuery("select * from Member");

			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String phone = rs.getString(3);
				String mail = rs.getString(4);

				// 값을 모델에 저장한다.
				MemberListVO vo = new MemberListVO();
				vo.setId(id);
				vo.setName(name);
				vo.setPhone(phone);
				vo.setMail(mail);

				// ArrayList에 모델추가한다.
				list.add(vo);

			}// while끝

		} catch (SQLException e) {
			return null;
		}
		return list;

	}
}
