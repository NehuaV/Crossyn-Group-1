FROM gradle:7.2.0-jdk11

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
EXPOSE 8081

# execute it
CMD ["gradle", "build"]