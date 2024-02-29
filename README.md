# MyMonitor
Basic Java Swing Application to monitor the Mykgrow Box.
## What is Mykgrow Box?
The Mykgrow Box is a small box that can be used to grow gourmet mushrooms at home.
The box includes several sensors and a fan to monitor and control the temperature, humidity, and light conditions 
inside the box. Moreover a ESP32 microcontroller is used to send the sensor data to a server. The ESP32 is also used to 
control the fan and the light inside the box, as well as the sensors.

## What is MyMonitor for?
The MyMonitor application is going to be a Java Swing application that will be used to monitor the sensor data and 
control the fan inside the box. The application is going to use MQTT to communicate with the server. The appliaction and
the box are going to be clients. The server is going to be the MQTT Broker. So the clients are going to subscribe to the
topics that they are interested in and the server is going to publish the data to the topics. The clients are going to
receive the data and update the GUI accordingly. The box is also able to publish messages to the server.

## Ubiquitous language
Before we start with the implementation of the application, we need to define the ubiquitous language. The ubiquitous
language is a common language that is used by all the stakeholders.

- User: The person that is going to use the application.
- Box: The Mykgrow Box.
- Server: The MQTT Broker.
- Humidity Sensor: The sensor that is going to measure the humidity inside the box.
- Temperature Sensor: The sensor that is going to measure the temperature inside the box.
- Fan: The fan that is going to be used to control the temperature inside the box.
- ESP32: The microcontroller that is going to be used to send the sensor data to the server and control the fan.
- MQTT: The protocol that is going to be used to communicate between the box and the server.
- Topic: The channel that is going to be used to send and receive messages between the box and the server.
- Message: The data that is going to be sent and received between the box and the server.
- GUI: The Graphical User Interface of the application.
- Mushroom: The gourmet mushrooms that are going to be grown inside the box.