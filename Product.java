public abstract class Product {
    private String productId;
    private String productName;
    private double price;
    private int quantity;
    private String category;

    public Product() {
    }

    public Product(String productId, String productName, double price, int quantity, String category) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return String.format(
            "Product [ID=%s, Name=%s, Price=%.2f, Quantity=%d, Category=%s]",
            productId, productName, price, quantity, category
        );
    }

    public abstract double calculateDiscount();

    public abstract double applyTax();

    public abstract boolean checkAvailability();

    public abstract double calculateTotalValue();

    public abstract void updateStock(int amount);

    public abstract boolean validateProduct();

    public abstract void generateReport();

    public abstract String getCategoryDescription();
}
