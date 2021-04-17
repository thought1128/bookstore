package product.model;

import java.sql.Timestamp;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class ProductBean {
	
	private String title;
	private String isbn;
	private String writer;
	private String publisher;
	private int price;
	private Timestamp publishedDate;
	private int point;
	private int qty;
	private String status ;
	private String image ;
	private String classify ;
	private String promotions;
	private MultipartFile upload;
	private String uploaded;
	
	
	
	public ProductBean() {
		super();
	}
	
	public ProductBean(String title, String isbn, String writer, String publisher, int price, Timestamp publishedDate,
			int point, int qty, String status, String image, String classify, String promotions) {
		super();
		this.title = title;
		this.isbn = isbn;
		this.writer = writer;
		this.publisher = publisher;
		this.price = price;
		this.publishedDate = publishedDate;
		this.point = point;
		this.qty = qty;
		this.status = status;
		this.image = image;
		this.classify = classify;
		this.promotions = promotions;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Timestamp getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(Timestamp publishedDate) {
		this.publishedDate = publishedDate;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getClassify() {
		return classify;
	}
	public void setClassify(String classify) {
		this.classify = classify;
	}
	public String getPromotions() {
		return promotions;
	}
	public void setPromotions(String promotions) {
		this.promotions = promotions;
	}

	public MultipartFile getUpload() {
		return upload;
	}
	
	public void setUpload(MultipartFile upload) {
		this.upload = upload;
		System.out.println("upload : "+upload);// ~~.jpg (X)
		if(upload != null) {
			System.out.println(upload.getName()); // upload
			System.out.println(upload.getOriginalFilename()); // ~~.jpg  , 진짜 화일이름
			this.image = upload.getOriginalFilename();  
		}else {
		    	
				this.image=uploaded;
		}
	}
	
	
}
