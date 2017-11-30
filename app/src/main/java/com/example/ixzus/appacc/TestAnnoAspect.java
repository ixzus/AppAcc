package com.example.ixzus.appacc;

import android.os.SystemClock;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

/**
 * Created by huan on 2017/11/30.
 */
@Aspect
public class TestAnnoAspect {
    //    @Pointcut("execution(* com.example.ixzus.appacc.MySplashActivity.test(..))")
    @Pointcut("execution(@com.example.ixzus.appacc.TestAnnoTrace * *(..))")
    public void pointcut() {

    }

    @Before("pointcut()")
    public void before(JoinPoint point) {
        System.out.println("@Before");
    }

    @Around("pointcut()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
//        System.out.println("@Around");
//        joinPoint.proceed();
        long beginTime = SystemClock.currentThreadTimeMillis();
        joinPoint.proceed();
        long endTime = SystemClock.currentThreadTimeMillis();
        long dx = endTime - beginTime;
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String name = signature.getName(); // 方法名
        Method method = signature.getMethod(); // 方法
        Class returnType = signature.getReturnType(); // 返回值类型：void
        Class declaringType = signature.getDeclaringType(); // 方法所在类名：
        String[] parameterNames = signature.getParameterNames(); // 参数名：view
        Class[] parameterTypes = signature.getParameterTypes(); // 参数类型：View

        System.out.println(declaringType + "." + name + "耗时：" + dx + "ms");

        TestAnnoTrace annotation = method.getAnnotation(TestAnnoTrace.class);
        String value = annotation.value();
        int type = annotation.type();

        System.out.println("value:" + value + "-type:" + type);
    }

    @After("pointcut()")
    public void after(JoinPoint point) {
        System.out.println("@After");
    }

    @AfterReturning("pointcut()")
    public void afterReturning(JoinPoint point, Object returnValue) {
        System.out.println("@AfterReturning");
    }

    @AfterThrowing(value = "pointcut()", throwing = "ex")
    public void afterThrowing(Throwable ex) {
        System.out.println("@afterThrowing");
        System.out.println("ex = " + ex.getMessage());
    }

}
