package befaster.solutions.CHK;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class CheckoutSolutionTest {

    private static final Map<String, Integer> TEST_CASES = new HashMap<String, Integer>() {{
        put("AABCBD1A", -1);
        put("", 0);
        put(null, -1);
        put("  ", -1);
        put("ABCD", 115);
        put("ABACA", 180);
        put("DBBAC", 130);
        put("ABABDAC", 210);
        put("AAAAABAAAAA", 430);
        put("AAAAA", 200);
        put("AAAAAA", 250);
        put("AABABAA", 245);
        put("AAAAAAAA", 330);
        put("EEA", 130);
        put("EEB", 80);
        put("EEBB", 110);
        put("EBEEBE", 160);
        put("AAAEEAA", 280);
        put("AAACEAA", 260);
        put("EEEB", 120);
        put("ABCDECBAABCABBAAAEEAA", 665);
        put("FFF", 20);
        put("FF", 20);
        put("FFFEEB", 100);
    }};

    private CheckoutSolution checkoutSolution;

    @Before
    public void setUp() {
        checkoutSolution = new CheckoutSolution();
    }

    @Test
    public void should_combine_all_promotions_on_the_same_item_if_enough_qty() {
        TEST_CASES.forEach((skus, expectedTotal) -> assertEquals(expectedTotal, checkoutSolution.checkout(skus)));
    }
}
