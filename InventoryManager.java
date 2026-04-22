public class InventoryManager extends Product implements Sellable {
    private String supplierName;
    private String storageLocation;

    public InventoryManager() {
        super();
    }

    public InventoryManager(String productId, String productName, double price, int quantity, String category, 
                            String supplierName, String storageLocation) {
        super(productId, productName, price, quantity, category);
        this.supplierName = supplierName;
        this.storageLocation = storageLocation;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getStorageLocation() {
        return storageLocation;
    }

    public void setStorageLocation(String storageLocation) {
        this.storageLocation = storageLocation;
    }

    @Override
    public double calculateDiscount() {
        return getQuantity() > 50 ? getPrice() * 0.10 : 0.0;
    }

    @Override
    public double applyTax() {
        return getPrice() * 0.15;
    }

    @Override
    public boolean checkAvailability() {
        return getQuantity() > 0;
    }

    @Override
    public double calculateTotalValue() {
        return getPrice() * getQuantity();
    }

    @Override
    public void updateStock(int amount) {
        setQuantity(getQuantity() + amount);
        System.out.println("Stock updated. New quantity: " + getQuantity());
    }

    @Override
    public boolean validateProduct() {
        return getPrice() > 0 && getQuantity() >= 0 && getProductId() != null;
    }

    @Override
    public void generateReport() {
        System.out.println("--- Product Report ---");
        System.out.println(this.toString());
        System.out.println("Supplier: " + supplierName);
        System.out.println("Storage: " + storageLocation);
        System.out.println("Total Inventory Value: $" + calculateTotalValue());
        System.out.println("----------------------");
    }

    @Override
    public String getCategoryDescription() {
        return "Category: " + getCategory() + " - Managed by Inventory System";
    }

    @Override
    public void processSale(int quantity) {
        if (getQuantity() >= quantity) {
            setQuantity(getQuantity() - quantity);
            System.out.println("Successfully processed sale for " + quantity + " units of " + getProductName());
        } else {
            System.out.println("Error: Insufficient stock for " + getProductName());
        }
    }

    @Override
    public double calculateFinalPrice() {
        return getPrice() - calculateDiscount() + applyTax();
    }

    @Override
    public void printReceipt() {
        System.out.println("********** RECEIPT **********");
        System.out.println("Item: " + getProductName());
        System.out.println("Base Price: $" + getPrice());
        System.out.println("Discount: -$" + calculateDiscount());
        System.out.println("Tax: +$" + applyTax());
        System.out.println("Final Total: $" + calculateFinalPrice());
        System.out.println("*****************************");
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Supplier=%s, Location=%s", supplierName, storageLocation);
    }
}
