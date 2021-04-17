package review.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author BAE
 *
 */
public class Review {
	private int reviewNum;
	private int memberNum;
	private String name;
	private String isbn;
	private String title;

	@Size(min=3, message = "3자 이상 입력하세요")
	private String subject;
	
	@Size(min=3, message = "3자 이상 입력하세요")
	private String content;
	private String image;
	
	private String regDate;
	private String modDate;
	private int readCount;
	private int ref;
	private int reStep;
	private int reLevel;
	private String ip;
	
	private String targetReviewNum;
	
	private MultipartFile upload;
	private String upload2; // 수정form
	
	public void setUpload(MultipartFile upload) {
		this.upload = upload;
		System.out.println("upload:" + upload);
		System.out.println("upload.getName():"+upload.getName());
		System.out.println("upload.getOriginalFilename():"+upload.getOriginalFilename());
		this.image = upload.getOriginalFilename();
	}

	
	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Review(int reviewNum, int memberNum, String name, String isbn, String title, String subject,
			String content, String image, String regDate, String modDate, int readCount, int ref, int reStep,
			int reLevel, String ip, String targetReviewNum) {
		super();
		this.reviewNum = reviewNum;
		this.memberNum = memberNum;
		this.name = name;
		this.isbn = isbn;
		this.title = title;
		this.subject = subject;
		this.content = content;
		this.image = image;
		this.regDate = regDate;
		this.modDate = modDate;
		this.readCount = readCount;
		this.ref = ref;
		this.reStep = reStep;
		this.reLevel = reLevel;
		this.ip = ip;
		this.targetReviewNum = targetReviewNum;
	}



	public int getReviewNum() {
		return reviewNum;
	}


	public void setReviewNum(int reviewNum) {
		this.reviewNum = reviewNum;
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


	public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
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


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
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


	public String getTargetReviewNum() {
		return targetReviewNum;
	}


	public void setTargetReviewNum(String targetReviewNum) {
		this.targetReviewNum = targetReviewNum;
	}


	public String getUpload2() {
		return upload2;
	}


	public void setUpload2(String upload2) {
		this.upload2 = upload2;
	}


	public MultipartFile getUpload() {
		return upload;
	}


	@Override
	public String toString() {
		return "Review [reviewNum=" + reviewNum + ", memberNum=" + memberNum + ", name=" + name + ", isbn="
				+ isbn + ", title=" + title + ", subject=" + subject + ", content=" + content
				+ ", image=" + image + ", regDate=" + regDate + ", modDate=" + modDate + ", readCount=" + readCount
				+ ", ref=" + ref + ", reStep=" + reStep + ", reLevel=" + reLevel + ", ip=" + ip + ", targetReviewNum="
				+ targetReviewNum + "]";
	}
	
	

	

}
