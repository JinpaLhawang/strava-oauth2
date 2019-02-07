FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dsecurity.oauth2.client.client-id=CLIENT_ID_REPLACE_ME","security.oauth2.client.client-secret=CLIENT_SECRET_REPLACE_ME","-jar","/app.jar"]
