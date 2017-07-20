# counter-test
Webapp - Click counter

Simple application, that presents a Click Counter and updates every the counter, of every client connected to the app.

### Tecnologies

- Java(v8)
- Maven(v3)
- Spring Boot(v1.5.2.RELEASE)
- Mongo DB(v3.4.6)
- Docker(17.06.0-ce)
- Docker-compose(v1.13.0))
- BootStrap

### Startup
#### Required to run:

- Java (http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- Maven (https://maven.apache.org/install.html)
- Docker (https://docs.docker.com/engine/installation/)
- Docker Compose (https://docs.docker.com/compose/install/)

#### Auto:
...
sh startup.sh
...

### Manual
...
mvn clean install -f ./counter-test/pom.xml
docker-compose up
...

### Webapp URL

- http://[ip-docker-machine]
