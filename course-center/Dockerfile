FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY target/course-center.jar /app/course-center.jar
ENTRYPOINT ["java", "-jar", "/app/course-center.jar"]
EXPOSE 8761