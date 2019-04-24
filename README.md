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
##### You must be familiar with kubernetes(minukube or some cloud solutions) to load configuration.
##### I've put all configuration in kubernetes package.So don't be shy and use them as you want.




