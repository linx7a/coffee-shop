package coffeeshop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class BrewingLoggingAspect {
    @Pointcut("execution(* coffeeshop.Barista.brew(..))")
    public void brewPointcut() {}

    @Around("brewPointcut()")
    public Object logBrewTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long duration = System.currentTimeMillis() - start;

        System.out.println("Время: " + duration + " мс");

        return result;
    }
}
