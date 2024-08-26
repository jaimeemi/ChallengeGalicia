#FROM ubuntu:latest
#LABEL authors="Emi"
#
#ENTRYPOINT ["top", "-b"]
FROM amazoncorretto:22
WORKDIR /app
COPY target/tu-proyecto.jar /app/tu-proyecto.jar
EXPOSE 8080
CMD ["java", "-jar", "/app/galicia.jar"]