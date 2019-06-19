package befaster.solutions.CHK.factory;

import befaster.solutions.CHK.domain.Basket;
import befaster.solutions.CHK.domain.Item;
import befaster.solutions.CHK.exception.InvalidSkuException;

import java.util.stream.IntStream;

public final class BasketFactory {

    public Basket createBasket(final String skus) throws InvalidSkuException {
        final Basket basket = new Basket();
        try {
            IntStream.range(0, skus.length()).mapToObj(index -> Item.valueOf(String.valueOf(skus.charAt(index)))).forEach(basket::addItem);
        } catch (final Exception e) {
            throw new InvalidSkuException();
        }
        return basket;
    }
}

