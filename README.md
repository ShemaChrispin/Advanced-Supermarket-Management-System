## Features
- **Modern CLI UI:** Color-coded menus and receipts for better readability.
- **Robust Validation:** Ensures correct data entry for IDs, prices, and quantities.
- **Dockerized:** Easy deployment using containers.
- **Windows Optimized:** Includes `run.bat` for easy launching.

## Project Structure
- `src/`: Java source files.
- `SupermarketSystem.jar`: Compiled executable JAR file.
- `Dockerfile`: Configuration for containerizing the application.

## How to Run (Local JAR)
Ensure you have Java 17 or later installed.
- **Windows:** Double-click `run.bat` or run `java -jar SupermarketSystem.jar` in terminal.
- **Other OS:** Run `java -jar SupermarketSystem.jar` in terminal.

## How to Build and Run (Docker)
1. **Build the Docker image:**
   ```bash
   docker build -t supermarket-system .
   ```
2. **Run the container interactively:**
   ```bash
   docker run -it supermarket-system
   ```

## Pushing to GitHub
1. **Initialize Git repository:**
   ```bash
   git init
   ```
2. **Add files:**
   ```bash
   git add .
   ```
3. **Commit changes:**
   ```bash
   git commit -m "Initial commit: Add project source, JAR, and Dockerfile"
   ```
4. **Link to your GitHub repository:**
   ```bash
   git remote add origin https://github.com/YOUR_USERNAME/YOUR_REPO_NAME.git
   ```
5. **Push to GitHub:**
   ```bash
   git push -u origin main
   ```
