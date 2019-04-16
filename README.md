# TASK2

## Build image 

```
docker build -t myimage .
```

## Run docker compose

```
docker-compose run --service-ports -e POSTGRES_PASSWORD=[Your postgres pass] -e POSTGRES_USER=[Your postgres user] web
```
There is default name of your database :"postgres"
####Go to localhost:8080/actuator/health
#####You must see
```
{"status":"UP"}
```
### To add user send POST request to 
http://localhost:8080/users
## with JSON
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




