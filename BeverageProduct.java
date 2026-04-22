public class BeverageProduct extends InventoryManager {
    private double sugarContent;

    public BeverageProduct() {
        super();
    }

    public BeverageProduct(String productId, String productName, double price, int quantity, String category, 
                           String supplierName, String storageLocation, double sugarContent) {
        super(productId, productName, price, quantity, category, supplierName, storageLocation);
        this.sugarContent = sugarContent;
    }

    public double getSugarContent() {
        return sugarContent;
    }

    public void setSugarContent(double sugarContent) {
        this.sugarContent = sugarContent;
    }

    @Override
    public double applyTax() {
        return super.applyTax() + (getPrice() * 0.05);
    }

    @Override
    public void processSale(int quantity) {
        System.out.println("Selling " + quantity + " beverages: " + getProductName() + " (Sugar: " + sugarContent + "g)");
        super.processSale(quantity);
    }

    @Override
    public String getCategoryDescription() {
        return "Liquid refreshments including sodas, juices, and water.";
    }

    @Override
    public String toString() {
        return super.toString() + ", SugarContent=" + sugarContent + "g";
    }
}
