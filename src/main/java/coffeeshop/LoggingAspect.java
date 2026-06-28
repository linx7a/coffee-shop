package coffeeshop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import org.slf4j.Logger;

@Component
@Aspect
public class LoggingAspect {
    private static final Logger log = LoggerFactory.getLogger(LoggingAspect.class);
    @Pointcut("execution(* coffeeshop.Barista.brew(..))")
    public void brewPointcut() {}

    @Around("brewPointcut()")
    public Object logBrewTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long duration = System.currentTimeMillis() - start;

        log.info("Время: " + duration + " мс");

        return result;
    }

    @Pointcut("execution(* coffeeshop.OrderService.processOrder(..))")
    public void orderResultPointcut() {}

    @Value("${coffeeshop.name}")
    private String shopName;

    @Around("orderResultPointcut()")
    public Object logOrderResult(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Добро пожаловать в " + shopName + "!");
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        Order order = (Order) joinPoint.getArgs()[0];
        long orderDuration = System.currentTimeMillis() - start;
        System.out.println("Ваш заказ готов. Итого: " + order.getTotalPrice()
                        + " руб.");
        log.info("Время обработки заказа: " + orderDuration + " мс");
        return result;
    }
}
