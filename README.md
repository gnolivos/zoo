#Create keycloak image
docker run -d --name keycloak -p 8084:8080 -e KEYCLOAK_USER=admin -e KEYCLOAK_PASSWORD=admin jboss/keycloak
#Show keycloak log
docker logs -f keycloak
#Show coniners runnig
docker ps
#Stop specify container
docker stop keycloak
#Remove specify container
docker rm keycloak

#Keycloak
http://localhost:8084
#Get token
http://localhost:8084/auth/realms/gncorp/protocol/openid-connect/token

http://localhost:8081/api/v1/accounts/anonymous

#ENDPOINTS
http://localhost:8081/actuator

http://localhost:8081/actuator/health

GET: http://localhost:8081/api/v1/accounts

POST: http://localhost:8081/api/v1/accounts

{
"name":"Juan"
}

PUT: http://localhost:8081/api/v1/accounts

{
"id": 2,
"name": "hola-update"
}

DELETE: http://localhost:8081/api/v1/accounts/1

#OPENAPI
#definicion de api en formaton json o yml
http://localhost:8081/v3/api-docs/
http://localhost:8081/v3/api-docs.yaml

#endpoint
http://localhost:8081/swagger-ui-custom.html

Ref: https://www.baeldung.com/spring-rest-openapi-documentation
