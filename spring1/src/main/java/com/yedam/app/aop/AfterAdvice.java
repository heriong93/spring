package com.yedam.app.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect  //aspect설정 
@Component  //빈 등록
public class AfterAdvice {
	@AfterReturning (pointcut = "LogAdvice.allpointcut()", returning = "returning")
	public void afterlog(JoinPoint jp, Object returning) {
		System.out.println("[log after]");
		String name = jp.getSignature().getName();
		System.out.println(name+ ":");
		System.out.println("return:"+ returning);
	}
}
