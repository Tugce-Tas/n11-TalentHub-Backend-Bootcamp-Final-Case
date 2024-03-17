# Infrastracture Setup
Applications dependency to other tools has been installed by using docker-compose files. In order to make application ready to run from container images, these dependencies should be installed by following commands. Neccessary docker-compose files stored in **infra_setup** folder. First, get into this folder path by using following command:
```
cd infra_setup
``` 

## Postgresql
It is used as a relational database for **logger** and **customer** applications. In order to install use following commands:

```
docker-compose -f postgresql.yml up -d
```

## Kafka
It is used for Message Queue. Applications produce their logs into Kafka, **logger** application listens kafka with related topics and consume the messages. After consuming it stores the data in PostgreSQL relational database. In order to install Kafka use following commands:

```
docker-compose -f kafka.yml up -d
```

## Solr
It is used as document based NoSQL database. It stores restaurant data. In order to install Kafka use following commands:

```
docker-compose -f solr.yml up -d
```

# Application Setup
After completing the infrastructure setup, each application have their own Dockerfile under their project structure in order to create images. In each path this command can be used to run containers:

## Customers
```
cd ..
cd customers
docker build -t n11/customers .
docker run -d --name customers --network infra_setup_restaurant-panel -p 8080:8080 n11/customers
```
Application will be available on port **8080**

## Restaurants
```
cd ..
cd restaurants
docker build -t n11/restaurants .
docker run -d --name restaurants --network infra_setup_restaurant-panel -p 8089:8089 n11/restaurants
```
Application will be available on port **8089**

## Logger
```
cd ..
cd logger
docker build -t n11/logger .
docker run -d --name logger --network infra_setup_restaurant-panel -p 8082:8082 n11/logger
```
Application will be available on port **8082**
## UI
After these steps completed, UI project can be started locally. First, in the path of UI project, 
`npm install` command is executed. After that, `npm start` command will start React project.