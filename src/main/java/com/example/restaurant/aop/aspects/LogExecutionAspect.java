package com.example.restaurant.aop.aspects;

import com.example.restaurant.aop.annotations.EntryOnController;
import com.example.restaurant.aop.annotations.LogExecutionTime;
import net.bytebuddy.implementation.bytecode.Throw;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import javax.servlet.http.PushBuilder;
import java.time.LocalDateTime;

@Aspect
@Component
public class LogExecutionAspect {

    @Around(value = "@annotation(LogExecutionTime)",argNames = "joinPoint, LogExecutionTime")
    public Object logExecutionAspect(ProceedingJoinPoint joinPoint,  LogExecutionTime logExecutionTime) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;
                System.out.println(joinPoint.getSignature() + " executed in " + executionTime + "ms");
//        System.out.println(logExecutionTime.methodName() + " executed in " + executionTime + "ms");
        return proceed;
    }

    @Before(value = "@annotation(EntryOnController)", argNames = "EntryOnController")
    public void controllerHit(EntryOnController entryOnController){
        System.out.println("method "+ entryOnController.methodName() +"is hit at"+ LocalDateTime.now());
    }
}

