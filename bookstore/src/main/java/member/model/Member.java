package member.model;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class Member {

	private int memberNum;
	@NotBlank(message = "아이디를 입력하세요")
	private String id;
	@NotBlank(message = "비밀번호는 필수 입니다")
   // @Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})", message = "비밀 번호는 6~20자리로 숫자와 특수 문자가 포함된 영문 대소문자로 입력해 주세요")
	private String password;
	@NotBlank(message = "비밀번호확인란을 입력하세요")
	private String passwordCheck;
	@NotBlank(message = "이름을 입력하세요")
	private String name;
	@NotBlank(message = "전화번호를 입력하세요")
	@Length(min = 9, max = 11, message = "유효하지않은 전화번호입니다.")
	private String phoneNum;
	
	@Email(message = "유효하지않은 이메일 주소입니다.")
	private String email;
	@NotBlank(message = "이메일 주소를 입력하세요")
	private String address;
	private String status;
	private int point;
	
	public Member() {
		super();
	}

	public Member(int memberNum, String id, String password, String name, String phoneNum, String email, String address,
			String status, int point) {
		super();
		this.memberNum = memberNum;
		this.id = id;
		this.password = password;
		this.name = name;
		this.phoneNum = phoneNum;
		this.email = email;
		this.address = address;
		this.status = status;
		this.point = point;
	}

	public int getMemberNum() {
		return memberNum;
	}

	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	public String getPasswordCheck() {
		return passwordCheck;
	}

	public void setPasswordCheck(String passwordCheck) {
		this.passwordCheck = passwordCheck;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	@Override
	public String toString() {
		return "Member [memberNum=" + memberNum + ", id=" + id + ", password=" + password + ", passwordCheck="
				+ passwordCheck + ", name=" + name + ", phoneNum=" + phoneNum + ", email=" + email + ", address="
				+ address + ", status=" + status + ", point=" + point + "]";
	}

	
	
}
