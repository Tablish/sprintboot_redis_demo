package com.aop.AdviceConfig;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.logging.Logger;

/**
 * @Author qianyongchao
 * @Description
 * @Date 2018/11/2
 * @Modified By
 */
@Aspect
@Component
public class WebLogAspect {

    ThreadLocal<Long> startTime = new ThreadLocal<>();
    //private Logger logg = Logger.getLogger(WebLogAspect.class);
    //切点pointCut where
    /*@Pointcut("execution(public * com.aop..*.*(..))")
    public void webLog() {
    }*/

    //通知advice   when what （when before afterReturning ，what 函数体）
    /*@Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        //st
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        System.out.println("URL : " + request.getRequestURL().toString());
        System.out.println("HTTP_METHOD : " + request.getMethod());
        System.out.println("IP : " + request.getRemoteAddr());
        System.out.println("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        System.out.println("ARGS : " + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        System.out.println("RESPONSE : " + ret);
    }*/




}
