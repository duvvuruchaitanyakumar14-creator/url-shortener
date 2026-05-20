# URL Shortener

A full-stack URL Shortener web application built using **Spring Boot**, **MySQL**, and **Hibernate (JPA)** that converts long URLs into short and manageable links while storing data in a database.

## Features

- Convert long URLs into shortened URLs
- Store URLs in a MySQL database
- Redirect shortened URLs to the original website
- Simple and responsive frontend
- REST API integration using Spring Boot
- Persistent data storage using Hibernate (JPA)

## Tech Stack

### Backend
- Java
- Spring Boot
- Spring Data JPA (Hibernate)
- REST API

### Database
- MySQL

### Frontend
- HTML
- CSS
- JavaScript

### Build Tool
- Maven

## Project Architecture

```text
Controller Layer  -> Handles HTTP requests
Service Layer     -> Business logic
Repository Layer  -> Database operations
Entity Layer      -> Database mapping using JPA
Frontend          -> HTML, CSS, JavaScript
