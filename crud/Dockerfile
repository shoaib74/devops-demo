FROM maven:3.5.3-jdk-8-alpine as target
WORKDIR /build

COPY ./ /build/
RUN mvn clean install

FROM tomcat:8.5-jre8-temurin
COPY --from=target /build/target/demo-0.0.1-SNAPSHOT.war  /usr/local/tomcat/webapps/ROOT.war
RUN apt update && apt-get install wget -y

EXPOSE 8080
CMD ["catalina.sh", "run"]