package coffeeshop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        OrderService orderService = context.getBean(OrderService.class);

        Order order = new Order();
        order.addItem(Coffee.CAPPUCCINO);
        order.addItem(Coffee.AMERICANO);
        order.addItem(Coffee.GLACE);
        orderService.processOrder(order);
    }
}