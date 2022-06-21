# spring-crud-hibernate


- Gradle Profiles for Multi-Project Spring Boot Applications
- 

### Tech Stack and Plugin

1. Spring Boot
2. spring-boot-starter-data-jpa
3. spring-boot-starter-web
4. spring-boot-starter-validation
5. lombock
6. springdoc-openapi-ui *Spring REST API Using OpenAPI 3.0)



Run the application in local env.

./mvnw spring-boot:run


Initialize Git in the project folder

cd springboot-crud-hibernate
git init --initial-branch=main
git add -A
git commit -m 'Init commit'
git remote add origin git@github.com:hiteshprayosha/spring-crud-hibernate.git
git push -u -f origin main



## Building / Formatting / Testing

```bash
./gradlew clean build spotlessApply
```
## Docker up

```bash
./gradlew clean build spotlessApply
cp build/libs/spring-crud-hibernate-0.0.1-SNAPSHOT.jar docker/
docker-compose up
```
## Docker down

```bash
cd docker
docker-compose down
docker rmi spring-crud-hibernate:latest
```

## Run an application 

```bash
./gradlew bootRun
```

H2 Database local

http://localhost:8080/h2-console


####  Spring REST API Using OpenAPI 3.0
```html
http://localhost:8080/api-docs
http://localhost:8080/swagger-ui/index.html


```

7. Using postman, call below endpoints (find postman folder)
GET http://localhost:8080/api/v1/employees
POST http://localhost:8080/api/v1/employees



Resource:
1. https://medium.com/@berkaybasoz/spring-boot-h2-database-setup-6996a1c18cc