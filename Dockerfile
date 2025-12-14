FROM maven:3.9.9-eclipse-temurin-21 AS build
LABEL authors="Ritmo"

WORKDIR /app
COPY pom.xml .
COPY src ./src

RUN mvn -B clean package -DskipTests

# -------- Runtime stage --------
FROM eclipse-temurin:21-jre

WORKDIR /app
# Copy the built JAR from the previous stage
COPY --from=build /app/target/*.jar app.jar

ENTRYPOINT ["java","-jar","app.jar"]