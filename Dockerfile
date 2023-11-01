FROM maven:3.8.5-openjdk-17

WORKDIR /spring-boot-app-with-postgres
COPY . .
RUN mvn clean install -DskipTests

CMD mvn spring-boot:run