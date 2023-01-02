package ch3;

import java.math.BigInteger;

public class item12_toString {

    public static void main(String[] args) {

    }

    final class PhoneNumber {

        private final short areaCode, prefix, lineNum;

        public PhoneNumber(int areaCode, int prefix, int lineNum) {
            this.areaCode = rangeCheck(areaCode, 999, "지역코드");
            this.prefix = rangeCheck(prefix, 999, "프리픽스");
            this.lineNum = rangeCheck(lineNum, 9999, "가입자 번호");
        }

        private final short rangeCheck(int val, int max, String arg) {
            if (val < 0 || val > max) {
                throw new IllegalArgumentException(arg + ": " + val);
            }
            return (short) val;
        }

        @Override
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof ch3.PhoneNumber)) {
                return false;
            }
            ch3.PhoneNumber pn = (ch3.PhoneNumber) o;
            return pn.lineNum == this.lineNum && pn.prefix == this.prefix
                && pn.areaCode == this.areaCode;
        }

        @Override
        public int hashCode() {
            int result = Short.hashCode(areaCode);
            result = 31 * result + Short.hashCode(prefix);
            result = 31 * result + Short.hashCode(lineNum);
            return result;
        }


        /**
         * 전화번호의 문자열 표현을 만들어 반환한다. 이 표현은 향후에 변경이 될 수 있다.
         */
        @Override
        public String toString() {
            return String.format("%03d-%03d-%04d", areaCode, prefix, lineNum);
        }
    }
}