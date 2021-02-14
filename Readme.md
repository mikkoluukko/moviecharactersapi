#Movie Character API

---
The Movie character REST API is a remote collaboration between
 - Mikko Luukko [@mikkoluukko](https://github.com/mikkoluukko) 
 - Paula Rinta-Harri [@paularintaharri](https://github.com/paularintaharri) 
 - Kristian Andersen [@kristianAndersen](https://github.com/kristianAndersen) 


### Table of contents

 - Project Goals
 - User Goals
 - Requirements 
 - Documentation  
 - Technologies
 - Deployment

---

### Project  Goals

---
 -  The goal for this project is to create a working REST API with full CRUD.
---

### User  Goals

---
-  The Goal for the user is to be able to use multiple methods to obtain information via the REST API end-points 
   in addition to generic READ ALL, READ ON.
   
---

### Requirements

---

**Data** 

Required entities must as a minimum be.

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
 
**API** 

reporting     

- Get all movies from a franchise
- Get all characters in a movie
- Get all the Characters in a franchise
- Get All Movies
- Get All Characters
- Get All Franchises 
- Get a Specific Movie
- Get a Specific Character
- Get a Specific Franchise

---

### Documentation

---

The API can be accessed or modified by standard HTTP Request's
GET, POST, PUT, or DELETE

- Get all movies from a franchise
    - /api/v1/franchises/{id}/movies
```json
[
{
  "id": 4,
  "title": "Dr. No",
  "genre": "Action, Adventure",
  "releaseYear": 1962,
  "director": "Terence Young",
  "picture": null,
  "trailer": null,
  "characters": [
    "/api/v1/characters/3"
  ],
  "franchise": "/api/v1/franchises/2"
}, ...
```
- Get all characters in a movie
    - /api/v1/movies/{id}/characters
```json

{
  "id": 1,
  "name": "Frodo Baggins",
  "alias": "Mr. Underhill",
  "gender": "Male",
  "picture": null,
  "movies": [
    "/api/v1/movies/1",
    "/api/v1/movies/9",
    "/api/v1/movies/2",
    "/api/v1/movies/3",
    "/api/v1/movies/8"
  ]
}, ...
```
- Get all the Characters in a franchise
  - /api/v1/franchises/{id}/characters
```json
  [
    {
    "id": 2,
    "name": "Gollum",
    "alias": "Smeagol",
    "gender": "Male",
    "picture": null,
    "movies": [
      "/api/v1/movies/1",
      "/api/v1/movies/3",
      "/api/v1/movies/2"
    ]
  }, ...
```    
- Get All Movies
  - /api/v1/movies
```json
[
{
  "id": 2,
  "title": "The Two Towers",
  "genre": "Fantasy, Adventure",
  "releaseYear": 2002,
  "director": "Peter Jackson",
  "picture": null,
  "trailer": null,
  "characters": [
  "/api/v1/characters/1",
  "/api/v1/characters/2"
  ],
  "franchise": "/api/v1/franchises/1"
  },...
```

- Get All Characters
  - /api/v1/characters
```json
  [
    {
    "id": 1,
    "name": "Frodo Baggins",
    "alias": "Mr. Underhill",
    "gender": "Male",
    "picture": null,
    "movies": [
      "/api/v1/movies/8",
      "/api/v1/movies/9",
      "/api/v1/movies/1",
      "/api/v1/movies/2",
      "/api/v1/movies/3"
    ]
  }, ...
```    
- Get All Franchises
  - /api/v1/franchises
```json
 [
 {
 "id": 1,
 "name": "The Lord of the Rings",
 "description": "The Lord of the Rings movies",
 "movies": [
 "/api/v1/movies/2",
 "/api/v1/movies/3",
 "/api/v1/movies/1"
  ]
  },...    
```     
- Get a Specific Movie
   - /api/v1/movies/1
````json
{
  "id": 1,
  "title": "The Fellowship of the Ring",
  "genre": "Fantasy, Adventure",
  "releaseYear": 2001,
  "director": "Peter Jackson",
  "picture": null,
  "trailer": null,
  "characters": [
    "/api/v1/characters/4",
    "/api/v1/characters/3",
    "/api/v1/characters/2",
    "/api/v1/characters/1"
  ],
  "franchise": "/api/v1/franchises/1"
}
````    
- Get a Specific Character
  - /api/v1/characters/1
```json
{
  "id": 1,
  "name": "Frodo Baggins",
  "alias": "Mr. Underhill",
  "gender": "Male",
  "picture": null,
  "movies": [
    "/api/v1/movies/8",
    "/api/v1/movies/9",
    "/api/v1/movies/1",
    "/api/v1/movies/2",
    "/api/v1/movies/3"
  ]
}
```    
- Get a Specific Franchise
  - /api/v1/franchises/{id}
```json
{
  "id": 1,
  "name": "The Lord of the Rings",
  "description": "The Lord of the Rings movies",
  "movies": [
    "/api/v1/movies/2",
    "/api/v1/movies/3",
    "/api/v1/movies/1"
  ]
}
```


The REST API can be tested in Postman using the collection provided [here](moviecharactersapi.postman_collection.json)



---

### Technologies

---

**Java**
 - Spring boot
 - Spring Data
 - Hibernate

**Data**
 - postgreSQL 
 - pgAdmin

---

### Deployment

---

The [Movie Character API](https://moviecharactersapi.herokuapp.com/api/v1/movies) is deployed to [Heroku](heroku.com) 
on a free tier, so if it boots a bit slow just be patient. 