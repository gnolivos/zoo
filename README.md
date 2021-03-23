This project was designed in Java 8 with Springboot. It has a hexagonal architecture and uses MySql as its database.

### Clone
 > `git clone https://github.com/gnolivos/zoo.git`

### Gradle
 > `gradle clean build`

### Docker-compose (MySql - Keycloak)
Go to *\src\main\resources

Execute: 
 > `docker-compose up`
 > `docker ps -a` (Validate status up)

### Keycloak Configuration
 > `http://keycloak:8080/`

**Console Administration** 

> Username: admin
> Password: admin

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

**HEADER**:       `Authorization: Bearer Token`

**METODO**:       `POST`   
**URL**:          `/auth/realms/gncorp/protocol/openid-connect/token`   
**HEADER**:       `Content-Type:application/x-www-form-urlencoded`  
**PARAMETROS**:   `username=gabriel&password=Password01&grant_type=password&client_id=zoo`   

### ENDPOINTS

### GET: 	`http://localhost:8081/api/v1/animals`
### POST: 	`http://localhost:8081/api/v1/animals`
     {
	    "name":"Lion",
	    "age": 3,
	    "dateBorn": "2019-03-20",
	    "weight": 3.4
	  }
### PUT: 	`http://localhost:8081/api/v1/animals`
 	 {
		"id": 1,
		"name": "Tiger"
	 }
### DELETE: 	`http://localhost:8081/api/v1/animals/{id}`
### PATCH: 	`http://localhost:8081/api/v1/animals/{id}`
	{
	   "name": "Monkey"
	}

### OPENAPI
 > `http://localhost:8081/swagger-ui-custom.html`

 
### Docker jib
> `gradle clean build jib`

### Add IP addresses to host file (C:\Windows\System32\drivers\etc\hosts)
> `127.0.0.1 keycloak`