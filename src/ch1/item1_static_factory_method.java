package ch1;

import java.util.stream.Stream;

public class item1_static_factory_method {
    public static void main(String[] args) {
        Coffee coffee = Coffee.from("coffee");
        System.out.println(coffee.name);

        Coffee americano = Coffee.from("americano");
        System.out.println(americano.name);

        Stream<String> stream = Stream.of("1", "2", "3"); // 대표적 정적 메소드
        stream.forEach(System.out::print);
    }

    static class Coffee {
        String name;

        public Coffee(String name) {
            this.name = name;
        }

        public static Coffee from(String name) {
            return name.equals("americano") ? new Americano(2) : new Coffee(name);
        }
    }

    static class Americano extends Coffee {
        int shot;

        public Americano(int shot) {
            super("americano");
            this.shot = shot;
        }
    }
}