FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY target/payment-center.jar /app/payment-center.jar
ENTRYPOINT ["java", "-jar", "/app/payment-center.jar"]
EXPOSE 8761