# --------------------
# Stage 1: Build the application
# --------------------
# Use a Maven image with JDK 21 as the build environment.
# This image contains all the tools needed to build your project.
FROM maven:3.9.11-eclipse-temurin-21-alpine AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven project file (pom.xml) first. This allows Docker to cache the dependencies
# so they are not re-downloaded if only source code changes.
COPY pom.xml .

# Copy the source code.
COPY src ./src

# Build the application. The `install` goal builds the JAR and puts it in the `target` directory.
# We use `-DskipTests` to keep the build time and final image size down, as tests
# should ideally be run in a separate CI stage.
RUN mvn clean install -DskipTests

# --------------------
# Stage 2: Create the final, lightweight image
# --------------------
# Use a lean JRE image to run the application. This image is much smaller as it
# doesn't contain build tools like Maven.
FROM eclipse-temurin:21-jre-alpine

# Set the working directory for the final image
WORKDIR /app

# Copy the JAR file from the `build` stage into this new image.
# The JAR file name is based on your pom.xml's artifactId and version.
# `first-0.0.1-SNAPSHOT.jar`
COPY --from=build /app/target/gateway-0.0.1-SNAPSHOT.jar ./app.jar

# Expose the port that your Spring Boot application runs on.
EXPOSE 8080

# Define the command to run the application when the container starts.
ENTRYPOINT ["java", "-jar", "app.jar"]
