package befaster.solutions.CHK.domain;

public enum Item {
    A("A", 50),
    B("B", 30),
    C("C", 20),
    D("D", 15),
    E("E", 40);

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
