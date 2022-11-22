FROM openjdk:11-jre-slim
VOLUME /tmp
ADD target/Test*.jar /app.jar
CMD ["java" , "-jar","/app.jar"]