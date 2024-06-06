# Spring Boot Web Application

## Description

This project is a Spring Boot web application that provides RESTful endpoints for calculating Fibonacci numbers and Greatest Common Divisor (GCD).

## Prerequisites

- Java JDK 8 or higher
- Maven
- Spring Boot

## Installation
- Clone this repository
- run this command inside the project directory : mvn spring-boot:run

## Endpoints

- GET `/fibonacci/{position}`
- Method: GET
- Parameters: position (int)
- Example: `/fibonacci/10`


- POST `/gcd`
- Method: POST
- Request Body Format: JSON
- Example Request Body:
  ```
  {
    "num1": 42,
    "num2": 140
  }
  ```

## Author

Kshitij Harsh