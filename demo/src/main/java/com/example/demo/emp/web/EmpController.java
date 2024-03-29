package com.example.demo.emp.web;

import java.util.List;
import java.util.Map;

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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.common.Paging;
import com.example.demo.emp.EmpVO;
import com.example.demo.emp.SearchVO;
import com.example.demo.emp.mapper.EmpMapper;
import com.example.demo.emp.service.EmpService;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor //생성자 방식
@Controller //컨테이너에 bean 등록 + 사용자 요청 처리할 수 있는 커맨드 핸들러 변환
public class EmpController {
	
 final EmpService empService;
 
// @RequestMapping("/update")
// @ResponseBody			//request.getParameter
// public String update(@RequestParam List<String> hobby) {
//	 System.out.println(hobby);
//	 return "true";
// }
// 

 
 @RequestMapping("/empResult")
 public String result() {
	 return "result";
 }
 
 @PostMapping("/insert3")
 public String insert3(EmpVO vo, RedirectAttributes rttr) {
	 System.out.println("등록:" + vo);
	 rttr.addAttribute("insertResult", "성공");
	 rttr.addFlashAttribute("flashResult", "한번만 사용가능"); //휘발성
	 return "redirect:empResult"; //mapping url.페이지명 아님
 }
 //INSERT2는 상태까시 넘길 수 잇는 것
 @PostMapping("/insert2")
 //response entity모든 결과가 ajax로 넘어감 
 public ResponseEntity<EmpVO> insert2(EmpVO vo) { //response body와 같음
	 return new ResponseEntity<>(vo,HttpStatus.OK);
 }
 //페이지 이동
 @GetMapping("/insert")
 public void insert() {}
 
 //insert 처리
 @PostMapping("/insert") //post방식으로만 
 //@RequestMapping("/insert") //전체 방식 다 매핑해줌
 //@ResponseBody //결과는 페이지가 아니라 데이터 
 public ModelAndView insert(@ModelAttribute("emp")EmpVO vo) {
	 System.out.println(vo);
	 empService.insertEmp(vo);
	 //커멘드 객체는 MODEL에 추가되고 
	 //model.addAttribute ("EmpVO", vo);
//model.addAttribute("insertResult","success"); //모델 넣어준 키 -벨류
	 ModelAndView mv = new ModelAndView();
	 mv.setViewName("/home"); //페이지명
	 mv.addObject("insertResult", "success");
	 //mv.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
	 return mv; //페이지 명 result.html
 }
 @GetMapping("/")
 public String test() {
	 return "index"; //index.html과 매핑시키기
 }
 
 @GetMapping("/info/{empId}") //<!-- localhost:8091/update/100 -->
 public String info(@PathVariable int empId, Model model) {
	 model.addAttribute("emp", empService.getEmpInfo(empId));
	 return "empInfo";
 }
 
 
 @GetMapping("/update/{empId}") //<!-- localhost:8091/update/100 -->
 public String update(@PathVariable int empId) {
	 System.out.println(empId);
	 return "index";
 }
 
 @GetMapping("/delete") // <!-- localhost:8091/delete?employeeId=100&name=xxx -->
 public String delete(int employeeId, String name) {
	 empService.deleteEmp(employeeId);
	 System.out.println(employeeId + name);
	 return "index"; 
 }
 
@RequestMapping("/empList")
public String empList(Model model, EmpVO vo, SearchVO svo, Paging pvo){
	//페이징처리
	pvo.setPageUnit(5); //데이터 수
	pvo.setPageSize(3); //페이지 번호 
	svo.setStart(pvo.getFirst());
	svo.setEnd(pvo.getLast());
	
	Map<String,Object> map = empService.getEmpList(vo,svo);
	
	pvo.setTotalRecord((Long)map.get("count"));
	model.addAttribute("paging",pvo);
	
	//목록조회	
	model.addAttribute("empList", map.get("data"));
return "empList";
  } 
}
