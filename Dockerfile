
FROM openjdk:11-jre-stretch
COPY target/demo-1.0.2.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]

