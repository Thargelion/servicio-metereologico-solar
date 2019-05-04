FROM maven:3.5.2-jdk-8-alpine as build
ARG MONGO_DATABASE
ARG MONGO_USER
ARG MONGO_SRV
ARG MONGO_PASSWORD
ENV MONGO_DATABASE ${MONGO_DATABASE}
ENV MONGO_USER ${MONGO_USER}
ENV MONGO_SRV ${MONGO_SRV}
ENV MONGO_PASSWORD ${MONGO_PASSWORD}
MAINTAINER Maximiliano De Pietro <maximiliano.depietro@gmail.com>
WORKDIR /pronosticos
ADD pom.xml /pronosticos/pom.xml
RUN echo $MONGO_SRV
RUN echo $MONGO_USER
RUN echo $MONGO_PASSWORD
RUN echo $MONGO_DATABASE
RUN ["mvn", "verify", "clean"]
ADD src /pronosticos/src
RUN ["mvn", "package"]
FROM openjdk:8-jre-alpine
WORKDIR /app
COPY --from=build /pronosticos/target/pronosticos-1.0-SNAPSHOT.jar /app
EXPOSE 4567
CMD ["java", "-Dport=4567", "-jar", "pronosticos-1.0-SNAPSHOT.jar"]