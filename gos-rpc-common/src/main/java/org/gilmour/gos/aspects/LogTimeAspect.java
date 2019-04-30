package org.gilmour.gos.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class LogTimeAspect {

    private Logger logger = LoggerFactory.getLogger(LogTimeAspect.class);

    @Pointcut("@annotation(LogTime)")
    private void annotatedMethods(){}

    @Around("annotatedMethods()")
    public Object doLogTime(ProceedingJoinPoint joinPoint) throws Throwable{
        logger.info("start execution...");
        long startTime = System.currentTimeMillis();

        Object res = joinPoint.proceed();

        long timeTaken = System.currentTimeMillis() - startTime;
        logger.info("Time taken by {} is {} ms", joinPoint, timeTaken);
        return res;
    }
}
