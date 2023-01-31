## Start app on your local machine
- Start the docker deamon
- Start all docker services: mongo, backend, nextjs: `docker compose up` 
- Run spring-boot dev server on port 8080: `./mvnw spring-boot:run`

## MongoDB
- Mongo db runs in a container on 27017 and the container port is mapped to the host port 26000
- Local connection string: mongodb://user1:user1@localhost:26000/todo?authSource=todo&readPreference=primary&appname=MongoDB%20Compass&directConnection=true&ssl=false
- Remote connection string: mongodb://user1:user1@164.90.208.25:26000/todo?authSource=todo&readPreference=primary&appname=MongoDB%20Compass&directConnection=true&ssl=false

## Endpoints
- /auth/sign-up
- /admin//user-claims/{uid}
- /todo/create
- /todo/update/{id}
- /todo/delete/{id}
- /todo/get - Gets a protected resource (Need to provide a token with the correct claims/role)