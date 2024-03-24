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

## Loom Video Link
https://www.loom.com/share/8ae68b3b2c5a499389ae2a431f48fdcb


![diyagram drawio](https://github.com/Tugce-Tas/n11-TalentHub-Backend-Bootcamp-Final-Case/assets/110787805/97bb9ce6-fc3e-45c1-a622-ca03b3b3f905)

![3](https://github.com/Tugce-Tas/n11-TalentHub-Backend-Bootcamp-Final-Case/assets/110787805/dfbd8199-8c88-4d81-8c2f-b3537cc19e1f)

![4](https://github.com/Tugce-Tas/n11-TalentHub-Backend-Bootcamp-Final-Case/assets/110787805/0017e24a-c306-40da-bbff-fd5a9e3b6d13)

![6](https://github.com/Tugce-Tas/n11-TalentHub-Backend-Bootcamp-Final-Case/assets/110787805/4c4481ec-1e14-40f5-819a-e5490857fe22)

![7](https://github.com/Tugce-Tas/n11-TalentHub-Backend-Bootcamp-Final-Case/assets/110787805/8b8c3e8e-8ca6-431d-98e9-abb519667f22)

![8](https://github.com/Tugce-Tas/n11-TalentHub-Backend-Bootcamp-Final-Case/assets/110787805/896a285f-57ba-4374-9201-d146e7d6d238)

![9](https://github.com/Tugce-Tas/n11-TalentHub-Backend-Bootcamp-Final-Case/assets/110787805/1b4da13f-b5e9-414d-94e9-a09f7ead66a5)

![10](https://github.com/Tugce-Tas/n11-TalentHub-Backend-Bootcamp-Final-Case/assets/110787805/88cfe681-0247-48eb-ad03-25badf8ba7ce)

![12](https://github.com/Tugce-Tas/n11-TalentHub-Backend-Bootcamp-Final-Case/assets/110787805/7a73fb8d-4fa0-4619-97d0-f7f24603af68)

![13](https://github.com/Tugce-Tas/n11-TalentHub-Backend-Bootcamp-Final-Case/assets/110787805/5d71b1e8-be45-41a6-a6cf-9f7ffc459a90)



