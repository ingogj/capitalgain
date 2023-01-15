# Capital Gain

## 1. Architectural Choices


> - [Java 8](https://www.java.com/pt-BR/download/help/java8_pt-br.html)
> - [Maven v3.8.7](https://maven.apache.org/)


## 2. Libraries and Frameworks

- [Spring Boot v^2.7.8](https://junit.org/)
    - Spring Boot to manage dependencies and make simple setup
- [Gson v^2.9.1](https://github.com/google/gson)
    - Gson to convert JSON into Java Objects
- [Lombok v^1.18.24](https://projectlombok.org/)
    - Lombok to make simplier and to avoid boilerplate code
- [JUnit v^4.13.2](https://junit.org/)
    - Junit to do Unit Tests
- [Mockito v^4.5.1](https://site.mockito.org/)
    - Mockito to instantiate classes and control the behavior of methods

## 3. Getting Started

- Install the dependencies by running the command:


```
mvn clean install
```


- Build and Start the application:

```
java -jar ./target/capitalgain-0.0.1-SNAPSHOT.jar
```

## 4. Tests

- To run unit tests:

```
mvn test
```