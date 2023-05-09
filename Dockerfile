FROM openjdk:11
COPY ./target/E-RaktKendraBackend-0.0.1-SNAPSHOT.jar ./
WORKDIR ./
CMD ["java", "-jar", "E-RaktKendraBackend-0.0.1-SNAPSHOT.jar"]