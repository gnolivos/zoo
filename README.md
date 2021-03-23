This project was designed in Java 8 with Springboot. It has a hexagonal architecture and uses MySql as its database.

#Project
https://github.com/gnolivos/zoo

#Clone
git clone https://github.com/gnolivos/zoo.git

#Gradle
gradle clean build

#Docker-compose (MySql - Keycloak)
Go to *\src\main\resources

Execute: 
docker-compose up
docker ps -a (Validate status up)

#Keycloak Configuration
http://localhost:8084

Console Administration 

Username: admin
Password: admin

Go to Master -> Add realm
 - Name: gncorp -> Create

Go to Clients -> Create
 - Client id: zoo -> Save 
	- Go to Valid Redirect URIs and put *
	- Go to Web Origins and put * 
	-> Create
	
Go to Users -> Add user
 - Username: gabriel or any name -> Save
 - Go to Credentials and put 
 	- Password: Password01 or any password
 	- Temporary: Off
 	-> Set Password
 	
#Get token (Postman*)
http://localhost:8084/auth/realms/gncorp/protocol/openid-connect/token

Body -> x-www-form-urlencoded
   KEY			 VALUE
grant_type		password
client_id		zoo
username		gabriel
password		Password01


#ENDPOINTS
http://localhost:8081/actuator

http://localhost:8081/actuator/health

GET: http://localhost:8081/api/v1/animals

POST: http://localhost:8081/api/v1/animals

{
    "name":"Lion",
    "age": 3,
    "dateBorn": "2019-03-20",
    "weight": 3.4
}

PUT: http://localhost:8081/api/v1/accounts

{
	"id": 1,
	"name": "Tiger"
}

DELETE: http://localhost:8081/api/v1/accounts/1

PATCH: http://localhost:8081/api/v1/accounts/1
{
   "id": 1,
   "myMap": {
         		"id": 1,
         		"name": "Monkey" 
     		}
}

#OPENAPI
http://localhost:8081/swagger-ui-custom.html
