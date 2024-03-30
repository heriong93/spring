package com.dbal.app.book.web;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.dbal.app.book.model.BookVO;
import com.dbal.app.book.service.BookService;

@Controller
public class BookController {

	
	@Autowired // 인터페이스 인젝션. (상속받은 자식 클래스도 자동으로 주입해줌)
	BookService bookService;
	
	//조회
	@GetMapping("getBook")
	 public String getBookList(Model model) { //헷갈리면 serviceimpl이랑 메소드명 똑같이 적어주면 기억하기 쉬움
		//목록 조회
		model.addAttribute("list",bookService.getBookList()); //"list"이름은 개인적으로 지정
		return "book/list";
	 }
	
	//대여 목록 조회 
	@GetMapping("getRent")
	 public String getRent(Model model) { //헷갈리면 serviceimpl이랑 메소드명 똑같이 적어주면 기억하기 쉬움
		//목록 조회
		model.addAttribute("rentlist",bookService.getRent()); //"list"이름은 개인적으로 지정
		return "book/getRent";
	 }
	
	//등록 페이지 이동
	  @GetMapping("insertBook") //메소드 형식이 다르면 같은 url 줘도 상관 없음
	  public String insertBookForm(Model model) {
		  model.addAttribute("bookNo", bookService.getBookNo());
		  return "book/insert";
	  }

	 //등록 처리
	  @PostMapping("insertBook")  //form에 method= post로 등록해주면 알아서 찾아옴
	    public String insertBook(BookVO vo) { //이 vo객체에 모든 값을 넣어주는 것
		  bookService.insertBook(vo); //등록처리 
	        return "redirect:getBook"; //다시 불러야할 때는 redirect 데이터 값을 가지고 가야하기 때문
	    }
	  
	  
}
