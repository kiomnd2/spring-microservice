FROM frolvlad/alpine-oraclejre8
VOLUME /tmp
ADD target/search-1.0.jar search-1.0.jar
EXPOSE 8001
ENTRYPOINT ["java", "-jar", "/search-1.0.jar"]