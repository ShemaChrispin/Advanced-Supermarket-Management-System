public class ClothingProduct extends InventoryManager {
    private String size;

    public ClothingProduct() {
        super();
    }

    public ClothingProduct(String productId, String productName, double price, int quantity, String category, 
                           String supplierName, String storageLocation, String size) {
        super(productId, productName, price, quantity, category, supplierName, storageLocation);
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.15;
    }

    @Override
    public void processSale(int quantity) {
        System.out.println("Processing clothing sale for " + quantity + " items. Size: " + size);
        super.processSale(quantity);
    }

    @Override
    public String getCategoryDescription() {
        return "Apparel and garments of various sizes and materials.";
    }

    @Override
    public String toString() {
        return super.toString() + ", Size=" + size;
    }
}
