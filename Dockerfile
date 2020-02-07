FROM openjdk:8-jdk-alpine
VOLUME /TMP
EXPOSE 8082
ADD target/*.jar nasaImageApp.jar
ENTRYPOINT [ "sh", "-c", "java -jar /nasaImageApp.jar" ]