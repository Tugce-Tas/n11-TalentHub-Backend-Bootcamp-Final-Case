FROM maven:3-amazoncorretto-21 as build
WORKDIR /usr/src/app
COPY . .
RUN mvn clean package -DskipTests

FROM amazoncorretto:21-alpine3.16-jdk
EXPOSE 8080
COPY --from=build /usr/src/app/target/logger-0.0.1-SNAPSHOT.jar /app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]