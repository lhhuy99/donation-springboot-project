# donation-springboot-project

## Project Introduction
This Donation Project is a web application designed to facilitate charitable donations.

## Functional Description
The project offers the following functionalities:
  1. User: access http://localhost:8080/
    - View Donation Campaigns
    - Make a Donation
    - View Donation History
  2. Admin: access http://localhost:8080/adminHomePage/home
    - Manage Users (create, read, update, delete)
    - Manage Donation Campaigns (create, read, update, delete)
     
## Deployment Guide (on local)
### Prerequisites:
  - Java 17 or higher
  - Maven installed
  - MySQL
  - Eclipse (or any Java IDE)
To run the project locally, follow these steps:
  1. Clone the Repository:
    git clone https://github.com/lhhuy99/donation-springboot-project.git
  2. Open project and run 2 file sql in mysql-setup folder
  3. Build the project using Maven: mvn clean install
  4. Run the application: mvn spring-boot:run
  5. On browser access:
     - For user: http://localhost:8080/
     - For admin: http://localhost:8080/adminHomePage/home 
