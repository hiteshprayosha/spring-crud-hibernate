# spring-crud-hibernate




Run the application in local env.

./mvnw spring-boot:run


Initialize Git in the project folder

cd springboot-crud-hibernate
git init --initial-branch=main
git add -A
git commit -m 'Init commit'
git remote add origin git@github.com:hiteshprayosha/spring-crud-hibernate.git
git push -u -f origin main


Dockerazation

1. Commnad is to package the applicaiton as JAR file
./mvnw clean package -DskipTests

2. Let's make the new src/main/docker directory. After that, we copy the application JAR file there:
cp target/spring-crud-hibernate-0.0.1-SNAPSHOT.jar src/main/docker/

3. Finally, we create this Dockerfile in that same directory:

4. Let's write Docker Compose file, docker-compose.yml
5. command to run the applicaion in docker
cd src/main/docker
docker-compose up

6. After making any chnage in code to do following commnads
cd src/main/docker
docker-compose down
docker rmi spring-crud-hibernate:latest
docker-compose up

7. Using postman, call below endpoints (find postman folder)
GET http://localhost:8080/api/v1/employees
POST http://localhost:8080/api/v1/employees
