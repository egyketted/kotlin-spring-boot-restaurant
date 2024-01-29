FROM amazoncorretto:21-alpine
Add build/libs/kotlin-spring-boot-graphql-0.0.1-SNAPSHOT.jar /home/root/app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar","/home/root/app.jar"]