FROM frolvlad/alpine-oraclejre8
VOLUME /tmp
ADD target/configserver-0.0.1-SNAPSHOT.jar configserver1.0.jar
EXPOSE 8888
ENTRYPOINT ["java", "-jar","/configserver1.0.jar"]