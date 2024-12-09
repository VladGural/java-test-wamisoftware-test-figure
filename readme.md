# Java Test Assignment (Middle Java Developer position at Wamisoftware)

## **Task**
Develop an application for calculating the area and perimeter of geometric shapes.
The application should be implemented as a REST API. The minimum set of shapes
to support includes a square, a rectangle, a triangle, and a circle (perimeter is the
circumference length).

## **Requirements**
1. Create a Spring Boot 2 application using Java 8+.
2. Implement a single REST API endpoint that accepts input for calculating the area
   and perimeter of different geometric shapes. The endpoint should not use
   conditional statements (e.g., if-else) to determine the shape calculation service
   based on the request.
3. Support the following geometric shapes:
- Square
- Rectangle
- Triangle
- Circle (perimeter is the circumference length)
4. Implement validation.
5. Use appropriate HTTP status codes.

## **Technology Stack**
- Spring Boot 2
- Java 8+
- Any additional libraries or frameworks within the Spring ecosystem as needed.

## **Submission**
Please submit your solution as a Git repository with a README file that includes
instructions on how to build and run the application, as well as any other relevant
information about your implementation.

## Good luck with the assignment!

 
# How run solution of this test

You should have JDK, Maven, Docker, and Git installed on your computer to run this test. 

Create a new directory and move to it
```
mkdir java_test && cd java_test
```

Clone all artifacts from GitHab repository
```
git clone https://github.com/VladGural/java-test-wamisoftware-test-figure
```

Build and put all services in the local maven repo. 
Meanwhile, it will start component tests for Company and Analytic services.
```
mvn -f ./java-test-wamisoftware-test-figure/pom.xml clean install
```

Create docker images for Figure service
```
docker build -t figure-service ./java-test-wamisoftware-test-figure/.
```

And now run services in docker containers
```
docker compose -f ./java-test-wamisoftware-test-figure/compose.yaml up --detach
```

For check type, the next
```
docker ps
```

And if everything was done correctly we will see something like this.
```
CONTAINER ID   IMAGE                              COMMAND                  CREATED          STATUS          PORTS                                                               NAMES
3800d7990512   analytic-service                   "/__cacert_entrypoin…"   49 seconds ago   Up 49 seconds   0.0.0.0:8081->80/tcp, [::]:8081->80/tcp                             analytic-service
278099ea88f1   company-service                    "/__cacert_entrypoin…"   49 seconds ago   Up 49 seconds   0.0.0.0:8080->80/tcp, [::]:8080->80/tcp                             company-service
7653491a7d7d   confluentinc/cp-kafka:latest       "/etc/confluent/dock…"   49 seconds ago   Up 49 seconds   0.0.0.0:9092->9092/tcp, :::9092->9092/tcp                           kafka
01599f916f96   confluentinc/cp-zookeeper:latest   "/etc/confluent/dock…"   50 seconds ago   Up 49 seconds   2888/tcp, 3888/tcp, 0.0.0.0:22181->2181/tcp, [::]:22181->2181/tcp   zookeeper
d88dd6174c9c   postgres:16                        "docker-entrypoint.s…"   50 seconds ago   Up 49 seconds   0.0.0.0:55432->5432/tcp, [::]:55432->5432/tcp                       postgres-company
fd8429babf20   postgres:16                        "docker-entrypoint.s…"   50 seconds ago   Up 49 seconds   0.0.0.0:54432->5432/tcp, [::]:54432->5432/tcp                       postgres-analytic
```

Our services are running!!!

For testing we can use postmen
```
CREATE COMPANY
URL: http://localhost:8080/v1/companies
METHOD: POST
REQUEST:
{
    "name": "Alis",
    "status": "ACTIVE",
    "contactInformation": "phone: +380503332211, mail: info@alis.pro",
    "industry": "food",
    "companyAddress": [
        {
            "country": "Ukraine",
            "city": "Kyiv",
            "street": "Vasilya Tutunnika",
            "zip": "03150",
            "addressCategory": [
                "HEADQUARTER",
                "DISTRIBUTION_CENTER"
            ]
        },
        {
            "country": "Ukraine",
            "city": "Lviv",
            "street": "Velika Gora",
            "zip": "02011",
            "addressCategory": [
                "HEADQUARTER"
            ]
        }
    ]
}
```

```
GET CURRENT NAME
URL: http://localhost:8081/v1/companies/{ID_YOUR_COMPANY_CREATED_ABOVE}/current-names
METHOD: GET
RESPONSE:
{
    "currentName": "Alis"
}
```

```
GET PREVIOUS NAMES
URL: http://localhost:8081/v1/companies/{ID_YOUR_COMPANY_CREATED_ABOVE}/names
METHOD: GET
RESPONSE:
{
    "currentName": "Alis",
    "previousNames": []
}
```

```
GET ADDRESS CATEGORY STAT
URL: http://localhost:8081/v1/companies/{ID_YOUR_COMPANY_CREATED_ABOVE}/address-category-stats
METHOD: GET
RESPONSE:
{
    "addressCategoryStat": {
        "DISTRIBUTION_CENTER": 1,
        "HEADQUARTER": 2
    }
}
```

```
GET CURRENT STATUS
URL: http://localhost:8081/v1/companies/{ID_YOUR_COMPANY_CREATED_ABOVE}/current-statuses
METHOD: GET
RESPONSE:
{
    "currentStatus": "ACTIVE"
}
```