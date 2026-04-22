import java.util.Scanner;

public class SupermarketSystem {
    // ANSI Color Codes
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_PURPLE = "\u001B[35m";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(ANSI_CYAN + "===========================================================" + ANSI_RESET);
        System.out.println(ANSI_CYAN + "   ADVANCED SUPERMARKET MANAGEMENT SYSTEM  " + ANSI_RESET);
        System.out.println(ANSI_CYAN + "===========================================================" + ANSI_RESET);

        System.out.println("\n" + ANSI_YELLOW + "[STEP 1: CUSTOMER REGISTRATION]" + ANSI_RESET);
        String customerId, customerName, phoneNumber;
        
        while (true) {
            System.out.print("Enter Customer ID (Numbers only): ");
            customerId = scanner.nextLine();
            if (InputValidator.validateCustomerID(customerId)) break;
        }
        
        while (true) {
            System.out.print("Enter Customer Name: ");
            customerName = scanner.nextLine();
            if (InputValidator.validateName(customerName)) break;
        }
        
        while (true) {
            System.out.print("Enter Phone Number (10-15 digits): ");
            phoneNumber = scanner.nextLine();
            if (InputValidator.validateNotEmpty(phoneNumber) && InputValidator.validatePhoneNumber(phoneNumber)) break;
        }
        
        Customer customer = new Customer(customerId, customerName, phoneNumber);

        System.out.println("\n" + ANSI_YELLOW + "[STEP 2: PRODUCT INVENTORY ENTRY]" + ANSI_RESET);
        String category, productId, productName, supplier, location, extraAttr;
        double price = 0;
        int quantity = 0;

        while (true) {
            System.out.print("Enter Category (Food, Beverage, Electronics, Clothing, Cleaning, PersonalCare): ");
            category = scanner.nextLine();
            if (InputValidator.validateCategory(category)) break;
        }

        while (true) {
            System.out.print("Enter Product ID (4-8 digits): ");
            productId = scanner.nextLine();
            if (InputValidator.validateProductID(productId)) {
                if (productId.equals(customerId)) {
                    System.err.println("Error: Duplicate ID detected. Product ID cannot be the same as Customer ID.");
                } else {
                    break;
                }
            }
        }

        while (true) {
            System.out.print("Enter Product Name: ");
            productName = scanner.nextLine();
            if (InputValidator.validateName(productName)) break;
        }

        while (true) {
            System.out.print("Enter Price (e.g., 10.99): ");
            String priceInput = scanner.nextLine();
            if (InputValidator.validateDouble(priceInput)) {
                price = Double.parseDouble(priceInput);
                if (InputValidator.validatePositive(price)) break;
            }
        }

        while (true) {
            System.out.print("Enter Initial Stock Quantity: ");
            String qtyInput = scanner.nextLine();
            if (InputValidator.validateInteger(qtyInput)) {
                quantity = Integer.parseInt(qtyInput);
                if (quantity > 0) break;
                else System.err.println("Error: Stock must be greater than zero.");
            }
        }

        while (true) {
            System.out.print("Enter Supplier Name: ");
            supplier = scanner.nextLine();
            if (InputValidator.validateName(supplier)) break;
        }

        while (true) {
            System.out.print("Enter Storage Location: ");
            location = scanner.nextLine();
            if (InputValidator.validateNotEmpty(location)) break;
        }

        while (true) {
            System.out.print("Enter " + category + " Specific Attribute (Expiry, Sugar, Warranty, etc.): ");
            extraAttr = scanner.nextLine();
            if (InputValidator.validateExtraAttribute(category, extraAttr)) break;
        }

        Product product = null;
        try {
            product = ProductFactory.createProduct(category, productId, productName, price, quantity, supplier, location, extraAttr);
        } catch (Exception e) {
            System.err.println("CRITICAL ERROR: Failed to create product. " + e.getMessage());
            return;
        }

        System.out.println("\n" + ANSI_YELLOW + "[STEP 3: TRANSACTION]" + ANSI_RESET);
        int orderQty = 0;
        while (true) {
            System.out.print("Enter Quantity to Purchase: ");
            String orderQtyInput = scanner.nextLine();
            if (InputValidator.validateInteger(orderQtyInput)) {
                orderQty = Integer.parseInt(orderQtyInput);
                if (orderQty > 0 && orderQty <= product.getQuantity()) break;
                else if (orderQty > product.getQuantity()) {
                    System.err.println(ANSI_RED + "Error: Insufficient stock! Available: " + product.getQuantity() + ANSI_RESET);
                } else {
                    System.err.println(ANSI_RED + "Error: Order quantity must be positive." + ANSI_RESET);
                }
            }
        }

        if (product instanceof Sellable) {
            ((Sellable) product).processSale(orderQty);
        } else {
            product.updateStock(-orderQty);
        }

        Order order = new Order("ORD-001", product, orderQty);

        System.out.println("\n" + ANSI_GREEN + "=".repeat(50));
        System.out.println("                 OFFICIAL SALES RECEIPT");
        System.out.println("=".repeat(50) + ANSI_RESET);
        System.out.println(ANSI_PURPLE + "CUSTOMER:" + ANSI_RESET);
        System.out.println("  " + customer.toString());
        
        System.out.println("\n" + ANSI_PURPLE + "PRODUCT DATA:" + ANSI_RESET);
        product.generateReport();
        
        System.out.println("\n" + ANSI_PURPLE + "TRANSACTION SUMMARY:" + ANSI_RESET);
        System.out.println("  " + order.toString());
        
        if (product instanceof Sellable) {
            System.out.println("\n" + ANSI_PURPLE + "FINANCIAL BREAKDOWN:" + ANSI_RESET);
            ((Sellable) product).printReceipt();
        }
        System.out.println(ANSI_GREEN + "=".repeat(50));
        System.out.println("      Thank you for shopping at our Supermarket!");
        System.out.println("=".repeat(50) + ANSI_RESET);

        scanner.close();
    }
}
