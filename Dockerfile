FROM maven:3.9.11-eclipse-temurin-25-alpine

WORKDIR /spring-boot-app-with-postgres
COPY . .
RUN mvn clean install -DskipTests

CMD mvn spring-boot:run