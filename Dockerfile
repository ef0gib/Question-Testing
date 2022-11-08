FROM openjdk:latest
WORKDIR /code
COPY . /code
EXPOSE 9393
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} /code/question.jar
ENTRYPOINT ["java", "-jar", "question.jar"]