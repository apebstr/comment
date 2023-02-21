package comments.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CommentsController {

	
	public CommentsController() {
		// TODO Auto-generated constructor stub
	}
	
	//버튼 클릭하면 처리될 내용
	@RequestMapping(value="/test.do")
	public ModelAndView process(String comContent, ModelAndView mav) {
		mav.addObject("comContent", comContent);
		mav.setViewName("board/commentview");		
		return mav;
	}
}
