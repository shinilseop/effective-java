package ch2;

import ch2.item2_builder.Coffee.Builder;

public class item2_builder {

    public static void main(String[] args) {
        Coffee coffee = new Builder()
            .name("americano")
            .shot(2)
            .isLatte(false)
            .price(5000)
            .build();
        System.out.println(coffee);

        Coffee latte = new Builder()
            .name("Latte")
            .isLatte(true)
            .price(7000)
            .build();

        System.out.println(latte);
    }

    static class Coffee {
        private final String name;
        private final int shot;
        private final boolean isLatte;
        private final int price;

        public Coffee(Builder builder) {
            this.name = builder.name;
            this.shot = builder.shot;
            this.isLatte = builder.isLatte;
            this.price = builder.price;
        }

        static class Builder {
            private String name;
            private boolean isLatte;
            private int price;
            private int shot = 2;

            public Builder name(String name) {
                this.name = name; return this;
            }

            public Builder isLatte(boolean isLatte) {
                this.isLatte = isLatte; return this;
            }

            public Builder price(int price) {
                this.price = price; return this;
            }

            public Builder shot(int shot) {
                this.shot = shot; return this;
            }

            public Coffee build() {
                return new Coffee(this);
            }
        }

        @Override
        public String toString() {
            return String.format("이름 : %s, 샷 : %d, 우유 : %s, 가격 : %d", name, shot,
                isLatte ? "있음" : "없음", price);
        }
    }
}