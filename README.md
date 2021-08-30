# SpringBootWebSocket_ This project is very Easy to be make
Websocket_Spring Boot

Using WebSocket to build an interactive web application
This guide walks you through the process of creating a “Hello, world” application that sends messages back and forth between a browser and a server. WebSocket is a thin, lightweight layer above TCP. This makes it suitable for using “subprotocols” to embed messages. In this guide, we use STOMP messaging with Spring to create an interactive web application. STOMP is a subprotocol operating on top of the lower-level WebSocket.

What You Will build
You will build a server that accepts a message that carries a user’s name. In response, the server will push a greeting into a queue to which the client is subscribed.

What You Need
About 15 minutes

A favorite text editor or IDE

JDK 1.8 or later

Gradle 4+

You can also import the code straight into your IDE:

Spring Tool Suite (STS)

IntelliJ IDEA
