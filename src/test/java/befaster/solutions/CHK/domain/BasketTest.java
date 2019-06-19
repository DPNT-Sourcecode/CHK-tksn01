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
        basket.addItem(Item.A);
        assertEquals(1, basket.getItems().size());
        assertEquals(2, basket.getItems().get(Item.A).intValue());
    }

    @Test
    public void shouldRemoveAnItem() {
        basket.addItem(Item.A);
        basket.addItem(Item.A);
        basket.addItem(Item.B);
        assertEquals(2, basket.getItems().size());

        basket.remove(Item.A, 1);
        basket.remove(Item.B, 1);
        assertEquals(1, basket.getItems().size());
        assertEquals(1, basket.getItems().get(Item.A).intValue());
        assertFalse(basket.getItems().containsKey(Item.B));
    }
}