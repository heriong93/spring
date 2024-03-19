	//var empService=  {infoReq,saveReq,listReq} 이렇게 바로 부르는 것과 같음. 즉시실행함수
	var empService= (function(){
	
	
	//리스트 요청 
	async function listReq(p){
		const param = "?page="+p
	/*	fetch("/ajax/empList"+param)  //EmpRestController.java 와 비교하며 만들어줌 
		.then(res => res.json())
		.then(res=> listRes(res)) */
		//동기식 
		const res = await axios.get("/ajax/empList"+param);
		listRes(res.data)
	}
	
	//날짜 포맷 함수
	function dateFormat(dt){
		
	
			return dt;
		}
	
	//상세 조회 요청
	function infoReq(employeeId){
		fetch("/ajax/emp/"+employeeId)
		.then(res=> res.json())
		.then(res=> infoRes(res))
	}
	
	//상세 조회 응답
	function infoRes(res){
		//input tag 에 표시
		frm.email.value = res.email;
		frm.lastName.value = res.lastName;
		frm.jobId.value = res.jobId;
		frm.hireDate.value = res.hireDate;
	}
	
	
	//등록 요청
	function saveReq(){
		
	//1. queryString 
	
	/* const lastName=frm.lastName.value;
	const email=frm.email.value;
	const jobId=frm.jobId.value;
	const hireDate=frm.hireDate.value;
	let param = `lastName=${lastName}&email=${email}&hireDate=${hireDate}&jobId=${jobId}`

	fetch("/ajax/emp",{
		method : "post",
		headers: {
			"Content-Type':' application/x-www-form-urlencoded" 
			},
		body : param
	})
	.then(res=> res.json())
	.then(res=> saveRes(res)) */

	
 	//2. FormData 
 	
	/* let param = new FormData(document.frm);
	fetch("/ajax/emp",{
		method : "post",
		body : param
	})
	.then(res=> res.json())
	.then(res=> saveRes(res))
} */

	//3. JsonString  ( payload  )
	
	const lastName=frm.lastName.value;
	const email=frm.email.value;
	const jobId=frm.jobId.value;
	const hireDate=frm.hireDate.value;
	let param = {lastName, email, jobId, hireDate }
	
/*	fetch("/ajax/emp",{
		method : "post",
		headers: {
		      "Content-Type": "application/json",
		    },
		body : JSON.stringify(param)
	}) 
	.then(res=> res.json()) */
	
/*	.then(res=> saveRes(res)) 
	 const param = "?page=" + p
		axios.get("/ajax/empList" + param)
		.then(res=> listRes(res.data)) */
		
		axios.post("/ajax/emp",param)
		.then(res => saveRes(res.data))
}
		

	//등록 응답
	function saveRes(res){
		listReq(1)
		console.log(res)
	}
	//리스트 응답 
	function listRes(res){
			let i = 0;
			//로딩 전에 페이지 비워주기
			empList.innerHTML = '';
			nav.innerHTML = '';
			//목록출력
			for(emp of res.data){
					 empList.innerHTML += makeTr(++i,emp);
			}
			//페이징 처리
			nav.innerHTML = makePage(res.paging); //empRestController에 map에 담아준 값
			}
			//페이지 번호 생성
			function makePage(paging){
				let tag = `
				<nav aria-label="...">
				  <ul class="pagination">`
				  if(paging.startPage>1){
					  tag += `<li class="page-item" >
					        <a class="page-link" href="javascript:gopage(${paging.startPage-1})">Previous</a></li>`
				  }
				  //페이지 번호
				  for(i=paging.startPage; i <= paging.endPage;i++){
					  tag+= `<li class="page-item">
					        <a class="page-link"href="javascript:gopage(${i})">${i}</a></li>`
				  }
				  //다음버튼
				  if(paging.endPage <= paging.lastPage)
					  tag+= `<li class="page-item">
					        <a class="page-link" href="javascript:gopage(${paging.endPage+1})">Next</a></li>`
					       
				  tag+= `  </ul>
						</nav>`
				
				return tag;
				    
			}
		
	function makeTr(i,emp){
		let bonusBtn = '<button>신청</button>'
			if(emp.salary > 10000){
				bonusBtn = '<button>미신청</button>'
			}
		let newTag= `<tr>
			 <td>${i}</td>
			 <td onclick="infoReq(${emp.employeeId})">${emp.employeeId}</td>
			 <td>${emp.lastName}</td>
			 <td>${dateFormat(emp.hireDate)}</td>
			 <td>${emp.salary}</td>
			 <td>${bonusBtn}</td>
			 <td><button type="button" onclick="move(${emp.employeeId})">조회</button></td>
		 </tr>`
	return newTag;
	}
	return{infoReq,saveReq,listReq}
	})(); 