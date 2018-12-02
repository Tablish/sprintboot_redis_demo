package com.aop.AdviceConfig;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Author qianyongchao
 * @Description
 * @Date 2018/11/3
 * @Modified By
 */
@Aspect
@Component
public class LogInterceptor {
    /*@Pointcut("execution(public * com.aop..*.*(..))")
    public void myMethod(){};

    @Before(value = "myMethod()")
    public void before() {
        System.out.println("before...");
    }

    @AfterReturning(value = "myMethod()")
    public void after() {
        System.out.println("after...");
    }*/


    /*@Pointcut("execution(public * com.aop..*.*(..))")

    public void myMethod(){};



    @Before(value="myMethod()")

    public void before(){

        System.out.println("method start...");

    }



    @AfterReturning("myMethod()")

    public void afterReturning(){

        System.out.println("method after returning...");

    }



    @Around(value="myMethod()")

    public void around(ProceedingJoinPoint pjp) throws Throwable{

        //因为@around需要传入一个参数ProceedingJoinPoint进行前后加逻辑

        System.out.println("method around start...");



        //在需要前后逻辑的中间加入下列语句。表示前后逻辑，可能会抛出异常Throwable。

        pjp.proceed();

        System.out.println("method around end...");

    }
*/

}
