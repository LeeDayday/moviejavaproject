package ListDAO;
import java.sql.*;
import java.util.ArrayList;

import ListVO.MovieListVO;

public class MovieListDAO {
	Connection con;
	Statement pst;
	ResultSet rs;
	
	public MovieListDAO() {
		con = Connectionz.getConnection();
	}
	
	public ArrayList<MovieListVO> getMovieList() {
		ArrayList<MovieListVO> list = new ArrayList<MovieListVO>();
		// ����
		try {
			pst = con.createStatement();
			rs = pst.executeQuery("select * from Movie");

			while (rs.next()) {
				int id = rs.getInt(1);
				String title = rs.getString(2);
				int time = rs.getInt(3);
				String grade = rs.getString(4);
				String dir = rs.getString(5);
				String actor = rs.getString(6);
				String genre = rs.getString(7);
				String info = rs.getString(8);
				String date = rs.getString(9);
				// ���� �𵨿� �����Ѵ�.
				MovieListVO vo = new MovieListVO();
				vo.setId(id);
				vo.setTitle(title);
				vo.setTime(time);
				vo.setGrade(grade);
				vo.setDir(dir);
				vo.setActor(actor);
				vo.setGenre(genre);
				vo.setInfo(info);
				vo.setDate(date);
				// ArrayList�� ���߰��Ѵ�.
				list.add(vo);

			}// while��

		} catch (SQLException e) {
			return null;
		}
		return list;

	}
}
