FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY target/notification-center.jar /app/notification-center.jar
ENTRYPOINT ["java", "-jar", "/app/notification-center.jar"]
EXPOSE 8761