package ch4;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class item15_minimize_accessor {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(Test15.PUBLIC_LIST));
        Test15.PUBLIC_LIST[2] = 4;

        Test15 test15 = new Test15();
        System.out.println(Arrays.toString(Test15.PUBLIC_LIST));
        System.out.println(Arrays.toString(test15.getPrivateList()));
        System.out.println(Test15.PRIVATE_LIST_VALUES);
    }
}

class Test15 {
    public static final Integer[] PUBLIC_LIST = {1, 2, 3}; // danger!
    private static final Integer[] PRIVATE_LIST = {1, 2, 3}; // danger!
    public static final List<Integer> PRIVATE_LIST_VALUES = Collections.unmodifiableList(Arrays.asList(PRIVATE_LIST));

    public Integer[] getPrivateList() {
        return PRIVATE_LIST.clone();
    }
}
