FROM gradle:7.2.0-jdk11
#FROM openjdk:11

# application placed into /opt/app
RUN mkdir -p /opt/backend
WORKDIR /opt/backend

# selectively add the POM file and
# install dependencies
COPY build.gradle /opt/backend
RUN gradle init

# rest of the project
COPY src /opt/backend/src

# local application port
EXPOSE 8080

#ADD build/libs/demo-0.0.1-SNAPSHOT.jar crossyn.jar

#ENTRYPOINT [ "java", "-jar", "crossyn.jar" ]

# execute it
CMD ["gradle", "build"]