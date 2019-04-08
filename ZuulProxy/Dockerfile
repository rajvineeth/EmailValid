FROM openjdk:8-jdk-alpine
ADD ./target/ZuulProxy-0.0.1-SNAPSHOT.jar /usr/src/ZuulProxy-0.0.1-SNAPSHOT.jar
EXPOSE 8084
WORKDIR usr/src
ENTRYPOINT ["java","-jar","ZuulProxy-0.0.1-SNAPSHOT.jar"]
