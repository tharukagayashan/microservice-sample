FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY target/service-registry.jar /app/service-registry.jar
ENTRYPOINT ["java", "-jar", "/app/service-registry.jar"]
EXPOSE 8761