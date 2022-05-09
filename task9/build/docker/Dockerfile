FROM openjdk:11
ARG JAR_FILE
COPY ${JAR_FILE} /usr/src/myapp/program.jar
WORKDIR /usr/src/myapp/
CMD ["java","-jar","/usr/src/myapp/program.jar"]