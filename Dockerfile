FROM eclipse-temurin:17-jdk-focal
EXPOSE 9090
ADD target/StudentService-0.0.1-SNAPSHOT.jar StudentService-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/StudentService-0.0.1-SNAPSHOT.jar"]