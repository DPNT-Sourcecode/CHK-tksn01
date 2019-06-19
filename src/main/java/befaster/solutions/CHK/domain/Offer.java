package befaster.solutions.CHK.domain;

public interface Offer {

    boolean supports(Basket basket);

    int applyTo(Basket basket);
}
