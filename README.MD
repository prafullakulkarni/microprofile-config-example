# Run the payara server using maven plugin : Payara micro
Run the payara micro server using the command mvn package payara-micro:start

# OR

Run the payara server with your application
Payara admin : http://locahost:4848
Go to Applications and you will get the REST Endpoints.

REST End point : http://localhost:8080/microprofile-config-example/api/hello

Flyway migration command (here the schema is app !!!)

mvn clean flyway:migrate -Dflyway.user=postgres -Dflyway.password=123 -Dflyway.schemas=app -Dflyway.url=jdbc:postgresql://localhost:5432/postgres

# docker commands 

docker build -t microprofile-config-example:latest .

docker run --name payara -it -p 8080:8080 -p 4848:4848  --rm microprofile-config-example:latest

docker stop payara

docker exec -it payara /bin/bash

docker cp payara:/opt/payara/appserver/glassfish/domains/production/config/domain.xml .   