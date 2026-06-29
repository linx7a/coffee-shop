package coffeeshop;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void getTotalPrice() {
        Order order = new Order();
        order.addItem(Coffee.CAPPUCCINO);
        order.addItem(Coffee.AMERICANO);

        BigDecimal total = order.getTotalPrice();

        assertEquals(new BigDecimal("410.00"), total);
    }

    @Test
    void getTotalCookingTime() {
        Order order = new Order();
        order.addItem(Coffee.GLACE);
        order.addItem(Coffee.CAPPUCCINO);

        int totalTime = order.getTotalCookingTime();

        assertEquals(240, totalTime);
    }

    @Test
    void getTotalPriceForEmptyOrder() {
        Order order = new Order();

        BigDecimal total = order.getTotalPrice();

        assertEquals(0, total.compareTo(BigDecimal.ZERO));
    }
}