public class FoodProduct extends InventoryManager {
    private String expiryDate;

    public FoodProduct() {
        super();
    }

    public FoodProduct(String productId, String productName, double price, int quantity, String category, 
                       String supplierName, String storageLocation, String expiryDate) {
        super(productId, productName, price, quantity, category, supplierName, storageLocation);
        this.expiryDate = expiryDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.20;
    }

    @Override
    public void generateReport() {
        System.out.println("--- Food Product Report ---");
        super.generateReport();
        System.out.println("Expiry Date: " + expiryDate);
    }

    @Override
    public String getCategoryDescription() {
        return "Perishable food items requiring freshness monitoring.";
    }

    @Override
    public String toString() {
        return super.toString() + ", ExpiryDate=" + expiryDate;
    }
}
