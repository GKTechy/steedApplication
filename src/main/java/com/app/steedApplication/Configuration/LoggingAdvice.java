package com.app.steedApplication.Configuration;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAdvice {

		Logger log= LoggerFactory.getLogger(LoggingAdvice.class);
	
	
		// User Module Log Info
	/*	@Pointcut(value= "execution(* com.app.vhsOptho.User.dao.UserDAOImpl.*(..))")
	    private void userModule(){ }
		
		@Before(value= "userModule()")
	    public void userModulebeforeAdvice(JoinPoint joinPoint){
	    	String methodName=joinPoint.getSignature().getName();
			String className=joinPoint.getTarget().getClass().toString();
			log.info("*******userModule************** method invoked " + className + " : " + methodName + "() *********************" );
	    }  
	    
	    @AfterReturning(value = "execution(* com.app.vhsOptho.User.dao.UserDAOImpl.*(..))",returning = "result")
        public void userModuleafterReturning(JoinPoint joinPoint, Object result) {
	    //	log.info(" *********************  {} returned with value {} \n", joinPoint, result);
	    	log.info(" ********userModule*************  {} returned with value \n", joinPoint);
        }
	    
	    @AfterThrowing(pointcut = "execution(* com.app.vhsOptho.User.dao.UserDAOImpl.*(..))",throwing= "error")
	    public void userModulelogAfterThrowing(JoinPoint joinPoint, Throwable error) {
	    	log.info(" *****userModule****************  Exception  ********************* :\n ", joinPoint.getSignature().getName(), error);
	    }
	    
	    
    	// Registration Module Log Info
 		@Pointcut(value= "execution(* com.app.vhsOptho.Registration.dao.RegistrationDAOImpl.*(..))")
 	    private void registrationModule(){ }
 		
 		@Before(value= "registrationModule()")
 	    public void registrationModulebeforeAdvice(JoinPoint joinPoint){
 	    	String methodName=joinPoint.getSignature().getName();
 			String className=joinPoint.getTarget().getClass().toString();
 			log.info("********Registration Module************* method invoked " + className + " : " + methodName + "() *********************" );
 	    }  
 	    
 	    @AfterReturning(value = "execution(* com.app.vhsOptho.Registration.dao.RegistrationDAOImpl.*(..))",returning = "result")
         public void registrationModuleafterReturning(JoinPoint joinPoint, Object result) {
 	    	log.info(" *********Registration Module************  {} returned with value {}", joinPoint);
         }
 	    
 	    @AfterThrowing(pointcut = "execution(* com.app.vhsOptho.Registration.dao.RegistrationDAOImpl.*(..))",throwing= "error")
 	    public void registrationModulelogAfterThrowing(JoinPoint joinPoint, Throwable error) {
 	    	log.info(" *********Registration Module************  Exception  ********************* :\n ", joinPoint.getSignature().getName(), error);
 	    }
	 	 
 	    // PreRegistration Module Log Info
 		@Pointcut(value= "execution(* com.app.vhsOptho.PreRegistration.dao.PreRegistrationDAOImpl.*(..))")
 	    private void preRegistrationModule(){ }
 		
 		@Before(value= "registrationModule()")
 	    public void preRegistrationModulebeforeAdvice(JoinPoint joinPoint){
 	    	String methodName=joinPoint.getSignature().getName();
 			String className=joinPoint.getTarget().getClass().toString();
 			log.info("********PreRegistration Module************* method invoked " + className + " : " + methodName + "() *********************" );
 	    }  
 	    
 	    @AfterReturning(value = "execution(* com.app.vhsOptho.PreRegistration.dao.PreRegistrationDAOImpl.*(..))",returning = "result")
         public void preRegistrationModuleafterReturning(JoinPoint joinPoint, Object result) {
 	    	log.info(" *******PreRegistration Module**************  {} returned with value {}", joinPoint);
         }
 	    
 	    @AfterThrowing(pointcut = "execution(* com.app.vhsOptho.PreRegistration.dao.PreRegistrationDAOImpl.*(..))",throwing= "error")
 	    public void preRegistrationModulelogAfterThrowing(JoinPoint joinPoint, Throwable error) {
 	    	log.info(" ********PreRegistration Module*************  Exception  ********************* :\n ", joinPoint.getSignature().getName(), error);
 	    } */
 	 	    
}
