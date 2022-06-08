
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class appendReservationSevlet
 */
@WebServlet("/appendReservation")
public class appendReservationSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public appendReservationSevlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("appendReservationServlet");
		request.setCharacterEncoding("utf-8");
		String roomName = request.getParameter("roomName");
		String roomType = request.getParameter("roomType");
		int roomNum = Integer.parseInt(request.getParameter("roomNum"));
		int exp_Men = Integer.parseInt(request.getParameter("exp_Men"));
		String stayLength = request.getParameter("stayLength");
		int totalFee = Integer.parseInt(request.getParameter("totalFee"));
		String booker = request.getParameter("booker");
		String mobile = request.getParameter("mobile");
		new reservationDAO().appendReservation(new reservationDTO(roomName, roomType, roomNum, exp_Men, stayLength, totalFee, booker, mobile));
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
