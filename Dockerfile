FROM maven:3.8.3-openjdk-17 AS build

COPY src /app/src
COPY pom.xml /app

WORKDIR /app

RUN mvn clean install -DskipTests

FROM openjdk:17-jdk

COPY --from=build /app/target/projetowebservice-0.0.1-SNAPSHOT.jar /app/app.jar

WORKDIR /app

EXPOSE 8090

CMD ["java","-jar","app.jar"]