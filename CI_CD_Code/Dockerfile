FROM openjdk:8-jre-alpine
VOLUME /tmp
ADD /target/*.jar app.jar
ENTRYPOINT ["java","-Djava.secure.egd=file:/dev/./urandom", "-jar","/app.jar"]
