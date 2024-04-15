FROM maven:3.5.3-jdk-8-slim as target
WORKDIR /build
COPY ./ /build/
RUN mvn clean install -Dmaven.test.skip=true

FROM openjdk:8-jdk-alpine 
VOLUME /tmp
 
COPY --from=target /build/target/*T.jar app.jar 
RUN wget -O /opt/apm-agent.jar https://search.maven.org/remotecontent?filepath=co/elastic/apm/elastic-apm-agent/1.26.0/elastic-apm-agent-1.26.0.jar
ENTRYPOINT ["java","-jar","app.jar"]
