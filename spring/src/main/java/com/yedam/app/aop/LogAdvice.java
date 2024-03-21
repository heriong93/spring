package com.yedam.app.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;


@Slf4j // 
@Aspect  //aspect설정 
@Component  //빈 등록
public class LogAdvice {
	
	@Pointcut("execution(* com.yedam.app.emp..*Impl.*(..))") //다른곳에서도 쉽게 불러쓸 수 있도록 따로 빼주
	public void allpointcut() {}
	
	@Before("allpointcut()") //Impl로 끝나는 클래스 안에 있는 모든 메소드 
	public void logBefore(JoinPoint jp) {
		System.out.println("[log before]");
		String name = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		System.out.println(name+ ":");
		if(args != null) {
			for(Object arg :args) {
				System.out.println(arg);
			}
		}
	}
}
