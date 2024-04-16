package com.cos.photogramstart.handler.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationAdvice {

    @Around("execution(* com.cos.photogramstart.web.api.*Controller.*(..))")
    public Object apiAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("==========================================");
        System.out.println("WEB API Controller 실행 : Data Response");
        System.out.println("==========================================");

        return joinPoint.proceed();

    }

    @Around("execution(* com.cos.photogramstart.web.*Controller.*(..))")
    public Object advice(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("==========================================");
        System.out.println("WEB Controller 실행 : File Response");
        System.out.println("==========================================");

        return joinPoint.proceed();

    }
}
