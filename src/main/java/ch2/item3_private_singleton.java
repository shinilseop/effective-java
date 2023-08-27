package ch2;

import java.io.Serializable;

public class item3_private_singleton {

    public static void main(String[] args) {

    }
}

class Elvis implements Serializable {
    private static final Elvis INSTANCE = new Elvis();

    private Elvis() {
        throw new AssertionError();
    }

    public static Elvis getInstance() {
        return INSTANCE;
    }

    public void leaveTheBuilding() {
        // ...
    }
}