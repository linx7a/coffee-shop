package coffeeshop;

import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final Barista barista;

    public OrderService(Barista barista) {
        this.barista = barista;
    }
    public void processOrder(Order order) {
        for (Coffee coffee : order.getItems()) {
                barista.brew(coffee);
        }
    }
}
