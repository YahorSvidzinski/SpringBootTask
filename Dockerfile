FROM maven:3.6.0-jdk-11
COPY pom.xml .
COPY . .
RUN mvn install
FROM openjdk:11-jdk
COPY target/spring-app-0.0.1.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]



