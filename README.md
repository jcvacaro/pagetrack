# pagetrack

This application tracks all pages accessed by users in order to better understand how browsing patterns may lead to a contact request. 

# Documentation

Check the wiki page. 

# Installation requirements 

- Linux operating system 
- Docker 
- Docker Compose 
- Java 8 or later 
- Maven 
- make

# Source code

## Compiling the sources

~~~~~~~~~~
make build 
~~~~~~~~~~

##  Starting the application 

~~~~~~~~~~
make start 
~~~~~~~~~~

##  Stopping the application 

~~~~~~~~~~
make stop 
~~~~~~~~~~

## Cleanning the environment 

~~~~~~~~~~
make clean
~~~~~~~~~~

## Accessing the web application

Access port 8080 on your local environment using your favorite browser.

## Accessing logs 

Choose the container id associated to the target microservice:

~~~~~~~~~~
docker ps
~~~~~~~~~~

To see the logs, enter the following command:

~~~~~~~~~~
docker logs <CONTAINER_ID>
~~~~~~~~~~

## Accessing a container

Choose the container id associated to the target microservice:

~~~~~~~~~~
docker ps
~~~~~~~~~~

To execute a command into the container context use the docker exec command. For example, to have a bash console type the following:

~~~~~~~~~~
docker exec -it <CONTAINER_ID> /bin/bash
~~~~~~~~~~
