# Build the app with Maven
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copy pom.xml first 
COPY src/pom.xml .

# Download dependencies
RUN mvn dependency:go-offline -B

# Copy the full source code
COPY src ./src

# Build the JAR
WORKDIR /app/src
RUN mvn clean package -DskipTests

# Run the app
FROM eclipse-temurin:17-jdk
WORKDIR /app

# Copy built jar 
COPY --from=build /app/src/target/*.jar app.jar

# Expose Spring Boot default port
EXPOSE 8080

# Run the JAR
ENTRYPOINT ["java", "-jar", "app.jar"]

