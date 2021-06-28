package com.example.spring.aspect.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("allGetters() AND allCircleMethods()")
    public void loggingAdvice(JoinPoint joinPoint) {
        System.out.println("Advice called. " + joinPoint.getSignature().getDeclaringTypeName() + " method called.");
    }

    @Before("allGetters()")
    public void secondAdvice() {
        System.out.println("Second Advice called.");
    }

    @Before("allCircleMethods()")
    public void circleAdvice() {
        System.out.println("Circle Advice called.");
    }

    @Before(value = "execution(* com.example.spring.aspect.demo..*(..)) and args(name)")
    public void nameArgumentAdvice(JoinPoint joinPoint, String name) {
        System.out.println("Before method: " + joinPoint.getSignature());

        System.out.println("name argument value with: " + name);
    }

    @After(value = "execution(* com.example.spring.aspect.demo..*(..)) and args(String)")
    public void anyStringArgumentAdvice() {
        System.out.println("Advice of name method argument was called.");
    }

    @AfterReturning(pointcut = "execution(* com.example.spring.aspect.demo.model..*draw(..)) and args(name)", returning = "returnedString")
    public void afterDrawing(String name, String returnedString) {
        System.out.println("The name is '" + name + "'. The returned String is: '" + returnedString + "'");
    }

    @Around("execution(* com.example.spring.aspect.demo.model..*refresh(..)) and args(delay)")
    public void manageRefresh(ProceedingJoinPoint proceedingJoinPoint, Integer delay) {
        System.out.println("Refresh check with delay: " + delay);

        try {
            if (delay < 100) {
                System.out.println("Refreshing with new delay configuration " + (delay - 5));
                proceedingJoinPoint.proceed(new Object[]{ delay - 5 });
                System.out.println("Refresh done...");
            } else {
                System.out.println("Refresh unsupported...");
            }
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @Before("@annotation(com.example.spring.aspect.demo.aspect.annotation.Loggable)")
    public void logServices(JoinPoint joinPoint) {
        System.out.println("Service call " + joinPoint.getSignature() + " executed.");
    }

    @Pointcut("execution(* com.example.spring.aspect.demo..*.get*())")
    public void allGetters() {}

    @Pointcut("within(com.example.spring.aspect.demo.model.Circle)")
    public void allCircleMethods() {}
}
