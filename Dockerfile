FROM maven:3.9.6-amazoncorretto-17 AS build
COPY /src /src
COPY pom.xml /
RUN mvn -f /pom.xml clean package

#FROM openjdk:17-jdk-slim
FROM amazoncorretto:17-alpine-jdk
COPY --from=build /target/*.jar app.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "app.jar"]

# docker image build . -t therealvvd/rest-service:latest