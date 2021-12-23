FROM maven:3.8.4-openjdk-8-slim AS build
COPY . /home/app
RUN cd /home/app
RUN mvn -f /home/app/ clean package

FROM payara/server-full:5.201
# create a custom config folder
RUN wget -N https://jdbc.postgresql.org/download/postgresql-42.3.1.jar -P .
COPY --from=build /home/app/domain.xml /opt/payara/appserver/glassfish/domains/production/config
COPY --from=build /home/app/target/microprofile-config-example-1.0-SNAPSHOT.war $DEPLOY_DIR

RUN cp /opt/payara/postgresql-42.3.1.jar /opt/payara/appserver/glassfish/lib
