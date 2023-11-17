FROM gradle:8.4-jdk17 as BUILD_IMAGE
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
COPY . .
RUN gradle build


FROM openjdk:17-jdk-slim
ENV JAR_NAME=exercicio_tui-0.0.1-SNAPSHOT.jar
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
COPY --from=BUILD_IMAGE $APP_HOME .
ENTRYPOINT exec java -jar $APP_HOME/build/libs/$JAR_NAME


