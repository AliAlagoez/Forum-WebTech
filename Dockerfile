FROM gradle:8-jdk21 as builder
WORKDIR /
COPY . ./
RUN gradle build

FROM openJDK:21-slim
LABEL authors="ali.alagoez"
COPY --from=builder /build/libs .
ENTRYPOINT ["java", "-jar", "/backend-0.0.1-SNAPSHOT.jar"]
