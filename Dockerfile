FROM eclipse-temurin:21-jdk-jammy

WORKDIR /app

COPY target/week9-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 3000

ENTRYPOINT ["java","-jar","app.jar"]
