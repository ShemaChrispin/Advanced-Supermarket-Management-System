public interface Sellable {
    void processSale(int quantity);
    double calculateFinalPrice();
    void printReceipt();
}
