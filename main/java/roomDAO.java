import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class roomDAO {
	private Statement stmt;
	private Connection conn;


	private void connDB() { // DB와 연결
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String userid = "ora_user";
		String passcode = "human123";

		try {
			Class.forName(driver);
			this.conn = DriverManager.getConnection(url, userid, passcode);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<roomDTO> getRoomList() {
		ArrayList<roomDTO> list = new ArrayList<roomDTO>();
		try {
			connDB();
			String query = "select a.roomnum, a.roomname, a.roomtypenum, a.availperson, a.fee, b.roomtype from RoomList a, RoomTypeList b where a.roomtypenum=b.roomtypenum order by substr(roomname,1,3)";
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query); // ResultSet class는 가져온 테이블(2차원 배열)을 저장하고있다.

			while (rs.next()) {
				roomDTO rDTO = new roomDTO(rs.getInt("roomnum"), rs.getString("roomname"), rs.getInt("roomtypenum"),
						rs.getInt("availperson"), rs.getInt("fee"), rs.getString("roomtype"));
				list.add(rDTO);
			}

			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public void appendRoom(roomDTO rDTO) {
		try {
			connDB();
			String query = "insert into RoomList values(sq_room.nextval,?,(select roomtypenum from roomtypelist where roomtype=?),?,?)";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, rDTO.getRoomName());
			pstmt.setString(2, rDTO.getRoomType());
			pstmt.setInt(3, rDTO.getAvailPerson());
			System.out.println(query);
			pstmt.setInt(4, rDTO.getFee());
			pstmt.executeUpdate();

			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteRoom(String roomNum) {
		try {
			connDB();
			String query = "delete from roomList where roomNum=" + roomNum;
			stmt = conn.createStatement();
			stmt.execute(query);

			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateRoom(roomDTO rDTO) {
		try {
			connDB();
			String query = "update roomList set roomName=?, roomTypeNum=(select roomtypenum from roomtypelist where roomtype=?), availPerson=?, fee=? where roomNum=?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, rDTO.getRoomName());
			pstmt.setString(2, rDTO.getRoomType());
			pstmt.setInt(3, rDTO.getAvailPerson());
			pstmt.setInt(4, rDTO.getFee());
			pstmt.setInt(5, rDTO.getRoomNum());
			pstmt.executeUpdate();

			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
