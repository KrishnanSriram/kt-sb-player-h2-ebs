FROM openjdk:11
EXPOSE 8080
ADD target/kt-sb-player.jar kt-sb-player.jar
ENTRYPOINT ["java", "-jar", "/kt-sb-player.jar"]