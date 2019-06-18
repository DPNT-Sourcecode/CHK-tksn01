package befaster.solutions.CHK.domain;

public enum Item {
    A("A", );

    private final String sku;
    private final int price;

    Item(final String sku, final int price) {
        this.sku = sku;
        this.price = price;
    }

    public String getSku() {
        return sku;
    }

    public int getPrice() {
        return price;
    }
}
