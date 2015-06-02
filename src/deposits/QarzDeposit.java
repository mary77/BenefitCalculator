package deposits;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by ${Dotin} on ${4/25/2015}.
 */
public class QarzDeposit extends DepositType {
    public QarzDeposit()
    {
        interestRate=depositTypes.Qarz.getValue();
    }
}
