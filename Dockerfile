FROM java:8

## build spring project
COPY ./SpringApp/  /usr/local/spring/
RUN cd /usr/local/spring/ && ls
RUN cd /usr/local/spring/ && ./gradlew build && java -jar build/libs/gs-rest-service-0.1.0.jar & disown
RUN echo("done")