all: build start

build:
	mvn package
	docker-compose build

start:
	docker-compose up

stop:
	docker-compose down 

clean:
	mvn clean
	docker-compose rm
