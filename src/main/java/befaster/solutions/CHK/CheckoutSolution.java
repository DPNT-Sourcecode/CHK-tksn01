package befaster.solutions.CHK;

import befaster.solutions.CHK.domain.Basket;
import befaster.solutions.CHK.exception.InvalidSkuException;
import befaster.solutions.CHK.factory.BasketFactory;
import befaster.solutions.CHK.service.CheckoutService;

public class CheckoutSolution {

    private final BasketFactory basketFactory = new BasketFactory();
    private final CheckoutService checkoutService = new CheckoutService();

    public Integer checkout(String skus) {
        if (skus == null) {
            return -1;
        }

        final Basket basket;
        try {
            basket = basketFactory.createBasket(skus);
        } catch (final InvalidSkuException ignored) {
            return -1;
        }


        return checkoutService.calculateTotal(basket);
    }
}
