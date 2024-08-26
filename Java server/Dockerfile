FROM eclipse-temurin:17-jdk-alpine
LABEL authors="ETU1084_1163_1187"
VOLUME /tmp
COPY target/xchange-0.0.1-SNAPSHOT.jar xchange-server.jar
ENTRYPOINT ["java","-jar","/xchange-server.jar"]
