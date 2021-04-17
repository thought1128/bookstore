package orders.model;

public class Orders {

	private int orderNum;
	private int memberNum;
	private String name;
	private String address;
	private int phoneNum;
	private String trackNum;
	private String status;
	private int totalPrice;
	private int totalPoint;
	private String orderDate;
	private String reason;

	public Orders() {
		super();
	}

	public Orders(int orderNum, int memberNum, String name, String address, int phoneNum, String trackNum,
			String status, int totalPrice, int totalPoint, String orderDate) {
		super();
		this.orderNum = orderNum;
		this.memberNum = memberNum;
		this.name = name;
		this.address = address;
		this.phoneNum = phoneNum;
		this.trackNum = trackNum;
		this.status = status;
		this.totalPrice = totalPrice;
		this.totalPoint = totalPoint;
		this.orderDate = orderDate;
	}
	
	public Orders(int orderNum, int memberNum, String name, String address, int phoneNum, String trackNum,
			String status, int totalPrice, int totalPoint) {
		super();
		this.orderNum = orderNum;
		this.memberNum = memberNum;
		this.name = name;
		this.address = address;
		this.phoneNum = phoneNum;
		this.trackNum = trackNum;
		this.status = status;
		this.totalPrice = totalPrice;
		this.totalPoint = totalPoint;
	}

	public Orders(int orderNum, int memberNum, String name, String address, int phoneNum, String trackNum,
			String status, String orderDate, int totalPrice, int totalPoint, String reason) {
		super();
		this.orderNum = orderNum;
		this.memberNum = memberNum;
		this.name = name;
		this.address = address;
		this.phoneNum = phoneNum;
		this.trackNum = trackNum;
		this.status = status;
		this.orderDate = orderDate;
		this.totalPrice = totalPrice;
		this.totalPoint = totalPoint;
		this.reason = reason;
	}
	
	
	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public int getMemberNum() {
		return memberNum;
	}

	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(int phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getTrackNum() {
		return trackNum;
	}

	public void setTrackNum(String trackNum) {
		this.trackNum = trackNum;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getTotalPoint() {
		return totalPoint;
	}

	public void setTotalPoint(int totalPoint) {
		this.totalPoint = totalPoint;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}


	
	
	
	
}
