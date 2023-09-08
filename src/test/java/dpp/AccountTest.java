package dpp;

import org.junit.Assert;
import org.junit.Test;

public class AccountTest {
    private double epsilon = 1e-6;

    @Test
    public void accountCannotHaveNegativeOverdraftLimit() {
        Account account = new Account(-20);
        
        Assert.assertEquals(0d, account.getOverdraftLimit(), epsilon);
    }
  
    @Test
    public void dipositeAndWithdrawCanNotHaveNegativeNumber() {
        Account account = new Account(20.0);
        
        Assert.assertFalse(account.deposite(-10.0));
    }

    @Test
    public void overlimitWithdraw() {
        Account account = new Account(10.0);
        boolean res = account.deposite(15);
        Assert.assertTrue(account.deposite(10.0));
        //Assert.assertFalse(account.withdraw(-10.0));
    }


}