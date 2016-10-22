package com.sumon.api.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {

	@Before("allGetters()")
	public void loggingAdvice(JoinPoint joinPoint) {
		System.out.println(joinPoint.getTarget());
	}

	@Before("args(name)")
	public void stringArgumentMethods(String name) {
		System.out.println("A method that takes string arguments has been called. The value " + name);
	}

	@Before("allGetters()")
	public void secondAdvice() {
		System.out.println("Second Advice executed");
	}

	@After("args(name)")
	public void stringArgumentMethodsAfter(String name) {
		System.out.println("After:  A method that takes string arguments has been called. The value " + name);
	}

	@AfterReturning(pointcut = "args(name)", returning = "returnString")
	public void stringArgumentMethodsAfterRunning(String name, Object returnString) {
		System.out.println("AfterReturning:  A method that takes string arguments has been called after. "
				+ "The value " + name + "The output value is :" + returnString);
	}

	@AfterThrowing(pointcut = "args(name)", throwing = "ex")
	public void exceptionAdvice(String name, RuntimeException ex) {
		System.out.println("AfterThrowing:  exception thrown" + ex);
	}

	@Around("@annotation(com.sumon.api.aop.aspect.Loggable)")
	public Object myAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {

		Object returnValue = null;

		try {
			System.out.println("Before Advice");
			returnValue = proceedingJoinPoint.proceed();
			System.out.println("After Returing");
		} catch (Throwable e) {
			System.out.println("After Throwing");
		}

		System.out.println("After Finally");
		return returnValue;
	}

	@Pointcut("execution(* get*())")
	public void allGetters() {
	}

	@Pointcut("within(com.sumon.api.aop.model.Circle)")
	public void allCircleMethods() {
	}

	@Pointcut("args(com.sumon.api.aop.model.Circle)")
	public void MethodArg() {
	}

	/*
	 * @Before("execution(* get*(..))") //zero or more parameter. get*(*) -> one
	 * or more parameter public void loggingAdvice(){
	 * System.out.println("Advice run, get method called"); }
	 * 
	 * @Before("execution(* get*(..))") public void secondAdvice(){
	 * System.out.println("Second Advice executed"); }
	 * 
	 * @Pointcut("within(com.sumon.api.aop.model.Circle)") //all the methods in
	 * Circle model public void allCircleMethods(){}
	 * 
	 * @Pointcut("within(com.sumon.api.aop.model.*)") //all the methods/class in
	 * the specified model package
	 * 
	 * @Pointcut("within(com.sumon.api.aop.model..*)") //all the methods/class
	 * in the specified model package and sub package
	 * 
	 */

}
