package com.cos.photogramstart.handler.aop;

import com.cos.photogramstart.handler.ex.CustomValidationApiException;
import com.cos.photogramstart.handler.ex.CustomValidationException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

@Component
@Aspect
public class ValidationAdvice {

    @Around("execution(* com.cos.photogramstart.web.api.*Controller.*(..))")
    public Object apiAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("==========================================");
        System.out.println("WEB API Controller 실행 : Data Response");
        System.out.println("==========================================");

        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if (arg instanceof BindingResult) {
                BindingResult bindingResult = (BindingResult) arg;

                if (bindingResult.hasErrors()) {
                    Map<String, String> errorMap = new HashMap<>();
                    for (FieldError fieldError : bindingResult.getFieldErrors()) {
                        errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
                    }
                    throw new CustomValidationApiException("유효성 검사 실패", errorMap);
                }
            }
        }

        return joinPoint.proceed();

    }

    @Around("execution(* com.cos.photogramstart.web.*Controller.*(..))")
    public Object advice(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("==========================================");
        System.out.println("WEB Controller 실행 : File Response");
        System.out.println("==========================================");

        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if (arg instanceof BindingResult) {
                BindingResult bindingResult = (BindingResult) arg;
                if (bindingResult.hasErrors()) {
                    Map<String, String> errorMap = new HashMap<>();
                    for (FieldError fieldError : bindingResult.getFieldErrors()) {
                        errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
                        System.out.println(fieldError.getDefaultMessage());
                    }
                    throw new CustomValidationException("유효성 검사 실패함", errorMap);
                }
            }
        }

        return joinPoint.proceed();

    }
}
