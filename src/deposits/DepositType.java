package deposits;

import java.math.BigDecimal;

/**
 * Created by ${Dotin} on ${4/25/2015}.
 */
public class DepositType {
    int interestRate;
    public enum depositTypes {
        ShortTerm(10), LongTerm(20), Qarz(0);
        private int value;

        private depositTypes(int value) {
            this.value = value;
        }

        public static boolean search(String str) {
            boolean flag = false;
            for (depositTypes t : depositTypes.values()) {
                if (t.name().equals(str))
                    flag = true;
            }
            return flag;
        }

        int getValue() {
            return value;
        }
    }

}
