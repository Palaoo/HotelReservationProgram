
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
 * Servlet implementation class loadAvailRoomServlet
 */
@WebServlet("/loadAvailRoom")
public class loadAvailRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public loadAvailRoomServlet() {
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
		reservationDTO rDTO = new reservationDTO(stayLength, exp_Men, roomType);
		ArrayList<reservationDTO> list = new reservationDAO().searchAvailRoom(rDTO);
		JSONArray ja = new JSONArray();

		for (int i = 0; i < list.size(); i++) {
			reservationDTO data = new reservationDTO();
			data = list.get(i);
			JSONObject jo = new JSONObject();
			jo.put("roomName", data.getRoomName());
			jo.put("roomType", data.getRoomType());
			jo.put("availPerson", data.getExp_Men());
			jo.put("fee", data.getFee());
			jo.put("roomNum", data.getRoomNum());
			ja.add(jo);
		}
		System.out.println(ja.toJSONString());
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
