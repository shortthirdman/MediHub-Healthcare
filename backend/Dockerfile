FROM eclipse-temurin:21.0.3_9-jre-alpine

LABEL authors="ShortThirdMan"

WORKDIR /app

# Copy the built JAR file from the previous stage
COPY ./target/medihub-service-1.0-SNAPSHOT.jar ./medihub-service.jar

# Expose the port the application runs on
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "medihub-service.jar"]
