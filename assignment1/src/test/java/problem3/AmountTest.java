package problem3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AmountTest {
    private Integer expectDollar;
    private Integer expectCent;
    private Integer expectDollarInvalid;
    private Integer expectCentInvalid;
    private Integer expectDollarInvalid2;
    private Integer expectCentInvalid2;
    private Amount testAmount;
    private Amount testAmount2;
    private Amount testAmount3;

    @Before
    public void setUp() throws Exception {
      expectDollar = 1;
      expectCent = 20;
      testAmount = new Amount(expectDollar, expectCent);

      expectDollarInvalid = -1;
      expectCentInvalid = -20;
      testAmount2 = new Amount(expectDollarInvalid, expectCentInvalid);

      expectDollarInvalid2 = -3;
      expectCentInvalid2 = 105;
      testAmount3 = new Amount(expectDollarInvalid2, expectCentInvalid2);
    }

    @Test
    public void getDollar() {
      assertEquals(expectDollar, testAmount.getDollar());
      assertEquals(null, testAmount2.getDollar());
      assertEquals(null, testAmount3.getDollar());
    }

    @Test
    public void getCent() {
      assertEquals(expectCent, testAmount.getCent());
      assertEquals(null, testAmount2.getCent());
      assertEquals(null, testAmount3.getCent());
    }
}