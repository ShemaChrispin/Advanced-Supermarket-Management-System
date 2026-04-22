# Advanced Supermarket Management System

A robust, OOP-based inventory and sales management system for supermarkets. This project features a factory design pattern, inheritance, and comprehensive input validation to handle real-world user scenarios.

## 🚀 Key Features
- **Strict Validation:** Handles empty inputs, invalid formats, and data type mismatches.
- **Product Hierarchy:** Categorized products (Food, Beverage, Electronics, etc.) with specific attributes.
- **Inventory Management:** Automated stock updates and financial breakdowns (Tax/Discount).
- **Dockerized:** Ready for containerized deployment.

## 🛠️ How to Run

### Option 1: The Manual Way (Standard Java)
If you have Java installed locally, you can run the pre-built JAR file:
1. Download the project ZIP and extract it.
2. Open a terminal in the folder and run:
```bash
java -jar SupermarketSystem.jar
```

### Option 2: The Docker Way (Professional)
Run the system in a container without needing to install Java locally (requires Docker Desktop):
1. Build the Image:
```bash
docker build -t supermarket-app .
```
2. Run the Container (The `-it` flag is required for interactive input):
```bash
docker run -it supermarket-app
```

### Option 3: GitHub Codespaces (Run in Browser)
Run the project directly in your browser without downloading anything:
1. On this GitHub repository page, click the green **Code** button.
2. Select the **Codespaces** tab.
3. Click **Create codespace on main**.
4. Once the environment loads, type the following in the terminal at the bottom:
```bash
java -jar SupermarketSystem.jar
```

## 📂 Submission Details
- **Dockerfile:** Included for containerization.
- **JAR File:** `SupermarketSystem.jar` included as requested.
- **Developer:** Shema Chrispin
