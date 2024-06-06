# Spring Boot Web Application

## Description

This project is a Spring Boot web application that provides RESTful endpoints for calculating Fibonacci numbers and Greatest Common Divisor (GCD).
The task required the implementation of two RESTful endpoints:

1. The GET endpoint returns a number from the Fibonacci sequence based on the position provided in the request. For example, requesting the tenth number from the sequence would return the result "55". 
2. The POST endpoint expects a JSON formatted object containing two integer values, "val1" and "val2", and returns the GCD of these two numbers. Additionally, it handles a special case where "val1" is zero, in which case it returns the value of "val2".

For testing, endpoints can be accessed using tools like CURL or by integrating with a client application.

## Prerequisites

- Java JDK 8 or higher
- Maven
- Spring Boot

## Installation
- Clone this repository
- run this command inside the project directory : mvn spring-boot:run

## Endpoints

1. GET `/fibonacci/{position}`
  - Method: GET
  - Parameters: position (int)
  - Example: `/fibonacci/10`


2. POST `/gcd`
  - Method: POST
  - Request Body Format: JSON
  - Example Request Body:
    ```json
    {
      "num1": 42,
      "num2": 140
    }
    ```


## Author

Kshitij Harsh