FROM maven:3.9.11-eclipse-temurin-25-alpine AS build

WORKDIR /workspace
COPY pom.xml .
RUN mvn -B dependency:go-offline
COPY src ./src
RUN mvn -B package -DskipTests

FROM eclipse-temurin:25-jre-alpine

RUN addgroup -S -g 10001 spring \
    && adduser -S -u 10001 -G spring spring
WORKDIR /app
COPY --from=build --chown=spring:spring /workspace/target/*.jar app.jar
USER spring
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]