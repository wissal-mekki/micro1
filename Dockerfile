version: '3'

services:
  docker-mysql:
    image: mysql:latest
    environment:
      - MYSQL_ROOT_PASSWORD=26156276
      - MYSQL_DATABASE=micro1
      - MYSQL_PASSWORD=26156276


  micro1-app:
    build:
      context: ./
      dockerfile: Dockerfile
    depends_on:
      - docker-mysql
    links:
        - docker-mysql:mysql
    ports:
      - 8085:8085
    environment:
        - SPRING_DATASOURCE_URL=jdbc:mysql://docker-mysql/micro1?useSSL=false&allowPublicKeyRetrieval=true
        - SPRING_DATASOURCE_USERNAME=root
        - SPRING_DATASOURCE_PASSWORD=26156276
      #- DATABASE_HOST=docker-mysql
      #- DATABASE_USER=root
      #- DATABASE_PASSWORD=26156276
     # - DATABASE_NAME=micro1
      #- DATABASE_PORT=3306
