package review.model;

public class Product {
	private int productNum;
	private String productTitle;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int productNum, String productTitle) {
		super();
		this.productNum = productNum;
		this.productTitle = productTitle;
	}
	public int getProductNum() {
		return productNum;
	}
	public void setProductNum(int productNum) {
		this.productNum = productNum;
	}
	public String getProductTitle() {
		return productTitle;
	}
	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}
	@Override
	public String toString() {
		return "Product [productNum=" + productNum + ", productTitle=" + productTitle + "]";
	}
	
	

}
