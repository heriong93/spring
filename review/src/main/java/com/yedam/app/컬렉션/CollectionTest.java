package com.yedam.app.컬렉션;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import com.yedam.app.EmpVO;

/*
 * List, Set, Map
 * List: -> .index로 접근 -> 목록 용. 순차적 목록 
 * Set: .index로 접근 -> 중복값 허용x  
 * Map: <key, value> .key로 접근 -> 검색 시 유리
 */
public class CollectionTest {
	public static void main(String[] args) {
		//중복값 제거 
		List<Integer> list = Arrays.asList(3,3,10,11,14,3);
		System.out.println(list);
		
	//list => set (중복값 제거)
		//HashSet<Integer> s = new HashSet<Integer>(list);
		HashSet set  = new HashSet<>(list);
		System.out.println(set);
		
		//List <EmpVO>
		List<EmpVO> empList = new ArrayList<>();
		empList.add(new EmpVO ("kim", "bbb",15000));
		empList.add(new EmpVO ("choi", "aaa", 20000));
		empList.add(new EmpVO ("park", "ccc", 10000));
		empList.add(new EmpVO ("kim", "bbb",13000));
		
		HashSet <EmpVO> empSet = new HashSet<>(empList);
		System.out.println(empSet.size());
	
		//필터링 : 급여가 12000 넘는  사원만 검색
		List <EmpVO> filterList = new ArrayList<>(); 
		for(EmpVO vo : empSet) {  //empSet 으로 중복 제거한 리스트로 필터링
			if(vo.getSalary() > 12000) {
				filterList.add(vo);
				System.out.println(vo);
			}
		}
		System.out.println(filterList.size()); // 총 결과 수 
		
		
		// ==> stream 
		empSet.stream()
					   .filter(vo-> vo.getSalary() > 12000) //int일경우 
					   .collect(Collectors.toList());
		
		
		filterList = empSet.stream()
		   .filter(vo-> vo.getLastName().contains("bbb")) //문자타입일경우 .equals.startswith . contains
		   .collect(Collectors.toList());
		System.out.println(filterList.size());
	}
	
}
