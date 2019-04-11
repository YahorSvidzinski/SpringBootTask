# TASK1

##Build image 

```
docker build -t temp .
```
where temp is name of your image 

##Run container

```
docker run -p 8080:8080 -e KEYWORD_ONE=HELLO -e KEYWORD_TWO=SERGEY temp
```




