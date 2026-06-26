package coffeeshop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@Aspect
public class LoggingAspect {
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
        System.out.println("[LOG] Время обработки заказа: " + orderDuration + " мс");
        return result;
    }
}
