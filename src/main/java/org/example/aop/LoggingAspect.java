package org.example.aop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;


@Aspect
public class LoggingAspect {

    @Before("execution(* transformString(String)) && args(input)")
    public void logBeforeTransformation(String input) {
        System.out.println("Лог до трансформації: " + input);
    }


    @AfterReturning(pointcut = "execution(* transformString(String))", returning = "result")
    public void logAfterTransformation(String result) {
        System.out.println("Лог після трансформації: " + result);
    }
}
