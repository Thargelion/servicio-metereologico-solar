FROM maven:3.5.2-jdk-8-alpine as build
MAINTAINER Maximiliano De Pietro <maximiliano.depietro@gmail.com>
WORKDIR /pronosticos
ADD pom.xml /pronosticos/pom.xml
RUN ["mvn", "dependency:resolve"]
RUN ["mvn", "verify"]
ADD src /pronosticos/src
RUN ["mvn", "install"]
RUN ["mvn", "package"]
RUN ["ls", "/pronosticos/target"]

FROM openjdk:8-jre-alpine
WORKDIR /app
COPY --from=build /pronosticos/target/pronosticos-1.0-SNAPSHOT.jar /app
EXPOSE 4567
CMD ["java", "-Dport=4567", "-jar", "pronosticos-1.0-SNAPSHOT.jar"]