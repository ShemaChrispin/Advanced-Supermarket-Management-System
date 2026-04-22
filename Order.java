public class Order {
    private String orderId;
    private Product product;
    private int quantityPurchased;
    private double totalPrice;

    public Order() {}

    public Order(String orderId, Product product, int quantityPurchased) {
        this.orderId = orderId;
        this.product = product;
        this.quantityPurchased = quantityPurchased;
        calculateTotalPrice();
    }

    public void calculateTotalPrice() {
        if (product instanceof Sellable) {
            this.totalPrice = ((Sellable) product).calculateFinalPrice() * quantityPurchased;
        } else {
            this.totalPrice = product.getPrice() * quantityPurchased;
        }
    }

    public String getOrderId() { return orderId; }
    public void setOrderId(String orderId) { this.orderId = orderId; }

    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }

    public int getQuantityPurchased() { return quantityPurchased; }
    public void setQuantityPurchased(int quantityPurchased) { 
        this.quantityPurchased = quantityPurchased; 
        calculateTotalPrice();
    }

    public double getTotalPrice() { return totalPrice; }

    @Override
    public String toString() {
        return String.format("Order [ID=%s, Product=%s, Qty=%d, Total=$%.2f]", 
            orderId, product.getProductName(), quantityPurchased, totalPrice);
    }
}
