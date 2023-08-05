package com.example.demo.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RegionAspect {
	@Pointcut("execution(public void com.example.demo.controllers.RegionController.findAll())")
	public void p1() { }
	@Before("p1()")
	public void beginTransaction() {
	      System.out.println("Transaction begins !");
	}
	@After("p1()")
	public void completeTransaction() {
	      System.out.println("Transaction completes !");
	}
	@AfterReturning("p1()")
	public void commitTransaction() {
	      System.out.println("Transaction committed !");
	}
	@AfterThrowing("p1()")
	public void rollbackTransaction() {
	      System.out.println("Transaction rolled back !");
	}
//	@Around("p4()")
//	public void testAroundAdvice(ProceedingJoinPoint pj) throws Throwable {
//	       System.out.println("Executing Before part of business method");
//	       pj.proceed(); // this code will call business method
//	       System.out.println("Executing After part of business method");
//	}
}
