package origin_codes.src.chapter2.item2.hierarchicalbuilder;

import origin_codes.src.chapter2.item2.hierarchicalbuilder.NyPizza.Size;
import origin_codes.src.chapter2.item2.hierarchicalbuilder.Pizza.Topping;

// 계층적 빌더 사용 (21쪽)
public class PizzaTest {
    public static void main(String[] args) {
        NyPizza pizza = new NyPizza.Builder(Size.SMALL)
                .addTopping(Topping.SAUSAGE).addTopping(Topping.ONION).build();
        Calzone calzone = new Calzone.Builder()
                .addTopping(Topping.HAM).sauceInside().build();
        
        System.out.println(pizza);
        System.out.println(calzone);
    }
}
