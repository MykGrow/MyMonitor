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

## Development Steps
### Step 1: Define the Core Domain 
- Identify the core functionalities of your application related to managing the GrowBox.
- This includes modeling entities like GrowBox, Sensor, Measurement, Actuator, etc.
- Use Value Objects like Temperature, Humidity, and PointInTime to represent simple data.

[Define the Core Domain](Steps/1.Define_The_Core_Domian.md)
### Step 2: Design Domain Logic Interfaces
- Create interfaces within the core domain layer that encapsulate the essential operations.
- For example:
  - **GrowBox** interface with methods to get sensor readings, adjust settings, and send commands. 
  - **Sensor** interface with methods to get the current measurement and sensor type.
- These interfaces act as contracts that define how the domain logic can be interacted with.

[Design Domain Logic Interfaces](Steps/2.Design_Domain_Logic_Interfaces.md)
### Step 3: Implement Domain Logic
- Develop the core domain logic that implements the defined interfaces.
- This layer should be independent of any external frameworks or technologies.
- Focus on business rules and operations related to managing the GrowBox domain.

[Implement Domain Logic](Steps/3.Implement_Domain_Logic.md)
### Step 4: Develop Adapters
- Create adapter classes that translate the domain interfaces to specific technologies. 
- Example adapters:
  - MQTT Adapter: Communicates with the GrowBox and translates MQTT messages to domain objects.
  - SensorDataAdapter: Converts raw sensor data into Measurement objects. 
  - ActuatorAdapter: Receives commands from the domain layer and sends instructions to the GrowBox actuators.

[Develop Adapters](Steps/4.Develop_Adapters.md)
### Step 5: Develop the User Interface
- This layer interacts with the application layer through the domain interfaces.
- The UI layer is responsible for presenting information, receiving user input, and triggering actions within the domain layer.

[Develop the User Interface](Steps/5.Develop_The_User_Interface.md)


