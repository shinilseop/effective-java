package ch2;


public class item4_blocked_instancing {

    public static void main(String[] args) {
//        Utils utils = new Utils(); // private 으로 막힘
        System.out.println(Utils.sha256()); // 단순한 유틸 사용 ex) Collections, Arrays ...
    }
}

class Utils {

    private Utils() { // 단순히 유틸용으로 사용될 목적이기에 인스턴스화를 막음
        throw new AssertionError();
    }

    public static String sha256() { // 다양한 유틸들...
        return "~~sha256~~";
    }
}