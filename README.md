# OMS-backend

Java 8 + Spring Boot + Hibernate REST JSON server.

Server for storing and retrieving Orders and Products.

Reqs
```
jdk 8
maven 3
```

Install
```
git clone https://github.com/samitapani/oms.git
cd oms
mvn spring-boot:run
```

Usage
```
curl 'localhost:8090/orders/list-paged?page=0&size=10' | jq
curl 'localhost:8090/products/list-paged?page=0&size=10' | jq

curl 'http://localhost:8090/orders/save' \
-H 'Content-Type: application/json;charset=UTF-8' \
-H 'Accept: application/json, text/plain, */*' \
-H 'Connection: keep-alive' --data-binary '{"id":2,"name":"More worms","orderItemList":[{"id":5,"count":10,"product":{"id":4,"name":"Worm","price":0.29}}],"creation":1517255921223}'

curl 'http://localhost:8090/orders/delete/2'
```
