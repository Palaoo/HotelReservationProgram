
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
 * Servlet implementation class loadRoomListServlet
 */
@WebServlet("/loadRoomList")
public class loadRoomListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public loadRoomListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		ArrayList<roomDTO> list = new roomDAO().getRoomList();
		JSONArray ja = new JSONArray();

		for (int i = 0; i < list.size(); i++) {
			roomDTO data = new roomDTO();
			data = list.get(i);
			JSONObject jo = new JSONObject();
			jo.put("roomNum", data.getRoomNum());
			jo.put("roomName", data.getRoomName());
			jo.put("roomTypeNum", data.getRoomTypeNum());
			jo.put("availPerson", data.getAvailPerson());
			jo.put("fee", data.getFee());
			jo.put("roomType", data.getRoomType());
			ja.add(jo);
		}
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
