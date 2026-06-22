package coffeeshop;


import org.springframework.stereotype.Service;

@Service
public class Barista {
    public void brew(Coffee coffee) {
        System.out.println(coffee.name() + " готовится...");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Готов!");
    }
}
