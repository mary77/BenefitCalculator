package deposits;

import deposits.Deposit;
import exception.WrongDataException;

import java.math.BigDecimal;

/**
 * Created by ${Dotin} on ${4/25/2015}.
 */
public class DepositValidator {

    public static  void checkDays( int Days) throws WrongDataException
    {
            if (Days <= 0) throw new WrongDataException("Invalid DurationDay");
    }
    public  static void checkType(String str) throws WrongDataException
    {
      if (!DepositType.depositTypes.search(str)) throw new WrongDataException("Invalid DataType");
    }

    public static  void checkBalance(BigDecimal Balance) throws WrongDataException
    {
        if (Balance.compareTo(BigDecimal.ZERO) < 0)
        {
           throw new WrongDataException("Insufficient Balance");
        }
    }
}
