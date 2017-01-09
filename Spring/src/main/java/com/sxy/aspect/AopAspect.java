package com.sxy.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopAspect {

    @Pointcut("execution(* com.sxy.service..*.*(..))")

    public void pointcut(){}
    @Before("pointcut()")
    public void beforeAspect(){
        System.out.println("前通知");
    }
   @AfterReturning(value = "pointcut()" ,returning="result")
    public void afterAspect(Object result){
        System.out.println("后通知:"+result);
    }
    @AfterThrowing("pointcut()")
    public  void exceptionAspect() {
        System.out.println("异常通知");
    }
    @After("pointcut()")
    public  void afterExceptionAspect(){
        System.out.println("最后通知");
    }

   /* @Around("pointcut()")
    public void aroundAspect(ProceedingJoinPoint joinPoint){
        try {
            System.out.println("前通知");
            Object object=joinPoint.proceed();
            System.out.println("后通知");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }finally {
            System.out.println("最后通知");
        }
    }*/
}
