public class InputValidator {

    public static boolean validateNotEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            System.err.println("Error: Input cannot be empty. Please try again.");
            return false;
        }
        return true;
    }

    public static boolean validateName(String name) {
        if (!validateNotEmpty(name)) return false;
        if (Character.isDigit(name.charAt(0))) {
            System.err.println("Error: Name cannot start with a number. Please try again.");
            return false;
        }
        if (name.length() < 2) {
            System.err.println("Error: Name is too short. Please enter at least 2 characters.");
            return false;
        }
        if (name.length() > 50) {
            System.err.println("Error: Name is too long. Please limit to 50 characters.");
            return false;
        }
        return true;
    }

    public static boolean validatePositive(double number) {
        if (number <= 0) {
            System.err.println("Error: Value must be greater than zero. Please try again.");
            return false;
        }
        if (number > 1000000) {
            System.err.println("Error: Value is suspiciously large (max $1,000,000). Please check.");
            return false;
        }
        return true;
    }

    public static boolean validateAlphaNumeric(String input) {
        if (!input.matches("^[a-zA-Z0-9- ]*$")) {
            System.err.println("Error: Input contains invalid characters. (Letters, numbers, spaces, and hyphens allowed).");
            return false;
        }
        return true;
    }

    public static boolean validateInteger(String input) {
        try {
            int value = Integer.parseInt(input);
            if (value < 0) {
                System.err.println("Error: Negative values are not allowed.");
                return false;
            }
            if (value > 10000) {
                System.err.println("Error: Value exceeds maximum allowed limit (10,000).");
                return false;
            }
            return true;
        } catch (NumberFormatException e) {
            System.err.println("Error: Invalid input. Please enter a valid whole number.");
            return false;
        }
    }

    public static boolean validateDouble(String input) {
        try {
            double value = Double.parseDouble(input);
            if (value < 0) {
                System.err.println("Error: Negative values are not allowed.");
                return false;
            }
            if (value > 1000000) {
                System.err.println("Error: Value exceeds maximum allowed limit.");
                return false;
            }
            return true;
        } catch (NumberFormatException e) {
            System.err.println("Error: Invalid input. Please enter a valid decimal number.");
            return false;
        }
    }

    public static boolean validatePhoneNumber(String phone) {
        if (!phone.matches("^\\+?[0-9]{10,15}$")) {
            System.err.println("Error: Invalid phone format. Use 10-15 digits (e.g., 0123456789).");
            return false;
        }
        return true;
    }

    public static boolean validateCustomerID(String id) {
        if (!id.matches("^[0-9]{4,8}$")) {
            System.err.println("Error: Customer ID must be between 4 and 8 digits.");
            return false;
        }
        return true;
    }

    public static boolean validateProductID(String id) {
        if (!id.matches("^[0-9]{4,8}$")) {
            System.err.println("Error: Product ID must be between 4 and 8 digits.");
            return false;
        }
        return true;
    }

    public static boolean validateCategory(String category) {
        String[] validCategories = {"food", "beverage", "electronics", "clothing", "cleaning", "personalcare"};
        for (String valid : validCategories) {
            if (valid.equalsIgnoreCase(category)) return true;
        }
        System.err.println("Error: Invalid category. Supported: Food, Beverage, Electronics, Clothing, Cleaning, PersonalCare.");
        return false;
    }

    public static boolean validateExtraAttribute(String category, String attr) {
        if (attr == null || attr.trim().isEmpty()) {
            System.err.println("Error: Specific attribute cannot be empty.");
            return false;
        }
        switch (category.toLowerCase()) {
            case "beverage":
                return validateDouble(attr); // Sugar content
            case "electronics":
                return validateInteger(attr); // Warranty period
            case "cleaning":
                return validateInteger(attr); // Concentration level
            default:
                return validateNotEmpty(attr); // Other categories are strings
        }
    }
}
