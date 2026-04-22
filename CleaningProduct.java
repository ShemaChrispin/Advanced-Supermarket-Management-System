public class CleaningProduct extends InventoryManager {
    private int chemicalStrength;

    public CleaningProduct() {
        super();
    }

    public CleaningProduct(String productId, String productName, double price, int quantity, String category, 
                           String supplierName, String storageLocation, int chemicalStrength) {
        super(productId, productName, price, quantity, category, supplierName, storageLocation);
        this.chemicalStrength = chemicalStrength;
    }

    public int getChemicalStrength() {
        return chemicalStrength;
    }

    public void setChemicalStrength(int chemicalStrength) {
        this.chemicalStrength = chemicalStrength;
    }

    @Override
    public double applyTax() {
        return super.applyTax() + (chemicalStrength > 7 ? 5.00 : 0.0);
    }

    @Override
    public boolean validateProduct() {
        return super.validateProduct() && chemicalStrength >= 1 && chemicalStrength <= 10;
    }

    @Override
    public String getCategoryDescription() {
        return "Household cleaning supplies and detergents.";
    }

    @Override
    public String toString() {
        return super.toString() + ", ChemicalStrength=" + chemicalStrength;
    }
}
