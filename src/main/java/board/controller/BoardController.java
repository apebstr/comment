package board.controller;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import board.dto.BoardDTO;
import board.dto.PageDTO;
import board.service.BoardService;
import common.file.FileUpload;
import members.dto.AuthInfo;

@Controller
public class BoardController {

   private BoardService boardService;
   private PageDTO pdto;
   
   public BoardController() {

   }
   
   public void setBoardService(BoardService boardService) {
      this.boardService = boardService;
   }
   
   @RequestMapping("/board/list.do")
   public ModelAndView listExecute(@ModelAttribute("pv") PageDTO pv, ModelAndView mav) {
      int totalRecord = boardService.countProcess();
      if(totalRecord>=1) {
    	  if(pv.getCurrentPage()==0)
    		  pv.setCurrentPage(1);
    	  this.pdto = new PageDTO(pv.getCurrentPage(), totalRecord);
    	  mav.addObject("pv", this.pdto);
    	  mav.addObject("aList", boardService.listProcess(this.pdto));
      }
      mav.setViewName("board/list");
      return mav; 
   }
   
   @RequestMapping(value="/board/write.do", method=RequestMethod.GET)
   public ModelAndView writeExcute(@ModelAttribute("dto") BoardDTO dto, @ModelAttribute("pv") PageDTO pv, ModelAndView mav) {
      mav.setViewName("board/write");
      return mav;
   }
   
   @RequestMapping(value="/board/write.do", method=RequestMethod.POST)
   public String writeProExcute(BoardDTO dto, PageDTO pv, HttpServletRequest req, HttpSession session,RedirectAttributes ratt) {
      MultipartFile file = dto.getFilename();
     
      //test
     //System.out.println(dto.getMembersDTO().getMemberName());
      
      //첨부파일이 있으면 
      if(!file.isEmpty()) {
         UUID random = FileUpload.saveCopyFile(file, req);
         dto.setUpload(random + "_" + file.getOriginalFilename());   
      }
      
      dto.setIp(req.getRemoteAddr());
      
      //memberEmail로 memberName가져오기
//      AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
//      dto.setMemberEmail(authInfo.getMemberEmail());

      boardService.insertProcess(dto);
      
      if(dto.getRef() !=0) {
    	  ratt.addAttribute("currentPage", pv.getCurrentPage());
      }
      
      return "redirect:/board/list.do";
   }
   
   @RequestMapping(value="/board/view.do", method=RequestMethod.GET)
   public ModelAndView viewExcute(int currentPage, int num, ModelAndView mav) {
      System.out.printf("currentPage:%d, num:%d\n", currentPage, num);
      mav.addObject("dto", boardService.contentProcess(num));
      mav.addObject("currentPage", currentPage);
      mav.setViewName("board/view");
      return mav;
   }
   
	//(ajax) 덧글처리 - 버튼 클릭하면 처리될 내용
	@RequestMapping(value="/board/view.do", method=RequestMethod.POST)
	public ModelAndView process(int currentPage, int num, String comContent, ModelAndView mav) {
		System.out.printf("currentPage:%d, num:%d\n", currentPage, num);
		mav.addObject("comContent", comContent);
	    mav.addObject("dto", boardService.contentProcess(num));
	    mav.addObject("currentPage", currentPage);
		mav.setViewName("board/res");		
		return mav;
	}
   
   @RequestMapping(value="/board/update.do", method=RequestMethod.GET)
   public ModelAndView updateExecute(int num, int currentPage, ModelAndView mav) {
	   mav.addObject("dto", boardService.updateSelectProcess(num));
	   mav.addObject("currentPage", currentPage);
	   mav.setViewName("board/update");
	   return mav;
   }
   
   @RequestMapping(value = "/board/update.do", method=RequestMethod.POST)                              
   public String updateExecute(BoardDTO dto, int currentPage, HttpServletRequest request, RedirectAttributes ratt) {
      MultipartFile file = dto.getFilename();
      if(!file.isEmpty()) {
         UUID random = FileUpload.saveCopyFile(file, request);
         dto.setUpload(random + "_" + file.getOriginalFilename());
      }
      
      boardService.updateProcess(dto, FileUpload.urlPath(request));
      
      //return "redirect:/board/list.do?currentPage=" + currentPage;
      
      ratt.addAttribute("currentPage", currentPage);
      return "redirect:/board/list.do";
   }
   
   @RequestMapping("/board/delete.do")
   public String deleteExecute(int num, int currentPage, HttpServletRequest request, RedirectAttributes ratt) {
	   
	   ratt.addAttribute("currentPage", currentPage);
	   boardService.deleteProcess(num, FileUpload.urlPath(request));
	   return "redirect:/board/list.do";
   }
   
   @RequestMapping("/board/contentdownload.do")
   public ModelAndView downloadExecute(int num, ModelAndView mav) {
	   mav.addObject("num", num);
	   mav.setViewName("download");
	   return mav;
   }
   
}//end class