package board.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class Board {
	private int boardNum;
	private int memberNum;
	private String name;

	@Size(min=3, message = "3자 이상 입력하세요")
	private String subject;
	
	@Size(min=3, message = "3자 이상 입력하세요")
	private String content;
	
	private String regDate;
	private String modDate;
	private int readCount;
	private int ref;
	private int reStep;
	private int reLevel;

	private String ip;
	
	private String targetBoardNum;

	public Board() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Board(int boardNum, int memberNum, String name, String subject, String content, String regDate,
			String modDate, int readCount, int ref, int reStep, int reLevel, String ip, String targetBoardNum) {
		super();
		this.boardNum = boardNum;
		this.memberNum = memberNum;
		this.name = name;
		this.subject = subject;
		this.content = content;
		this.regDate = regDate;
		this.modDate = modDate;
		this.readCount = readCount;
		this.ref = ref;
		this.reStep = reStep;
		this.reLevel = reLevel;
		this.ip = ip;
		this.targetBoardNum = targetBoardNum;
	}

	@Override
	public String toString() {
		return "Board [boardNum=" + boardNum + ", memberNum=" + memberNum + ", name=" + name + ", subject=" + subject
				+ ", content=" + content + ", regDate=" + regDate + ", modDate=" + modDate + ", readCount=" + readCount
				+ ", ref=" + ref + ", reStep=" + reStep + ", reLevel=" + reLevel + ", ip=" + ip + ", targetBoardNum="
				+ targetBoardNum + "]";
	}

	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
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

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getModDate() {
		return modDate;
	}

	public void setModDate(String modDate) {
		this.modDate = modDate;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	public int getRef() {
		return ref;
	}

	public void setRef(int ref) {
		this.ref = ref;
	}

	public int getReStep() {
		return reStep;
	}

	public void setReStep(int reStep) {
		this.reStep = reStep;
	}

	public int getReLevel() {
		return reLevel;
	}

	public void setReLevel(int reLevel) {
		this.reLevel = reLevel;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getTargetBoardNum() {
		return targetBoardNum;
	}

	public void setTargetBoardNum(String targetBoardNum) {
		this.targetBoardNum = targetBoardNum;
	}

	
	
	

}
