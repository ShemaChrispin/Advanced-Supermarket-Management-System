public class ElectronicProduct extends InventoryManager {
    private int warrantyMonths;

    public ElectronicProduct() {
        super();
    }

    public ElectronicProduct(String productId, String productName, double price, int quantity, String category, 
                             String supplierName, String storageLocation, int warrantyMonths) {
        super(productId, productName, price, quantity, category, supplierName, storageLocation);
        this.warrantyMonths = warrantyMonths;
    }

    public int getWarrantyMonths() {
        return warrantyMonths;
    }

    public void setWarrantyMonths(int warrantyMonths) {
        this.warrantyMonths = warrantyMonths;
    }

    @Override
    public boolean validateProduct() {
        return super.validateProduct() && warrantyMonths >= 0;
    }

    @Override
    public void printReceipt() {
        super.printReceipt();
        System.out.println("Warranty: " + warrantyMonths + " months included.");
    }

    @Override
    public String getCategoryDescription() {
        return "Electronic devices and appliances with technical specifications.";
    }

    @Override
    public String toString() {
        return super.toString() + ", Warranty=" + warrantyMonths + " months";
    }
}
