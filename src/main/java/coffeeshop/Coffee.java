package coffeeshop;

import java.math.BigDecimal;

public enum Coffee {
    ESPRESSO("150.00", 30),
    MACCHIATO("170.00", 45),
    AMERICANO("180.00", 60),
    CAPPUCCINO("230.00", 90),
    FLAT_WHITE("250.00", 100),
    LATTE("260.00", 120),
    GLACE("280.00", 150);

    private final BigDecimal price;
    private final int cookingTimeInSeconds;

    Coffee(String price, int cookingTimeInSeconds) {
        this.price = new BigDecimal(price);
        this.cookingTimeInSeconds = cookingTimeInSeconds;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getCookingTimeInSeconds() {
        return cookingTimeInSeconds;
    }
}