FROM openjdk:8-jdk-alpine
ADD ./target/UserProfile-0.0.1-SNAPSHOT.jar /usr/src/UserProfile-0.0.1-SNAPSHOT.jar

WORKDIR usr/src
ENTRYPOINT ["java","-jar","UserProfile-0.0.1-SNAPSHOT.jar"]
