package com.example.demo.emp.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.common.Paging;
import com.example.demo.emp.EmpVO;
import com.example.demo.emp.SearchVO;
import com.example.demo.emp.mapper.EmpMapper;
import com.example.demo.emp.service.EmpService;

@RestController
public class EmpRestController {
@Autowired EmpService service;
	//리스트 페이지로 이동
	@RequestMapping("/empMng")
	public ModelAndView empMng(){
		ModelAndView mv = new ModelAndView("empMng");
		return mv;
	}
 
	//사원 리스트 데이터 
	@GetMapping("/ajax/empList")
	//@ResponseBody // vo-> json string 으로 넘겨줌. ajax응답은 무조건 이게 있어야함
	public Map<String, Object> empList(EmpVO vo, SearchVO svo, Paging pvo) {
		svo.setStart(pvo.getFirst());
		svo.setEnd(pvo.getLast());
		Map<String, Object> map = service.getEmpList(vo, svo);
		pvo.setTotalRecord((Long)map.get("count"));
		map.put("paging",pvo);
		
		return map;
	}
	//등록처리
	@PostMapping("/ajax/emp") //요청 url -> empMng.html 에 등록
	public EmpVO save(@RequestBody EmpVO vo) {
		//System.out.println(vo);
		service.insertEmp(vo);
		return vo;
	}
	//단건조회 
	@GetMapping("/ajax/emp/{empId}") //요청 url -> empMng.html 에 등록
	public EmpVO info(@PathVariable int empId) {
		return service.getEmpInfo(empId);
	}
	
	@GetMapping("/ajax/empStat") //요청 url -> empMng.html 에 등록
	public List<Map<String,Object>> stat() {
		return service.getStat();
	}
	
	}		
