FROM maven:3.6.0-jdk-11
COPY . .
RUN mvn package
FROM openjdk:11-jre-stretch
COPY target/spring-app-0.0.1.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]

