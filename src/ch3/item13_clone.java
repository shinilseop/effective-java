package ch3;

public class item12_clone {

    public static void main(String[] args) {
        CloneTest cloneTest1 = new CloneTest(1);
        CloneTest cloneTest2 = cloneTest1.c;
        Object o;
    }
}

class CloneTest {
    int val;

    public CloneTest(int val) {
        this.val = val;
    }
}
