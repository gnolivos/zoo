This project was designed in Java 8 with Springboot. 
Gradle 6.3 and MySql are used as database.
Keycloak (Oauth) like authentication and authorization
Swagger to specify the list of resources available in the REST API

### Clone
 > `Create a folder, open a terminal and execute: git clone https://github.com/gnolivos/zoo.git`

### Gradle
 > `Open a terminal in new folder (zoo) and execute: gradle clean build`
 
### Host file (C:\Windows\System32\drivers\etc\hosts)
> `Add IP address: 127.0.0.1 keycloak`

### Docker-compose (MySql - Keycloak)
> `Go to *zoo\src\main\resources, execute: docker-compose up`

### Keycloak Configuration
 > `Go to http://keycloak:8080/ and select: Console Administration`
 > `Username: admin & Password: admin`

Go to Master -> Add realm
 - **Name**: gncorp -> *Create*

Go to Clients -> Create
 - **Client id**: zoo -> *Save*
	- Go to Valid Redirect URIs and put * 
	- Go to Web Origins and put * 
	-> Create
	
Go to Users -> Add user
 - **Username**: gabriel or any name -> *Save*
 - Go to Credentials and put 
 	- **Password**: Password01 or any password
 	- **Temporary**: Off
 	-> *Set Password*
 	
### Get token (Postman*)

**METOD**:       `POST`   
**URL**:          `/auth/realms/gncorp/protocol/openid-connect/token`   
**HEADER**:       `Content-Type:application/x-www-form-urlencoded`  
**PARAMETERS**:   `username=gabriel&password=Password01&grant_type=password&client_id=zoo`

Get the new Token, copy and paste in each endpoint.   

### ENDPOINTS

All endpoints: **HEADER**: `Authorization: Bearer Token` and put the Token.

### GET: 	`http://localhost:9070/api/v1/animals`
### POST: 	`http://localhost:9070/api/v1/animals`
     {
	    "name":"Lion",
	    "age": 3,
	    "dateBorn": "2019-03-20",
	    "weight": 3.4
	  }
### PUT: 	`http://localhost:9070/api/v1/animals`
 	 {
		"id": 1,
		"name": "Tiger"
	 }
### DELETE: 	`http://localhost:9070/api/v1/animals/{id}`
### PATCH: 	`http://localhost:9070/api/v1/animals/{id}`
	{
	   "name": "Monkey"
	}

### SWAGGER
 > `Go to http://localhost:9070/swagger-ui-custom.html`