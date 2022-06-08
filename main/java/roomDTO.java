
public class roomDTO {
	private int roomNum;
	private String roomName;
	private int roomTypeNum;
	private int availPerson;
	private int fee;
	private String roomType;

	public int getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public int getRoomTypeNum() {
		return roomTypeNum;
	}

	public void setRoomTypeNum(int roomTypeNum) {
		this.roomTypeNum = roomTypeNum;
	}

	public int getAvailPerson() {
		return availPerson;
	}

	public void setAvailPerson(int availPerson) {
		this.availPerson = availPerson;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	public roomDTO(int roomNum, String roomName, int roomTypeNum, int availPerson, int fee, String roomType) {
		this.roomNum = roomNum;
		this.roomName = roomName;
		this.roomTypeNum = roomTypeNum;
		this.availPerson = availPerson;
		this.fee = fee;
		this.roomType = roomType;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public roomDTO(int roomNum, String roomName, String roomType, int availPerson, int fee) {
		super();
		this.roomNum = roomNum;
		this.roomName = roomName;
		this.roomType = roomType;
		this.availPerson = availPerson;
		this.fee = fee;
	}

	public roomDTO() {
	}

	public roomDTO(String roomName, String roomType, int availPerson, int fee) {
		this.roomName = roomName;
		this.roomType = roomType;
		this.availPerson = availPerson;
		this.fee = fee;
	}

}
