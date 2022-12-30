package ch2;

import ch2.Pizza.Topping;
import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public class item2_hierarchical_builder {

    public static void main(String[] args) {
        NyPizza nyPizza = new NyPizza.Builder()
            .addTopping(Topping.SAUSAGE)
            .addTopping(Topping.ONION)
            .build();
        Calzone calzone = new Calzone.Builder()
            .addTopping(Topping.HAM)
            .sauceInside()
            .build();

        System.out.println(nyPizza.toppings);
        System.out.println(calzone.toppings);
    }
}

abstract class Pizza {
    public enum Topping { HAM, MUSHROOM, ONION, PEPPER, SAUSAGE }
    final Set<Topping> toppings;

    abstract static class Builder<T extends Builder<T>> {

        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        public T addTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        abstract Pizza build();

        protected abstract T self();
    }

    Pizza(Builder<?> builder) {
        toppings = builder.toppings.clone();
    }
}

class NyPizza extends Pizza {
    public enum SIZE { SMALL, MEDIUM, LARGE }
    private final SIZE size;

    public static class Builder extends Pizza.Builder<Builder> {
        private SIZE size = SIZE.LARGE;

        public Builder size(SIZE size) {
            this.size = size; return this;
        }

        @Override
        NyPizza build() {
            return new NyPizza(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    private NyPizza(Builder builder) {
        super(builder);
        size = builder.size;
    }
}

class Calzone extends Pizza {
    private boolean sauceInside = false;

    public static class Builder extends Pizza.Builder<Builder> {
        private boolean sauceInside;

        public Builder sauceInside() {
            this.sauceInside = true; return this;
        }

        @Override
        Calzone build() {
            return new Calzone(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    private Calzone(Builder builder) {
        super(builder);
        this.sauceInside = builder.sauceInside;
    }
}