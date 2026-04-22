# Advanced Supermarket Management System

A robust, OOP-based inventory and sales management system for supermarkets. This project features a factory design pattern, inheritance, and comprehensive input validation to handle real-world user scenarios.

## 🚀 Key Features
- **Strict Validation:** Handles empty inputs, invalid formats, and data type mismatches.
- **Product Hierarchy:** Categorized products (Food, Beverage, Electronics, etc.) with specific attributes.
- **Inventory Management:** Automated stock updates and financial breakdowns (Tax/Discount).
- **Dockerized:** Ready for containerized deployment.

## 🛠️ How to Run

### Option 1: Using the JAR file (Requires Java 17+)
Download the `SupermarketSystem.jar` and run:
```bash
java -jar SupermarketSystem.jar
```

### Option 2: Using Docker (Requires Docker)
Build the image and run it in interactive mode:
```bash
# Build the image
docker build -t supermarket-system .

# Run the container (Interactive mode is required for input)
docker run -it supermarket-system
```

### Option 3: Manual Compilation
```bash
javac *.java
java SupermarketSystem
```

## 📂 Submission Details
- **Dockerfile:** Included for containerization.
- **JAR File:** `SupermarketSystem.jar` included as requested.
- **Developer:** Shema Chrispin
