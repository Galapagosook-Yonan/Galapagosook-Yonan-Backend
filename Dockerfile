# Use adoptopenjdk for base image
FROM openjdk:17-jdk

# Set working directory
WORKDIR /app

# Copy the JAR file
COPY build/libs/Galapagosook-Yonan-0.0.1-SNAPSHOT.jar app.war

EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.war"]