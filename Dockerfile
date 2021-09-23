#
# Build stage
#
FROM maven:3.8.2-jdk-11-slim AS build
COPY target/*.jar /home/target/app.jar
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

#
# Package stage
#
FROM openjdk:11-jre-slim
COPY --from=build /home/target/app.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]