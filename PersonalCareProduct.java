public class PersonalCareProduct extends InventoryManager {
    private String skinType;

    public PersonalCareProduct() {
        super();
    }

    public PersonalCareProduct(String productId, String productName, double price, int quantity, String category, 
                               String supplierName, String storageLocation, String skinType) {
        super(productId, productName, price, quantity, category, supplierName, storageLocation);
        this.skinType = skinType;
    }

    public String getSkinType() {
        return skinType;
    }

    public void setSkinType(String skinType) {
        this.skinType = skinType;
    }

    @Override
    public void generateReport() {
        System.out.println("--- Personal Care Product Report ---");
        super.generateReport();
        System.out.println("Recommended Skin Type: " + skinType);
    }

    @Override
    public double calculateTotalValue() {
        return (getPrice() * getQuantity()) * 1.02;
    }

    @Override
    public String getCategoryDescription() {
        return "Health and beauty products for personal hygiene.";
    }

    @Override
    public String toString() {
        return super.toString() + ", SkinType=" + skinType;
    }
}
