
public class reservationDTO {
	private int reservationId;
	private String roomName;
	private String roomType;
	private int exp_Men;
	private String stayLength;
	private int totalFee;
	private String booker;
	private String mobile;
	private int roomNum;
	private int fee;

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	public int getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}

	public int getReservationId() {
		return reservationId;
	}

	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public int getExp_Men() {
		return exp_Men;
	}

	public void setExp_Men(int exp_Men) {
		this.exp_Men = exp_Men;
	}

	public String getStayLength() {
		return stayLength;
	}

	public void setStayLength(String stayLength) {
		this.stayLength = stayLength;
	}

	public int getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(int totalFee) {
		this.totalFee = totalFee;
	}

	public String getBooker() {
		return booker;
	}

	public void setBooker(String booker) {
		this.booker = booker;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public reservationDTO() {
	}

	public reservationDTO(int reservationId, String roomName, String roomType, int exp_Men, String stayLength,
			int totalFee, String booker, String mobile) {
		this.reservationId = reservationId;
		this.roomName = roomName;
		this.roomType = roomType;
		this.exp_Men = exp_Men;
		this.stayLength = stayLength;
		this.totalFee = totalFee;
		this.booker = booker;
		this.mobile = mobile;
	}

	public reservationDTO(int reservationId, int exp_Men, String stayLength, String booker, String mobile) {
		this.reservationId = reservationId;
		this.exp_Men = exp_Men;
		this.stayLength = stayLength;
		this.booker = booker;
		this.mobile = mobile;
	}

	public reservationDTO(String roomName, String roomType, int roomNum, int exp_Men, String stayLength, int totalFee,
			String booker, String mobile) {
		this.roomName = roomName;
		this.roomType = roomType;
		this.roomNum = roomNum;
		this.exp_Men = exp_Men;
		this.stayLength = stayLength;
		this.totalFee = totalFee;
		this.booker = booker;
		this.mobile = mobile;
	}

	public reservationDTO(String stayLength, int exp_Men, String roomType) {
		this.stayLength = stayLength;
		this.exp_Men = exp_Men;
		this.roomType = roomType;
	}

	public reservationDTO(String roomName, String roomType, int exp_Men, int fee, int roomNum) {
		this.roomName = roomName;
		this.roomType = roomType;
		this.exp_Men = exp_Men;
		this.fee = fee;
		this.roomNum = roomNum;
	}
}
