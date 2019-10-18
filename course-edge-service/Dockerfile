FROM harbor.iecas.com/iecas_microservice/java-centos-openjdk7-jre
MAINTAINER xxx pana@iecas.com

COPY target/course-edge-service-1.0-SNAPSHOT.jar /course-edge-service.jar

ENTRYPOINT ["java", "-jar", "/course-edge-service.jar"]
