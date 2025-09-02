FROM gradle:8.14 AS builder

WORKDIR /app
COPY build.gradle.kts settings.gradle.kts ./
COPY gradle ./gradle
COPY . .

RUN gradle :adapters:build --no-daemon -x test

FROM amazoncorretto:21

WORKDIR /app
COPY --from=builder /app/adapters/build/libs/*.jar app.jar
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]