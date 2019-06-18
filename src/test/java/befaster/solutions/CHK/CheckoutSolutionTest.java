package befaster.solutions.CHK;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CheckoutSolutionTest {

    private CheckoutSolution checkoutSolution;
    private String skus;
    private int result;

    @Before
    public void setUp() {
        checkoutSolution = new CheckoutSolution();
    }

    @Test
    public void should_return_default_value_for_invalid_input() {
        givenInputIs("AABCBD1A");
        whenICallCheckout();
        thenResultIs(-1);
    }

    @Test
    public void should_return_0_for_empty_string() {
        givenInputIs("");
        whenICallCheckout();
        thenResultIs(0);
    }

    @Test
    public void should_return_0_for_null_string() {
        givenInputIs(null);
        whenICallCheckout();
        thenResultIs(0);
    }

    @Test
    public void should_calculate_total_price_when_no_offers_are_present() {
        givenInputIs("ABCD");
    }

    private void givenInputIs(final String value) {
        skus = value;
    }

    private void whenICallCheckout() {
        result = checkoutSolution.checkout(skus);
    }

    private void thenResultIs(final int expectedValue) {
        assertEquals(expectedValue, result);
    }
}