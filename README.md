# demo
## How to run
* create mysql database called demo_db
* `mvn clean package -Dmaven.test.skip=true`
* `java -jar target/demo-0.0.1-SNAPSHOT.jar`

application is available on port 8089
## Endpoints
* `POST /products/` i.e. http://localhost:8089/products
* `PUT /products/{id}`
* `GET /products`

