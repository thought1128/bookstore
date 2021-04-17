package admin.model;

import java.sql.Date;
import java.sql.Timestamp;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class OProduct {
	private int oproductNum;
	private int orderNum;
	
	private String isbn;	
	private String title;	
	private String writer;
	private String publisher;
	private int price;
	private int point;
	private int oqty;
	private String image ;
	private String classify;
	
	
	public OProduct() {
		super();
		// TODO Auto-generated constructor stub
	}


	public OProduct(int oproductNum, int orderNum, String isbn, String title, String writer, String publisher,
			int price, int point, int oqty, String image, String classify) {
		super();
		this.oproductNum = oproductNum;
		this.orderNum = orderNum;
		this.isbn = isbn;
		this.title = title;
		this.writer = writer;
		this.publisher = publisher;
		this.price = price;
		this.point = point;
		this.oqty = oqty;
		this.image = image;
		this.classify = classify;
	}


	public int getOproductNum() {
		return oproductNum;
	}


	public void setOproductNum(int oproductNum) {
		this.oproductNum = oproductNum;
	}


	public int getOrderNum() {
		return orderNum;
	}


	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
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


	public int getPoint() {
		return point;
	}


	public void setPoint(int point) {
		this.point = point;
	}


	public int getOqty() {
		return oqty;
	}


	public void setOqty(int oqty) {
		this.oqty = oqty;
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


	@Override
	public String toString() {
		return "OProduct [oproductNum=" + oproductNum + ", orderNum=" + orderNum + ", isbn=" + isbn + ", title=" + title
				+ ", writer=" + writer + ", publisher=" + publisher + ", price=" + price + ", point=" + point
				+ ", oqty=" + oqty + ", image=" + image + ", classify=" + classify + "]";
	}	
	
	
	
		
}
