
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class appendRoomServlet
 */
@WebServlet("/appendRoom")
public class appendRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public appendRoomServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String roomName = request.getParameter("roomName");
		String roomType = request.getParameter("roomType");
		int availPerson = Integer.parseInt(request.getParameter("availPerson"));
		int fee = Integer.parseInt(request.getParameter("fee"));
		System.out.printf("From appendRoomServlet -> roomName : %s | roomType : %s | availPerson : %d | fee : %d\n",
				roomName, roomType, availPerson, fee);
		new roomDAO().appendRoom(new roomDTO(roomName, roomType, availPerson, fee));
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
