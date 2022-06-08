import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class reservationDAO {
	private Statement stmt;
	private Connection conn;

	public void updateReservation(reservationDTO rDTO) {
		try {
			connDB();
			String query = "update reservationlist set exp_men=?, stayLength=?, booker=?, mobile=? where reservationID=?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, rDTO.getExp_Men());
			pstmt.setString(2, rDTO.getStayLength());
			pstmt.setString(3, rDTO.getBooker());
			pstmt.setString(4, rDTO.getMobile());
			pstmt.setInt(5, rDTO.getReservationId());

			pstmt.execute();

			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void cancelReservation(int reservationID) {
		try {
			connDB();
			String query = "delete from reservationlist where reservationID = " + reservationID;
			stmt = conn.createStatement();
			stmt.execute(query);

			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void appendReservation(reservationDTO rDTO) {
		try {
			connDB();
			String query = "insert into reservationlist values(sq_reservationid.nextval,?,(select roomtypenum from roomtypelist where roomtype=?),?,?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, rDTO.getRoomName());
			pstmt.setString(2, rDTO.getRoomType());
			pstmt.setInt(3, rDTO.getRoomNum());
			pstmt.setInt(4, rDTO.getExp_Men());
			pstmt.setString(5, rDTO.getStayLength());
			pstmt.setInt(6, rDTO.getTotalFee());
			pstmt.setString(7, rDTO.getBooker());
			pstmt.setString(8, rDTO.getMobile());
			pstmt.execute();
			System.out.println("appendReservation");
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<reservationDTO> searchAvailRoom(reservationDTO rDTO) {
		ArrayList<reservationDTO> list = new ArrayList<reservationDTO>(); // DTO
		try {
			connDB(); // DB 연결
			String query = "select a.roomnum roomNum, a.roomName roomName, a.availPerson availPerson, a.fee fee, b.roomtype roomType from (select * from roomlist e where roomtypenum = (select roomtypenum from roomtypelist where roomtype =?) and e.roomnum not in (select roomnum from reservationlist d where not ((? < substr(d.stayLength,1,8) and ? < substr(d.stayLength,10,17) or (? > substr(d.stayLength,1,8) and ? > substr(d.stayLength,10,17)))))) a, (select roomtype from roomtypelist c where c.roomtype = ?) b where a.availperson >= ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, rDTO.getRoomType());
			String[] stayLength = rDTO.getStayLength().split("~");
			pstmt.setString(2, stayLength[0]);
			pstmt.setString(3, stayLength[1]);
			pstmt.setString(4, stayLength[0]);
			pstmt.setString(5, stayLength[1]);
			pstmt.setString(6, rDTO.getRoomType());
			pstmt.setInt(7, rDTO.getExp_Men());

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String roomName = rs.getString("roomName");
				String roomType = rs.getString("roomType");
				int availPerson = rs.getInt("availPerson");
				int fee = rs.getInt("fee");
				int roomNum = rs.getInt("roomNum");
				reservationDTO rDTO2 = new reservationDTO(roomName, roomType, availPerson, fee, roomNum);

				list.add(rDTO2);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

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

	public ArrayList<reservationDTO> loadReservationList(reservationDTO rDTO) {
		ArrayList<reservationDTO> list = new ArrayList<reservationDTO>();
		try {
			connDB();
			String query = "select a.reservationid reservationid, a.roomname roomname, b.roomtype roomtype,"
					+ " a.exp_men exp_men, a.staylength staylength, a.totalfee totalfee, a.booker booker, a.mobile mobile"
					+ " from reservationlist a, (select * from roomtypelist where ? = roomtype) b"
					+ " where substr(a.staylength, 10,17)>=to_char(sysdate,'yyyymmdd')"
					+ " and a.roomtypenum=b.roomtypenum and not ((? < substr(a.staylength,1,8)"
					+ " and ? < substr(a.staylength,10,17)) or"
					+ " (? >substr(a.staylength,1,8) and ? > substr(a.staylength,10,17)))";
			PreparedStatement pstmt = conn.prepareStatement(query);
			String[] stayLength = rDTO.getStayLength().split("~");
			System.out.println(rDTO.getRoomType() + ' ' + stayLength[0] + ' ' + stayLength[1]);
			pstmt.setString(1, rDTO.getRoomType());
			pstmt.setString(2, stayLength[0]);
			pstmt.setString(3, stayLength[1]);
			pstmt.setString(4, stayLength[0]);
			pstmt.setString(5, stayLength[1]);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				int reservationID = rs.getInt("reservationID");
				String roomName = rs.getString("roomName");
				String roomType = rs.getString("roomType");
				int exp_Men = rs.getInt("exp_Men");
				String stayLength1 = rs.getString("stayLength");
				int totalFee = rs.getInt("totalFee");
				String booker = rs.getString("booker");
				String mobile = rs.getString("mobile");
				reservationDTO rDTO2 = new reservationDTO(reservationID, roomName, roomType, exp_Men, stayLength1,
						totalFee, booker, mobile);
				list.add(rDTO2);
			}

			pstmt.close();
			rs.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
