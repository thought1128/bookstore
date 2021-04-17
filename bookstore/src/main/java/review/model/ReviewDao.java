package review.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import utility.Paging;


@Component("myReviewDao")
public class ReviewDao {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
//	public List<Review> getList() {
//		List<Review> reviewList = sqlSessionTemplate.selectList("review.model.Review.getList");
//		return reviewList;
//	}
	
	public int getTotalCount(Map<String, String> map) {
		int cnt = sqlSessionTemplate.selectOne("review.model.Review.getTotalCount", map);
		return cnt;
	}

	public List<Review> getDataList(Paging pageInfo, Map<String, String> map) {
		List<Review> lists = new ArrayList<Review>();
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(),pageInfo.getLimit());
		lists = sqlSessionTemplate.selectList("review.model.Review.getDataList",map,rowBounds);
		return lists;
	}
	
	public int getMyTotalCount(Map<String, String> map) {
		int cnt = sqlSessionTemplate.selectOne("review.model.Review.getMyTotalCount", map);
		return cnt;
	}

	public List<Review> getMyDataList(Paging pageInfo, Map<String, String> map) {
		List<Review> lists = new ArrayList<Review>();
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(),pageInfo.getLimit());
		lists = sqlSessionTemplate.selectList("review.model.Review.getMyDataList",map,rowBounds);
		return lists;
	}


	public int insert(Review review) {
		int cnt = sqlSessionTemplate.insert("review.model.Review.insert", review);
		return cnt;
	}

	public Review getOne(int reviewNum) {
		Review review = sqlSessionTemplate.selectOne("review.model.Review.getOne", reviewNum);
		return review;
	}

	public int update(Review review) {
		int cnt = sqlSessionTemplate.update("review.model.Review.update", review);
		return cnt;
	}
	
	public void changeSteps(Review review) {
	sqlSessionTemplate.update("review.model.Review.changeSteps", review);
	
	}
	
	public int insertReply(Review review) {
		int cnt = sqlSessionTemplate.insert("review.model.Review.insertReply", review);
		return cnt;
	}

	public int remove(int reviewNum) {
		int cnt = sqlSessionTemplate.delete("review.model.Review.delete", reviewNum);
		return cnt;
	}

	public void hitReview(int reviewNum) {
		sqlSessionTemplate.update("review.model.Review.hitReview", reviewNum);
		
	}

	public List<Review> getMyList(Paging pageInfo, Map<String, String> map) {
		List<Review> lists = new ArrayList<Review>();
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(),pageInfo.getLimit());
		lists = sqlSessionTemplate.selectList("review.model.Review.getMyList",map,rowBounds);
		return lists;	}




}
