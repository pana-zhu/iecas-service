FROM harbor.iecas.com/iecas_microservice/java-centos-openjdk7-jre
MAINTAINER xxx pana@iecas.com

COPY target/user-edge-service-1.0-SNAPSHOT.jar /user-edge-service.jar

ENTRYPOINT ["java", "-jar", "/user-edge-service.jar"]