package deposits;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by ${Dotin} on ${4/25/2015}.
 */
public class ShortTermDeposit extends DepositType {
    public ShortTermDeposit()
    {
        interestRate=depositTypes.ShortTerm.getValue();
    }
}
