package com.example.medistore.aspects;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class LoggingAspect {


    //@Before("execution(public String getName())")

    @Before("methodsOfCustomerServiceImpl()")
    public void loggingAdvice(JoinPoint joinPoint){
        System.out.println("advice run, Get method call using pointCut : "+joinPoint);
    }

    @Pointcut("within(com.example.medistore.service.impl.CustomerServiceImpl)")
    public void methodsOfCustomerServiceImpl(){}


    @Before("setDataOfCustomerServiceImpl()")
    public void secondLoggingAdvice(){
        System.out.println("second advice run, set method call using pointCut");
    }


    @Pointcut("execution(* com.example.medistore.service.impl.CustomerServiceImpl.setData(*)))")
    public void setDataOfCustomerServiceImpl(){}



    @AfterReturning(pointcut = "setDataOfCustomerServiceImpl()")
    public void AfterReturningAdvice(){
        System.out.println("third advice after run ");
    }



    @Around("@annotation(com.example.medistore.aspects.Loggable)")
    public Object AroundLoggingAdvice(ProceedingJoinPoint proceedingJoinPoint){

        Object returnValue=null;

        try {
            System.out.println("before advice");
            returnValue=proceedingJoinPoint.proceed();
            System.out.println("after returning");

        } catch (Throwable e) {
            System.out.println("after throwing");
        }
        System.out.println("after finally");
        return returnValue;
    }










  /*

   @Before("args(data)")
    public void thirdLoggingAdvice(String data){
        System.out.println("third advice run, set method with argument : "+data);
    }

    @Pointcut("execution(* com.example.medistore.service.impl.CustomerServiceImpl.getData()))")
    public void getDataOfCustomerServiceImpl(){}

    @Before("allGetters()")
    public void secondAdvice(){
        System.out.println("Second advice run, Get method call");
    }

    @Before("execution(* com.example.medistore.service.impl.CustomerServiceImpl.getData())")
    public void secondLoggingAdvice(){
        System.out.println("second advice run, Get method call");
    }*/






}
