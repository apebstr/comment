package comments.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import board.dto.PageDTO;
import comments.service.CommentsService;

@Controller
public class CommentsController {

	private CommentsService commentsService;


	public CommentsController() {
		// TODO Auto-generated constructor stub
	}

	public void setCommentsService(CommentsService commentsService) {
		this.commentsService = commentsService;
	}


	@RequestMapping("/board/clist.do")
	public ModelAndView listExecute(int num, ModelAndView mav) {
		int totalRecord = commentsService.countProcess(num);
		mav.addObject("cList", commentsService.listProcess(num));
		mav.setViewName("board/res");
		return mav; 
	}

}

