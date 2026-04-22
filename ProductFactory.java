public class ProductFactory {
    public static Product createProduct(String category, String id, String name, double price, int qty, 
                                        String supplier, String location, String extraAttr) {
        
        switch (category.toLowerCase()) {
            case "food":
                return new FoodProduct(id, name, price, qty, category, supplier, location, extraAttr);
            case "beverage":
                return new BeverageProduct(id, name, price, qty, category, supplier, location, Double.parseDouble(extraAttr));
            case "electronics":
                return new ElectronicProduct(id, name, price, qty, category, supplier, location, Integer.parseInt(extraAttr));
            case "clothing":
                return new ClothingProduct(id, name, price, qty, category, supplier, location, extraAttr);
            case "cleaning":
                return new CleaningProduct(id, name, price, qty, category, supplier, location, Integer.parseInt(extraAttr));
            case "personalcare":
                return new PersonalCareProduct(id, name, price, qty, category, supplier, location, extraAttr);
            default:
                throw new IllegalArgumentException("Unknown category: " + category);
        }
    }
}
