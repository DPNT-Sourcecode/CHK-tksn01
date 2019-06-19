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
    public void should_return_default_value_for_empty_string() {
        givenInputIs("");
        whenICallCheckout();
        thenResultIs(0);
    }

    @Test
    public void should_return_default_value_for_null_string() {
        givenInputIs(null);
        whenICallCheckout();
        thenResultIs(-1);
    }

    @Test
    public void should_return_default_value_for_blank_string() {
        givenInputIs("  ");
        whenICallCheckout();
        thenResultIs(-1);
    }

    @Test
    public void should_calculate_total_price_when_no_offers_are_present() {
        givenInputIs("ABCD");
        whenICallCheckout();
        thenResultIs(115);
    }

    @Test
    public void should_calculate_total_price_and_apply_promotion_1() {
        givenInputIs("ABACA");
        whenICallCheckout();
        thenResultIs(180);
    }

    @Test
    public void should_calculate_total_price_and_apply_promotion_2() {
        givenInputIs("DBBAC");
        whenICallCheckout();
        thenResultIs(130);
    }

    @Test
    public void should_calculate_total_price_and_apply_both_promotions() {
        givenInputIs("ABABDAC");
        whenICallCheckout();
        thenResultIs(210);
    }

    @Test
    public void should_apply_a_promotion_multiple_times_if_necessary() {
        givenInputIs("AAAAABAAAAA");
        whenICallCheckout();
        thenResultIs(430);
    }

    @Test
    public void should_apply_correct_offer_if_multiple_offers_for_same_item() {
        givenInputIs("AAAAA");
        whenICallCheckout();
        thenResultIs(200);

        givenInputIs("AAAAAAAA");
        whenICallCheckout();
        thenResultIs(250);
    }

    @Test
    public void should_combine_best_offers_for_items() {
        givenInputIs("AABABAA");
        whenICallCheckout();
        thenResultIs(245);
    }

    @Test
    public void should_combine_all_promotions_on_the_same_item_if_enough_qty() {
        givenInputIs("AAAAAAAA");
        whenICallCheckout();
        thenResultIs(330);
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
