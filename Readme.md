#Movie Character API
The Movie Character REST API is a remote collaboration between:
- Kristian Andersen [@kristianAndersen](https://github.com/kristianAndersen)
- Mikko Luukko [@mikkoluukko](https://github.com/mikkoluukko)
- Paula Rinta-Harri [@paularintaharri](https://github.com/paularintaharri)

##Table of contents
- Project Goals
- User Goals
- Requirements
- Documentation
- Technologies and tools used
- Deployment

##Project  Goals
The goal for this project was to create a working REST API with full CRUD constructed with Spring
using Spring Data and Hibernate and a PostgreSQL database.

##User  Goals
The goal for the user is to be able to use multiple methods to obtain information via the REST API endpoints
in addition to generic CRUD methods.

##Requirements

###Data
Data entities were required at minimum to provide the following information:

- Character
    - Auto Incremented ID
    - Full Name
    - Alias
    - Gender
    - Picture

- Movie
    - Auto Incremented ID
    - Movie Title
    - Genre
    - Release year
    - Director
    - Picture
    - Trailer

- Franchise
    - Auto Incremented ID
    - Name
    - Description

###API
Besides CRUD functionalities to manage all the entities (including generic READ ALL and READ ONE)
the API was required to offer the following reporting endpoints:

- Get all movies from a franchise
- Get all characters in a movie
- Get all the characters in a franchise

##API Documentation
API Documentation created with Postman can be found [here](https://documenter.getpostman.com/view/14576152/TWDRtftQ).

##Technologies and tools used

####Java
- Spring boot
- Spring Data
- Hibernate

####Database
- PostgreSQL

####Tools
- IntelliJ IDEA
- pgAdmin

##Demonstration
The [Movie Character API](https://moviecharactersapi.herokuapp.com/api/v1/movies) is deployed to [Heroku](heroku.com)
on a free tier, so if it boots a bit slow just be patient.

The REST API can also be tested with Postman using the collection provided [here](https://github.com/mikkoluukko/moviecharactersapi/blob/master/moviecharactersapi.postman_collection.json).