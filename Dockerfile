# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container
COPY SupermarketSystem.jar /app/SupermarketSystem.jar

# Run the JAR file
ENTRYPOINT ["java", "-jar", "SupermarketSystem.jar"]
