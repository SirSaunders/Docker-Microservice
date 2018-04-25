
FROM java:8

## build spring project
COPY .  .
RUN  ls
RUN  ./gradlew build
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/build/libs/gs-rest-service-0.1.0.jar"]
