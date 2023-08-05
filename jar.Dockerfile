FROM openjdk:8-jdk-alpine
RUN mkdir /app
WORKDIR /app
EXPOSE 8080
ADD /target/hr.jar hrimg.jar
ENTRYPOINT [ "java","-jar","hrimg.jar" ]