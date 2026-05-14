# RuSys - Inventory Management System

RuSys is a Java-based Inventory Management System built using the Model-View-Controller (MVC) architecture. It is designed to manage users and administrators with an intuitive desktop interface.

## 🗂 Project Structure

The application is structured to separate concerns and ensure maintainability:

* **Model**: Handles the business logic, database operations, and core data structures.
* **View**: Contains the graphical user interfaces built with Java Swing. Key interfaces include:
  * `Welcome`: The landing page of the application.
  * `Login`: The secure authentication interface.
  * `Admin`: The dashboard and controls for administrator tasks.
  * `User`: The primary interface for standard user operations.
* **Controller**: Bridges the communication between the Model and View layers, ensuring a decoupled architecture.
* **assets**: Resources and media used within the application.

## 🛠 Technology Stack

* **Language**: Java
* **UI Framework**: Java Swing
* **Architecture**: MVC (Model-View-Controller)
* **IDE / Build Tool**: NetBeans (Ant build system)

## 🚀 Getting Started

1. Open the project folder `RuSys` in NetBeans IDE.
2. Build the project using the built-in Ant build system (`build.xml` is included).
3. Run the project. The main application entry point typically starts from the `Welcome` or `Login` screen.
