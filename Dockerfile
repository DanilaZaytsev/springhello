FROM gradle:6.9-jdk17

RUN gradle build

EXPOSE 8080

CMD java -jar build/libs/gs-spring-boot-0.1.0.jar