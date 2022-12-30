package ch1;

import java.lang.ref.Cleaner;

public class item8 {

    public static void main(String[] args) throws Exception {
        try (Room myRoom = new Room(7)) { // remove
            System.out.println("hello ~ ");
        }

        new Room(99); // not remove
        System.out.println("whatever");
    }
}

class Room implements AutoCloseable {

    private static final Cleaner cleaner = Cleaner.create();

    private static class State implements Runnable {

        int numJunkPiles;

        State(int numJunkPiles) {
            this.numJunkPiles = numJunkPiles;
        }

        @Override
        public void run() {
            System.out.println("clean room");
            numJunkPiles = 0;
        }
    }

    private final State state;

    private final Cleaner.Cleanable cleanable;

    public Room(int numJunkPiles) {
        state = new State(numJunkPiles);
        cleanable = cleaner.register(this, state);
    }

    @Override
    public void close() throws Exception {
        cleanable.clean();
    }
}
