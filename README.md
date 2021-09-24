# Spring Initializr Template

This is a Spring Initializr Template Repository.

## Table of contents

- [General info](#general-info)
- [Setup](#setup)
- [Software details](#Software-details)
- [Status](#status)
- [Contact](#contact)

## General info

This is a template I created to easily spin up CRUD RESTful APIs.

## Setup

In order to run this API, you need to have a PostgreSQL instance running. I suggest using the following docker commands.

In order to create a PostgreSQL docker database, use the command:

> docker run --name postgres -p 5432:5432 -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=root -e POSTGRES_DB=templates -d postgres:9.6

_\* the word "templates" can be swapped out for the name of the database_

In order to build a docker container, use the command:

> docker build -t spring-initializr-template .

In order to run the docker container, use the command:

> docker run --rm -it -p 8080:8080 spring-initializr-template:latest

_\* the words "spring-initializr-template" can be swapped out for the name of the app_

## Software details

Language: Java 11 <br/>
Project: Maven 3.8.2 <br/>
Spring Boot: 2.5.5 <br/>
Packaging: Jar <br/>
Database: PostgreSQL 9.6 <br/>

## Status

Version: 1.0.0 <br/>
Project is: _finished_

## Contact

Created by [@cameronmathis](https://github.com/cameronmathis/) - feel free to contact me!
