# publication-service-java
A Spring Boot dockerized application that publish messages to RabbitMQ Queue.
## Docker-compose
First need to clone the docker compose project from [Github](https://github.com/tauhid-adfenix/docker-compose.git). After that run the `setup.sh` or `setup.bat` for first time. For further instruction read the README.

## REST API
Hit the API to publish a message and send it to Rabbitmq queue
```shell
curl localhost:8080/api/send/<Your message to publish>
```