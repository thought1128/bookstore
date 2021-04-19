package admin.model;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class Product {
	@Size(message = "제목을 입력하세요", min=1)
	private String title;
	
	@Size(message = "isbn을 입력하세요", min=1)
	private String isbn;
	
	@Size(message = "저자를 입력하세요", min=1)
	private String writer;
	
	@Size(message = "출판사를 입력하세요", min=1)
	private String publisher;
	
	@Min(value = 100,message = "가격은 100원 이상을 입력하세요." )
	private int price;
	
	//@NotNull(message = "출간일을 입력하세요")
	private String publishedDate;
	
	@Min(value = 1,message = "포인트는 1포인트 이상을 입력하세요." )
	private int point;
	
	@Min(value = 0,message = "재고수량은 음수값을 쓸 수 없습니다." )
	private int qty;
	
	@Size(message = "재고유무를 입력하세요", min=1)
	private String status ;
	
	private String image ;
	
	@Size(message = "분류를 입력하세요", min=1)
	private String classify ;
	
	@Size(message = "페이지 노출여부를 입력하세요", min=1)
	private String promotions;

	private MultipartFile upload;
	
	private String upload2;
	
	public Product() {
		super();
	}
	
	public Product(String title, String isbn, String writer, String publisher, int price, String publishedDate,
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

	
	public String getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(String publishedDate) {
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
		System.out.println("upload:" + upload);
		System.out.println("upload.getName():"+upload.getName());
		System.out.println("upload.getOriginalFilename():"+upload.getOriginalFilename());
		this.image = upload.getOriginalFilename();
	}

	public String getUpload2() {
		return upload2;
	}
	public void setUpload2(String upload2) {
		this.upload2 = upload2;
	}

	@Override
	public String toString() {
		return "Product [title=" + title + ", isbn=" + isbn + ", writer=" + writer + ", publisher=" + publisher
				+ ", price=" + price + ", publishedDate=" + publishedDate + ", point=" + point + ", qty=" + qty
				+ ", status=" + status + ", image=" + image + ", classify=" + classify + ", promotions=" + promotions
				+ ", upload=" + upload + ", uploaded="  + ", upload2=" + upload2 + "]";
	}
	
	
	
	
}
