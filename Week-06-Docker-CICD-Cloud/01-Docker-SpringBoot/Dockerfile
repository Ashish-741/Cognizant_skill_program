# Stage 1: Build the application using Maven
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
# Compile and package the application, skipping tests for faster build
RUN mvn clean package -DskipTests

# Stage 2: Create the minimal runtime image using JRE
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
# Copy only the compiled fat JAR from the build stage
COPY --from=build /app/target/docker-springboot-0.0.1-SNAPSHOT.jar app.jar
# Expose the default Spring Boot port
EXPOSE 8080
# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
