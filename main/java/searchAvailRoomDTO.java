
public class searchAvailRoomDTO {
	private String stayLength;
	private int exp_Men;
	private String roomType;

	public searchAvailRoomDTO(String stayLength, int exp_Men, String roomType) {
		super();
		this.stayLength = stayLength;
		this.exp_Men = exp_Men;
		this.roomType = roomType;
	}

	public String getStayLength() {
		return stayLength;
	}

	public void setStayLength(String stayLength) {
		this.stayLength = stayLength;
	}

	public int getExp_Men() {
		return exp_Men;
	}

	public void setExp_Men(int exp_Men) {
		this.exp_Men = exp_Men;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

}
