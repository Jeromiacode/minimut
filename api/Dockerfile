FROM openjdk:17

RUN groupadd --system spring && adduser --system spring -g spring

RUN mkdir -p /opt/{project-name}/logs
RUN chown -R spring:spring /opt/{project-name}

COPY build/libs/*.jar /opt/{project-name}/bin/application.jar

USER spring:spring

EXPOSE 8080

CMD ["java","-jar", "-Djava.security.egd=file:/dev/./urandom" , "/opt/{project-name}/bin/application.jar"]
