ARG BASE_IMAGE=479580041174.dkr.ecr.ap-south-1.amazonaws.com/myawesome-java-8:1.7
FROM ${BASE_IMAGE}
ARG version
COPY target/myawesome_service_1-LATEST-RELEASE.jar /app.jar
ENTRYPOINT ["/bin/sh", "-c"]
CMD ["/usr/bin/java -Dspring.profiles.active=docker ${JVM_OPTS} -jar /app.jar"]
