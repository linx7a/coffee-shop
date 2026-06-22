package coffeeshop;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<Coffee> items = new ArrayList<>();

    public void addItem(Coffee coffee) {
        items.add(coffee);
    }

    public BigDecimal getTotalPrice() {
        BigDecimal total = BigDecimal.ZERO;
        for (Coffee item : items) {
            total = total.add(item.getPrice());
        }
        return total;
    }

    public int getTotalCookingTime() {
        int totalTime = 0;
        for (Coffee item : items) {
            totalTime += item.getCookingTimeInSeconds();
        }
        return totalTime;
    }

    public List<Coffee> getItems() {
        return items;
    }
}
