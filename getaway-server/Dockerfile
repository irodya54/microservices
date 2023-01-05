FROM openjdk:8
WORKDIR /server
COPY ./target/getaway-server-0.0.1-SNAPSHOT.jar /server/micro-getaway.jar
EXPOSE 8080
CMD ["java", "-jar", "micro-getaway.jar"]