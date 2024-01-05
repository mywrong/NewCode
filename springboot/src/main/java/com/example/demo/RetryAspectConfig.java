package com.example.demo;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class RetryAspectConfig {
    @Around("execution(* com.example.demo..*(..)) && @annotation(com.example.demo.Retry)")
    public void around(ProceedingJoinPoint pj){
        try{
            pj.proceed();
        }catch (Throwable e){
            try {
                System.out.println("retry");
                pj.proceed();
            }catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
    }
}
