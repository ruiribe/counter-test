#!/bin/bash
git clone https://github.com/ruiribe/counter-test
cd counter-test
#sh install_docker.sh
#sh install_jdk_maven.sh
mvn clean install -f ./counter-test
docker-compose up -d
docker-compose logs -f
