ARG BASE_IMAGE=openjdk:8-jdk
FROM ${BASE_IMAGE}
ARG version
COPY target/myawesome_service_1-LATEST-RELEASE.jar /app.jar
ENTRYPOINT ["/bin/sh", "-c"]
CMD ["/usr/bin/java -Dspring.profiles.active=docker ${JVM_OPTS} -jar /app.jar"]
