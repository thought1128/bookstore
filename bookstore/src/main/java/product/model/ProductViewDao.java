package product.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import admin.model.Product;
import utility.Paging;

@Component("ProductViewDao")
public class ProductViewDao {

	final String namespace = "admin.model.Product";

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	public void insertProduct(Product product) {

		int cnt = sqlSessionTemplate.insert(namespace + ".InsertProduct", product);
		System.out.println("Product insert cnt : " + cnt);

	}

	public int getProductCount(Map<String, String> map) {
		int cnt = sqlSessionTemplate.selectOne(namespace + ".GetProductCount", map);
		return cnt;
	}
	public int getSearchProductCount(Map<String, String> map) {
		int cnt = sqlSessionTemplate.selectOne(namespace + ".GetSearchProductCount", map);
		return cnt;
	}
	public List<ProductBean> getPagingProductList(Paging pageInfo, Map<String, String> map) {
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(), pageInfo.getLimit());
		List<ProductBean> lists = sqlSessionTemplate.selectList(namespace + ".GetPagingProductList", map, rowBounds);
		return lists;
	}
	
	public List<ProductBean> getSearchPagingProductList(Paging pageInfo, Map<String, String> map) {
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(), pageInfo.getLimit());
		List<ProductBean> lists = sqlSessionTemplate.selectList(namespace + ".GetSearchPagingProductList", map, rowBounds);
		return lists;
	}
	
	public ProductBean getProductIsbn(String isbn) {
		ProductBean bean = sqlSessionTemplate.selectOne(namespace + ".GetProductIsbn", isbn);
		return bean;
	}
	public List<ProductClassifyBean> getProductGroupByClassify() {
		List<ProductClassifyBean> lists = sqlSessionTemplate.selectList(namespace + ".GetProductGroupByClassify");
		return lists;
	}
	
	public List<ProductClassifyBean> getSearchProductGroupByClassify(Map<String, String> map) {
		List<ProductClassifyBean> lists = sqlSessionTemplate.selectList(namespace + ".GetSearchProductGroupByClassify",map);
		return lists;
	}
	
	public List<ProductBean> getSearchClassifyProduct(Paging pageInfo, Map<String, String> map){
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(), pageInfo.getLimit());
		List<ProductBean> lists = sqlSessionTemplate.selectList(namespace + ".GetSearchProduct", map, rowBounds);
		return lists;
	}
}