FROM harbor.iecas.com/iecas_microservice/java-centos-openjdk7-jre
MAINTAINER xxx pana@iecas.com

COPY target/course-dubbo-service-1.0-SNAPSHOT.jar /course-service.jar

ENTRYPOINT ["java", "-jar", "/course-service.jar"]
