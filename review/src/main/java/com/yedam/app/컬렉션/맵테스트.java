package com.yedam.app.컬렉션;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class 맵테스트 {
	public static void main(String[] args) {
		HashMap<String, Object> map = new HashMap<>(); //해시함수 거쳐서 위치 검색하기 위해 hashmap사용 
		map.put("100","park");
		map.put("101","kim");
		map.put("102","choi");
		
		String name = (String)map.get("101");
		
		//반복문 
		for(String key : map.keySet()) {
			System.out.println(key + ":" +map.get(key));
		}
		List<HashMap<String, Object>> empList = new ArrayList<HashMap<String,Object>>();
		map = new HashMap<>();
		map.put("firstName", "park");
		map.put("lastName", "aaa");
		map.put("salary", 20000);
		empList.add(map);
		
		map = new HashMap<>();
		map.put("firstName", "choi");
		map.put("lastName", "bbb");
		map.put("salary", 10000);
		empList.add(map);
		
		for(HashMap <String,Object>empMap :empList) {
			System.out.println(empMap.get("firstName"));
			
		}
		//filter: 급여가 15000 이상인 사람만 
		List<HashMap<String, Object>> empList2 = new ArrayList<HashMap<String,Object>>(); //새로 배열 만들어주고 
		for(HashMap<String, Object> newMap : empList) {
			if((int)(newMap).get("salary") > 15000){
		empList2.add(newMap);
		}
	}
		
		empList2 = empList.stream()
				   .filter(vo->(int)vo.get("salary") > 15000) //문자타입일경우 .equals.startswith . contains
				   .peek(System.out::println)
				   .collect(Collectors.toList());
			}
  }
}
