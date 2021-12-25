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

hit the url 
http://localhost:4848 (admin/admin)

hit the url 

http://localhost:8080/microprofile-config-example-1.0-SNAPSHOT/api/hello

http://localhost:8080/microprofile-config-example-1.0-SNAPSHOT/api/member/1

docker stop payara

docker exec -it payara /bin/bash

docker cp payara:/opt/payara/appserver/glassfish/domains/production/config/domain.xml .

kubectl create secret generic database-config --from-literal=database-server=10.0.1.15 --from-literal=user=rhushi --from-literal=password=123

## minikube commands

minikube start --driver=docker

minikube -p minikube docker-env

eval $(minikube -p minikube docker-env)


docker build -t microprofile-config-example:latest .

kubectl create secret generic database-config --from-literal=user=rhushi --from-literal=password=123

kubectl apply -f deployment.yaml

kubectl port-forward deployment.apps/payara-deployment 8080:8080 4848:4848

kubectl get pods

kubectl exec -it <pod-name> /bin/bash