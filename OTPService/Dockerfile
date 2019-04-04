FROM openjdk:8-jdk-alpine

ADD ./target/OTPService-0.0.1-SNAPSHOT.jar /usr/src/OTPService-0.0.1-SNAPSHOT.jar
EXPOSE 7999
WORKDIR usr/src
ENTRYPOINT ["java","-jar","OTPService-0.0.1-SNAPSHOT.jar"]
