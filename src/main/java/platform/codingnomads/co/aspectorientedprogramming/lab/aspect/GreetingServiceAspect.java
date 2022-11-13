package platform.codingnomads.co.aspectorientedprogramming.lab.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.hibernate.mapping.Join;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import platform.codingnomads.co.aspectorientedprogramming.aop.aspect.ServiceAspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.logging.Logger;

import static org.hibernate.tool.schema.SchemaToolingLogging.LOGGER;

@Aspect
@Component
public class GreetingServiceAspect {

//    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceAspect.class);
    @Pointcut(value = "execution(* platform.codingnomads.co.aspectorientedprogramming.lab.service.GreetingService.*(..))")
    private void pointCutPrint2() {
    }

    @Before("pointCutPrint2()")
    public void logBeforePrint2(JoinPoint joinPoint) {
        LOGGER.info("This prints before pointCut");
    }

    @Before("execution(* platform.codingnomads.co.aspectorientedprogramming.lab.service.GreetingService.greeting())")
    public void beforeExecutionOfGreeting(JoinPoint joinPoint) {
        LOGGER.info("Before the execution of : ");
    }

    @AfterReturning("execution(* platform.codingnomads.co.aspectorientedprogramming.lab.service.GreetingService.greeting())")
    public void afterReturningAdvice() {
        LOGGER.info("After Returning Advice: Method Name: ");
        LOGGER.info("Result: " );
    }

    // Inform Java that the annotation you are creating can only be used to annotate methods
    @Target(ElementType.METHOD)
// Make your new annotation available in the JVM throughout runtime
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Printable {

    }


}
