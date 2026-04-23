# Use an official Eclipse Temurin runtime as a parent image
FROM eclipse-temurin:17-jdk

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container
COPY SupermarketSystem.jar /app/SupermarketSystem.jar

# Run the JAR file
ENTRYPOINT ["java", "-jar", "SupermarketSystem.jar"]
