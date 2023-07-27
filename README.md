# Java RMI Client-Side

There is client side and server side, this repo represents client side and server side in this repo: https://github.com/OmarAbbadi01/RMI-Server

The client-side code interacts with the server-side to perform operations on the MySQL database using the RMI (Remote Method Invocation) mechanism. Before running the client-side code, ensure that the server-side is up and running, and the necessary configurations are in place as mentioned in the project description.

## Instructions

1. Ensure the server-side is set up and running with the MySQL database and necessary RMI implementations.
2. Create a MySQL database called 'rmi' with user 'rmi' and password 'root', or modify the credentials in the `MySqlConnectionFactory` class on the server-side.
3. Add the MySQL JDBC jar file to the classpath of the project to connect to the database.
4. Configure the IP address of this client-side machine to a static one.
5. Configure another static IP address for the server-side machine.

## Client-Side Code Overview

The client-side code is the user interface that interacts with the server-side to communicate with the remote MySQL database using RMI. Below is a high-level overview of its functionality:

1. **Importing Required Packages:** The client-side code starts by importing the necessary packages, including `java.rmi.registry.LocateRegistry` and `java.rmi.registry.Registry`, to enable communication with the server through RMI.

2. **Main Method:** The `main` method serves as the entry point for the client application. It establishes a connection with the RMI registry hosted on the server-side.

3. **Connecting to the Server:** In the `main` method, the client-side code tries to connect to the RMI registry on the server-side. It uses the `LocateRegistry.getRegistry(serverIpAddress)` method, where `serverIpAddress` should be replaced with the actual static IP address of the server machine. The client attempts to locate the registry based on the provided IP address.

4. **Obtaining Remote Object Reference:** Once the client successfully connects to the RMI registry, it obtains the reference to the remote object hosted on the server-side. The remote object should implement the RMI interface, which should be shared between the client and the server. The actual methods declared in this interface represent the operations that can be performed on the server-side.

5. **Interacting with the Server:** With the remote object reference in hand, the client can now call methods on the server-side as if they were local methods. The RMI system handles the communication between the client and the server transparently.

6. **Client User Interface:** Depending on the project requirements, the client-side code may present a user interface to the user. This interface can include options and menus to interact with the server and perform various CRUD (Create, Read, Update, Delete) operations on the MySQL database.

7. **Handling Errors:** The client-side code should be prepared to handle potential errors during the RMI communication, such as network issues or server unavailability.

## Running the Client-Side Code

To run the client-side code:

1. Ensure the server-side is up and running with the RMI registry and MySQL database configured.
2. Compile the client-side code using the appropriate Java compiler.
3. Run the client-side code using the `java` command.

Remember to run the client-side code on a separate machine from the server-side, and ensure both machines can reach each other through their static IP addresses.
