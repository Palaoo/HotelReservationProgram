
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Servlet implementation class loadBookRoomServlet
 */
@WebServlet("/loadBookRoom")
public class loadBookRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public loadBookRoomServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		String stayLength = request.getParameter("stayLength");
		int exp_Men = Integer.parseInt(request.getParameter("exp_Men"));
		String roomType = request.getParameter("roomType");
		ArrayList<reservationDTO> list = new reservationDAO()
				.loadReservationList(new reservationDTO(stayLength, exp_Men, roomType));
		System.out.println("loadBookRoomServlet : " + stayLength + ' ' + exp_Men + ' ' + roomType);
		JSONArray ja = new JSONArray();

		for (int i = 0; i < list.size(); i++) {
			reservationDTO data = list.get(i);
			JSONObject jo = new JSONObject();
			jo.put("reservationID", data.getReservationId());
			jo.put("roomName", data.getRoomName());
			jo.put("roomType", data.getRoomType());
			jo.put("exp_Men", data.getExp_Men());
			jo.put("stayLength", data.getStayLength());
			jo.put("totalFee", data.getTotalFee());
			jo.put("booker", data.getBooker());
			jo.put("mobile", data.getMobile());
			ja.add(jo);
		}
		System.out.println("loadBookRoomServlet" + ja.toJSONString());
		response.getWriter().print(ja.toJSONString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
