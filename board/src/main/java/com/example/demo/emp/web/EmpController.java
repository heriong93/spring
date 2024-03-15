package com.example.demo.emp.web;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.emp.EmpVO;
import com.example.demo.emp.SearchVO;
import com.example.demo.emp.mapper.EmpMapper;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor //생성자 방식
@Controller //컨테이너에 bean 등록 + 사용자 요청 처리할 수 있는 커맨드 핸들러 변환
public class EmpController {
	
 final EmpMapper mapper; //의존성 주입 (DI dependency injection)
 
 //등록페이지 이동
@GetMapping("/emp/insert")
public void insert() {}

//등록처리 --> photo employees테이블에 photo 컬럼 추가, insert하기
@RequestMapping("/emp/insert") //전체 방식 다 매핑해줌
//@ResponseBody //결과는 페이지가 아니라 데이터 
public String insert(@ModelAttribute("emp")EmpVO vo, MultipartFile photoFile) throws IllegalStateException, IOException {
	//파일 업로드
	File file=new File("d:/upload",photoFile.getOriginalFilename());
		//파일 저장
	 photoFile.transferTo(file);
	 vo.setPhoto(photoFile.getOriginalFilename()); 
		System.out.println(vo);
		 mapper.insertEmp(vo);
	 System.out.println("파일명:"+photoFile.getOriginalFilename());
		System.out.println("파일크기:"+photoFile.getSize());
	 return "redirect:/emp/list"; //페이지 명 result.html
}

//수정 페이지 이동
@GetMapping("/emp/update")
public void update() {
	
}
//수정 처리
@PostMapping("/emp/update")
public String update(@ModelAttribute("emp") EmpVO vo) { //update.html 에 <form action="/emp/update" method="post">로 지정해줌
	System.out.println(vo);
	vo.setEmployeeId(221); //WHERE employee_id = #{employeeId}
	mapper.updateEmp(vo);
	return "redirect:/emp/list";
}	
//삭제 처리
//삭제처리
	@GetMapping("/emp/delete/{employeeId}")
	public String delete(@PathVariable int employeeId) {
		System.out.println(employeeId);
		mapper.deleteEmp(employeeId);
		return "redirect:/emp/list";
	}	

//상세 조회 페이지 이동
@GetMapping("/emp/info/{employeeId}")
public String getEmpInfo(@PathVariable Integer employeeId, Model model) {
	EmpVO emp = mapper.getEmpInfo(employeeId);
	model.addAttribute("emp", emp);
	System.out.println(emp);
	return "/emp/info";
}

//목록 페이지로 이동
@GetMapping("/emp/list")
public String empList(Model model,EmpVO vo, SearchVO svo) {
	model.addAttribute("empList",mapper.getEmpList(vo, svo));
	return "emp/list";
}


}
