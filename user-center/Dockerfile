FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY target/user-center.jar /app/user-center.jar
ENTRYPOINT ["java", "-jar", "/app/user-center.jar"]
EXPOSE 8761