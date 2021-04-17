package board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import board.model.Board;
import board.model.BoardDao;
import utility.Paging;

@Controller
public class BoardListController {
	private final String command = "/list.br";
	private final String command2 = "/read.br";
	private final String getPage = "list";
	private final String getPage2 = "read";

	
	@Autowired
	private BoardDao boardDao;
	
	@RequestMapping(value=command)
	public String doAction(
			@RequestParam(value="whatColumn",required = false) String whatColumn,
			@RequestParam(value="keyword",required = false) String keyword,
			@RequestParam(value="pageNumber",required = false) String pageNumber,
			@RequestParam(value="pageSize",required = false) String pageSize,
			HttpServletRequest request,
			Model model, HttpSession session) {
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("whatColumn", whatColumn);
		map.put("keyword", "%"+keyword+"%");
		int totalCount = boardDao.getTotalCount(map);
		
		String url = request.getContextPath() + command; 
		Paging pageInfo = new Paging(pageNumber, pageSize, totalCount, url, whatColumn, keyword);
		
		List<Board> boardList = boardDao.getDataList(pageInfo, map);		
		
		model.addAttribute("boardList", boardList);
		model.addAttribute("pageInfo", pageInfo);
		
		return getPage;		
	}
	
	
	@RequestMapping(value=command2)
	public String doAction(Model model, int boardNum) {
		Board board = boardDao.getOne(boardNum);
		model.addAttribute("board", board);
		boardDao.hitBoard(boardNum);

		return getPage2;		
	}
	
//	@RequestMapping(value="getSession")
//	public String getSession(HttpSession session) {
//		session.setAttribute("memberNum", 2);
//		session.setAttribute("name", "김김");		 
//
//		return "redirect:"+command;		
//	}
//	
//	@RequestMapping(value="removeSession")
//	public String removeSession(HttpSession session) {
//		session.invalidate();
//		return "redirect:"+command;		
//	}
//
}

