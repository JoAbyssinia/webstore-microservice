# webstore-microservice
This is a microservice based application for a Webstore.

Microservices are:
1. webshop-registry [has replicas]
2. webshop-gateway [has replicas]
3. customer-service
4. product-service [has replicas]
5. shoppingcart-command
6. shoppingcart-query
7. stock-service
8. order-service
9. config-service
10. kafka-service
11. zipkin-server

# For Zipkin, we did
1. Navigated to this [link](https://zipkin.io/pages/quickstart). 
2. Installed [Docker](https://runnable.com/docker/install-docker-on-macos) and Zipkin using docker
3. Few Commands, we used (We ran the zipkin in 8083 port)
   a. `docker run -d -p 8083:9411 openzipkin/zipkin`


# Contributors
- Yohannes Kassa Yimam
- Bijay Shrestha