# TASK3

## Use maven wrapper

Open your project package in cmd

```
./mvnw.cmd clean package
```

## You have two options to launch application

### First option

##### Run docker compose

```
docker-compose run --service-ports -e POSTGRES_PASSWORD=[POSTGRES_PASSWORD] -e POSTGRES_USER=[POSTGRES_USER] -e POSTGRES_URL=jdbc:postgresql://db:5432/postgres web
```
##### Request
http://localhost:8080/actuator/health
###### You must see
```
{"status":"UP"}
```
#### Now you can check all possible requests with swagger

##### http://localhost:8080/swagger-ui.html

There is default name of your database :"postgres"
### Second option
#### Kubernetes config
##### Before starting deployments you need to set database configuration

##### Set your database user name and password
```
kubectl create secret generic postgres-sec --from-literal=POSTGRES_USER=[YOUR POSTGRES USER] --from-literal=POSTGRES_PASSWORD=[YOUR POSTGRES PASSWORD]
```
##### Set URL
```
kubectl create configmap postgres-conf --from-literal=POSTGRES_URL=jdbc:postgresql://db:5432/[DATABASE NAME(default:postgres)]
```

##### Now you just need to apply your services and deployments
```
kubectl apply -f [CONFIGURATION NAME]
```
