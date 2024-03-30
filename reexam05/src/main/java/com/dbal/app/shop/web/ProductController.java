package com.dbal.app.shop.web;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.dbal.app.shop.model.ProductVO;
import com.dbal.app.shop.service.ProductService;

@Controller
public class ProductController {

	
	@Autowired // 인터페이스 인젝션. (상속받은 자식 클래스도 자동으로 주입해줌)
	ProductService productService;
	
	//상품 조회
	@GetMapping("getProduct")
	 public String getProductList(Model model) { //헷갈리면 serviceimpl이랑 메소드명 똑같이 적어주면 기억하기 쉬움
		//목록 조회
		model.addAttribute("list",productService.getProductList()); //"list"이름은 개인적으로 지정
		return "shop/list";
	 }
	
	
	//등록 페이지 이동
	  @GetMapping("insertProduct") //메소드 형식이 다르면 같은 url 줘도 상관 없음
	  public String insertProductForm(Model model) {
		  model.addAttribute("productId", productService.getProductNo());
		  return "shop/insert";
	  }

	 //등록 처리
	  @PostMapping("insertProduct")  //form에 method= post로 등록해주면 알아서 찾아옴
	    public String insertBook(ProductVO vo) { //이 vo객체에 모든 값을 넣어주는 것
		  productService.insertProduct(vo); //등록처리 
	        return "redirect:getProduct"; //다시 불러야할 때는 redirect 데이터 값을 가지고 가야하기 때문
	    }
	  
	  
}
