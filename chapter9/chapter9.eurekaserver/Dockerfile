FROM frolvlad/alpine-oraclejre8
VOLUME /tmp
ADD target/eurekaserver-1.0.jar eurekaserver-1.0.jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar","/eurekaserver-1.0.jar"]