//package com.example.restaurant.aop.aspects;
//
//
//import com.example.restaurant.aop.annotations.EntryOnController;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.springframework.stereotype.Component;
//
//import java.time.LocalDateTime;
//
//@Aspect
//@Component
//public class EntryOnAspect {
//
//    @Before(value = "@annotation(EntryOnController)", argNames = "EntryOnController")
//    public void controllerHit(EntryOnController entryOnController){
//        System.out.println("method "+ entryOnController.methodName() +"is hit at"+ LocalDateTime.now());
//    }
//}
