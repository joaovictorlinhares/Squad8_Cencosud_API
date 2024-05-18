FROM ubuntu:22.04 AS build

RUN apt update
RUN apt install -y openjdk-21-jdk maven

WORKDIR /app

COPY . .

RUN mvn clean install

FROM openjdk:21-slim

EXPOSE 8080

COPY --from=build /target/api-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]