# Imagen base con Java 17 (ajusta si usas otra versión)
FROM eclipse-temurin:21-jdk-alpine

# Carpeta dentro del contenedor
WORKDIR /app

# Copiamos el jar generado
COPY target/microservicio-coche-0.0.1-SNAPSHOT.jar app.jar

# Puerto donde corre Spring Boot
EXPOSE 8080

# Comando para arrancar la app
ENTRYPOINT ["java","-jar","app.jar"]
