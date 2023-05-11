FROM openjdk:17.0.2
VOLUME /tmp
EXPOSE 8080
COPY maven/target/hello-service.jar service.jar
ENTRYPOINT ["java","-jar","/service.jar"]