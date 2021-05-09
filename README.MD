# Kafka Stream

Kafka Stream API is developed to count the unique number of overall mail addresses and domains which occurred within the event stream.

Build and Run:

It is a maven Spring-Boot project with Java 8 version to build the application, in pom.xml the path below command should be runned:
mvn clean install -U

-U required if any dependency not exist locally, it will download it.

Before running the application, zookeeper and kafka should be installed on the machine. Then first need start zookeeper and then kafka with below commands:
zkserver
.\bin\windows\kafka-server-start.bat .\config\server.properties

In the same location, with the following command the application could be run:
mvn spring-boot:run

Above command will start the Tomcat container on the 8082 port. For terminating the application, need to use:
ctrl+c

Swagger UI is implemented, so the API Documentation can accessed using the following URL in the browser:
http://localhost:8082/swagger-ui.html#

As in memory H2 DB is used and via below URL H2 DB could be accessed:
http://localhost:8082/h2

For testing purpose, Mockito framework is used.

Note: "docker-compose.yml" added for in case without downloading zookeeper and kafka. In this case "Docker" application should be installed. To run using
docker, below steps should be followed:
1) run docker app
2) navigate to the directory where located "docker-compose.yml"
3) run the command: docker-compose up -d