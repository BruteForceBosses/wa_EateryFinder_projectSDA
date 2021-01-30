FROM openjdk:11
VOLUME /tmp
ADD target/cloud-gateway-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]