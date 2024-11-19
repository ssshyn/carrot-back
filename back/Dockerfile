FROM amazoncorretto:17

ENTRYPOINT java -jar /deploy/back-0.0.1-SNAPSHOT.jar

EXPOSE 8080

# FROM gradle:alpine AS builder
# WORKDIR /build
#
# COPY ./build.gradle .
# COPY ./settings.gradle .
# COPY ./src ./src
# RUN gradle clean bootJar
#
# FROM amazoncorretto:17
# ARG JAR_FILE=build/libs/back-0.0.1-SNAPSHOT.jar
# ADD ${JAR_FILE} back.jar
# ENTRYPOINT ["java", "-jar", "/back.jar"]