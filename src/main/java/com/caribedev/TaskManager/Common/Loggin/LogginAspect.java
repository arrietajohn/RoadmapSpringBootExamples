package com.caribedev.TaskManager.Common.Loggin;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 *
 * @author John Carlos Arrieta Arrieta
 */


@Component
@Aspect
  
public class LogginAspect {
   
 private final static Logger log = LoggerFactory.getLogger(LogginAspect.class);
    
    @Before("within(com.carivede.TaskManager.Application.Commands.*)")
    public void logBeforeCommands(JoinPoint joinPoint){
        var messageLog = "Before -> "
                +joinPoint.getSignature().getDeclaringTypeName()
                +"."+joinPoint.getSignature().getName();
       log.info(messageLog);
    }
    
    @After(
            "(within(com.carivede.TaskManager.Presentation.Controllers.*)) ||"
            + "(within(com.carivede.TaskManager.Presentation.Queries.*))"
    )
    public void logAfterControllers(JoinPoint joinPointer){
        log.info("After-> {}.{}",
                joinPointer.getSignature().getDeclaringTypeName(),
                joinPointer.getSignature().getName()
                
        );
    }
    
   @Around("within(com.carivede.TaskManager.Infraestructure.Repositories.*)")
    public long logHandleExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        var start = System.currentTimeMillis();
        
        log.info("Start -> {}.{}",
                proceedingJoinPoint.getSignature().getDeclaringTypeName(),
                proceedingJoinPoint.getSignature().getName()
        );
         var end = System.currentTimeMillis() - start;
         
         log.info("End -> {}.{}",
                proceedingJoinPoint.getSignature().getDeclaringTypeName(),
                proceedingJoinPoint.getSignature().getName()
        );
         return end;
    }
    
     @AfterThrowing(pointcut = 
            "within(com.carivede.TaskManager.Infraestructure.Repositories.*)",
            throwing = "ex"
    )
     public void logRepositoryException(JoinPoint joinPoint, Throwable ex){
         log.info("Exception -> {}.{}: {}",
                 joinPoint.getSignature().getDeclaringTypeName(),
                 joinPoint.getSignature().getName(),
                 ex.getMessage(), ex);
     }
    
}
