# Run the payara server using maven plugin : Payara micro
Run the payara micro server using the command mvn package payara-micro:start

# OR

Run the payara server with your application
Payara admin : http://locahost:4848
Go to Applications and you will get the REST Endpoints.

REST End point : http://localhost:8080/microprofile-config-example/api/hello

Flyway migration command (here the schema is app !!!)

mvn clean flyway:migrate -Dflyway.user=postgres -Dflyway.password=123 -Dflyway.schemas=app -Dflyway.url=jdbc:postgresql://localhost:5432/postgres


Token : 425eebf277fab8e5fce4faef111210da85427497