FROM openjdk:22-jdk-slim
ARG JAR_FILE=target/notes-manager-0.0.1.jar
COPY ${JAR_FILE} notes-manager.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/notes-manager.jar"]