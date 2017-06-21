#FROM oraclejdk8:latest
VOLUME /tmp
ADD springhibernet-v1.0.jar springhibernet.jar
RUN sh -c 'touch /springhibernet.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/springhibernet.jar"]
