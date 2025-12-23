FROM eclipse-temurin:17-jre-alpine
WORKDIR /opt/app
COPY target/microservice-users-0.0.1-SNAPSHOT.jar app.jar
ENV JAVA_OPTS="-XX:+UseContainerSupport -XX:MaxRAMPercentage=75"
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -jar app.jar" ]
EXPOSE 8080