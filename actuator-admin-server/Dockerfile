FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY target/actuator-admin-server.jar /app/actuator-admin-server.jar
ENTRYPOINT ["java", "-jar", "/app/actuator-admin-server.jar"]
EXPOSE 9090