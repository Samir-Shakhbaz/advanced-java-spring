package platform.codingnomads.co.aspectorientedprogramming.lab.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;

public class PrintableAspect {

    @Aspect
    @Component
    public class LoggingAspect {

        private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(LoggingAspect.class);

        // Define the Point-cut expression
        @Pointcut("@annotation(Printable)")
        public void executeLogging() {
        }


        @Before("executeLogging()")
        public void logMethodCall(JoinPoint joinPoint) {
            StringBuilder message = new StringBuilder("Hello! This is a custom aspect : ");
//            message.append(joinPoint.getSignature().getName());
            final Object[] args = joinPoint.getArgs();
            if (args != null && args.length > 0) {
                message.append("method args=|");
                Arrays.asList(args).forEach(arg -> {
                    message.append("arg=").append(arg).append("|");
                });
            }
            LOGGER.info(message.toString());
        }
    }


}
