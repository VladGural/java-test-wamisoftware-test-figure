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

You should have JDK 17+, Maven, Docker, and Git installed on your computer to run this test. 

Create a new directory and move to it
```
mkdir java_test && cd java_test
```

Clone all artifacts from GitHab repository
```
git clone https://github.com/VladGural/java-test-wamisoftware-test-figure
```

Build and put figure service in the local maven repo. 
Meanwhile, it will start component tests for Figure service.
```
mvn -f ./java-test-wamisoftware-test-figure/pom.xml clean install
```

Create docker image for Figure service
```
docker build -t figure-service ./java-test-wamisoftware-test-figure/.
```

And now run service in docker containers
```
docker compose -f ./java-test-wamisoftware-test-figure/compose.yaml up --detach
```

For check type, the next
```
docker ps
```

And if everything was done correctly we will see something like this.
```
CONTAINER ID   IMAGE            COMMAND                  CREATED          STATUS          PORTS                                     NAMES
e27c83222927   figure-service   "/__cacert_entrypoin…"   15 seconds ago   Up 14 seconds   0.0.0.0:8080->80/tcp, [::]:8080->80/tcp   figure-service
```

Our service are running!!!

For testing we can use postmen
```
REQUEST
CALCULATE SQUARE PROPERTIES
URL: http://localhost:8080/v1/figures/properties
METHOD: POST
REQUEST:
{
    "figureType": "SQUARE",
    "figureRequestParam": "{\"length\":10.0}"
}

RESPONSE
{
    "area": 100.0,
    "perimeter": 40.0
}
```

```
REQUEST
CALCULATE RECTANGLE PROPERTIES
URL: http://localhost:8080/v1/figures/properties
METHOD: POST
REQUEST:
{
    "figureType": "RECTANGLE",
    "figureRequestParam": "{\"alength\":10.0,\"blength\":20.0}"
}

RESPONSE
{
    "area": 200.0,
    "perimeter": 60.0
}
```

```
REQUEST
CALCULATE TRIANGLE PROPERTIES
URL: http://localhost:8080/v1/figures/properties
METHOD: POST
REQUEST:
{
    "figureType": "TRIANGLE",
    "figureRequestParam": "{\"alength\":3.0,\"blength\":4.0,\"blength\":5.0}"
}

RESPONSE
{
    "area": 6.0,
    "perimeter": 12.0
}
```

```
REQUEST
CALCULATE CIRCLE PROPERTIES
URL: http://localhost:8080/v1/figures/properties
METHOD: POST
REQUEST:
{
    "figureType": "CIRCLE",
    "figureRequestParam": "{\"radius\":1.0}"
}

RESPONSE
{
    "area": 3.141592653589793,
    "perimeter": 6.283185307179586
}
```