FROM openjdk:11-jdk-slim
VOLUME /tpm
ADD target/residencial.jar residencial.jar
EXPOSE 8082
RUN bash -c 'touch /residencial.jar'
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/residencial.jar"]