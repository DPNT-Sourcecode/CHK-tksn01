package befaster.solutions.CHK.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BasketTest {

    private Basket basket;

    @Before
    public void setUp() {
        basket = new Basket();
    }

    @Test
    public void shouldCreateEmptyBasketOnConstructor() {
        assertEquals(0, basket.getItems().size());
    }

    @Test
    public void shouldAddAnItem() {
        basket.addItem(Item.A);
        assertEquals(1, basket.getItems().size());
        assertEquals(1, basket.getItems().get(Item.A).intValue());
    }
}