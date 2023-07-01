FROM gradle:8.1.1-jdk17

COPY . /app/
WORKDIR /app
RUN gradle build

EXPOSE 8085

CMD java -jar build/libs/hello-0.0.1-SNAPSHOT.jar