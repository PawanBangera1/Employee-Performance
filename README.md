# Employee Performance App

This is a Spring Boot application for managing employee performance ratings.

## Prerequisites

- Java 11 or higher
- Maven
- Docker (optional, for running the application in a container)

## Running the Application

### Using Maven

1. Navigate to the project directory:
    ```sh
    cd employee-performance-app/employee-performance-app
    ```

2. Build the project:
    ```sh
    mvn clean install
    ```

3. Run the application:
    ```sh
    mvn spring-boot:run
    ```
4. Local Server URL:
    ```sh
    http://localhost:8081/
    ```
    

### Using Docker (Change server port 8080)

1. Build the Docker image:
    ```sh
    docker build -t employee-performance-app .
    ```

2. Run the Docker container:
    ```sh
    docker run -p 8080:8080 employee-performance-app
    ```
3. Docker Hub Image :
4.  ```sh
    pawanbangera80/springbootapplication:latest
    ```

## Accessing the Application

Once the application is running, you can access it at `http://localhost:8080`.

## API Endpoints

- `GET /employees` - Retrieve all employees
- `POST /employees` - Create a new employee
- `GET /employees/percentages` - Get actual percentages of ratings
- `GET /employees/deviations` - Get deviations from standard percentages
- `GET /employees/suggestions` - Get suggested revisions
