# Base Image JDK
FROM amazoncorretto:17.0.9-alpine3.18

# Lets create an argument which contains the jar file path
ARG JAR_FILE=target/*.jar

# Copy the jar file as app.jar
COPY ${JAR_FILE} app.jar

# Execute the jar file
ENTRYPOINT ["java","-jar","/app.jar"]