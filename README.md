# TASK2

#### Build image 

```
docker build -t webserviceimage .
```

#### Run docker compose

```
docker-compose run --service-ports -e POSTGRES_PASSWORD=[POSTGRES_PASSWORD] -e POSTGRES_USER=[POSTGRES_USER] -e POSTGRES_URL=jdbc:postgresql://db:5432/postgres web
```
There is default name of your database :"postgres"
#### Request
http://localhost:8080/actuator/health
##### You must see
```
{"status":"UP"}
```
#### Now you can check all possible requests with swagger

##### http://localhost:8080/swagger-ui.html




