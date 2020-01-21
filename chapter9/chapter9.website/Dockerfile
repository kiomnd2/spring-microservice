FROM frolvlad/alpine-oraclejre8
VOLUME /tmp
ADD target/website-1.0.jar website-1.0.jar
EXPOSE 8001
ENTRYPOINT ["java", "-jar", "/website-1.0.jar"]