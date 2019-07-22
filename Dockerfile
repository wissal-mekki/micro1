FROM openjdk:8-jdk


# Add a volume pointing to /tmp
# VOLUME /tmp

# Make port 8080 available to the world outside this container
EXPOSE 8085

# The application's jar file

# Add the application's jar to the container
COPY target/micro1-0.0.1-SNAPSHOT.jar micro1.jar


# Run the jar file
ENTRYPOINT [ "java" , "-Djava.security.egd=file:/dev/./urandom","-jar","/micro1.jar" ]
