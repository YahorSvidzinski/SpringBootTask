# TASK2

## Build image 

```
docker build -t myimage .
```

## Run docker compose

```
docker-compose run --service-ports -e POSTGRES_PASSWORD=postgres -e POSTGRES_USER=postgres -e POSTGRES_URL=jdbc:postgresql://db:5432/postgres web
```
There is default name of your database :"postgres"
####GET  
http://localhost:8080/actuator/health
#####You must see
```
{"status":"UP"}
```
### To add user send POST request to 
http://localhost:8080/users
## 
 ```
 {
     "firstName": "[userFirstName]",
     "secondName": "[userSecondName]"
 }
 ```
### To get user by id send GET request to 
http://localhost:8080/users/{id}
### To get all users send GET request to
http://localhost:8080/users




