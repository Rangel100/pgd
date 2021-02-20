FROM openjdk:14
VOLUME /tmp
EXPOSE 9090
COPY pdg1-1.0.0.jar /pdg1-1.0.0.jar
ENTRYPOINT ["java","-jar","pdg1-1.0.0.jar"]