FROM openjdk:11-jdk
VOLUME /tpm
ADD target/residencial.jar app.jar
EXPOSE 8082
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-DJava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
