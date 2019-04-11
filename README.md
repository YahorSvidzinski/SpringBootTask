# TASK1

## Build image 

```
docker build -t [IMAGE_NAME] .
```
where temp is name of your image 

## Run container

```
docker run -p 8080:8080 -e KEYWORD_ONE=[FIRST_VARIABLE] -e KEYWORD_TWO=[SECOND_VARIABLE] [IMAGE_NAME]
```

## Expected result
Go to localhost:8080.
You must see
```
[FIRST_VARIALE][SECOND_VARIABLE]
```






