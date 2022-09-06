# EoD-app

Example Service Spring Boot EoD Service MultiTread Execution

## What's inside 
- Maven 
- Spring Boot v2.7.3
- Multitread Execution Simple

## Usage Run  
Run the project through the IDE and head out to [http://localhost:8080/v1/eodProcess](http://localhost:8080/v1/eodProcess)

or 

run this command in the command line:
mvn clean install
mvn spring-boot:run

## Specific API
1 . Used Postman or Other Platform API
2. call Api http://localhost:8080/v1/eodProcess : Method POST
3. Payload Body form-data 
    - Key : file 
    - value : csv (Before Eod.csv) (src/main/resource/Before Eod.csv)

![Screenshot from 2022-09-06 14-24-03](https://user-images.githubusercontent.com/19750255/188572516-1a376484-98e9-43b4-9ff8-dd6a8ed270fe.png)


## Response API 
Response Produces CSV 

![Screenshot from 2022-09-06 14-22-23](https://user-images.githubusercontent.com/19750255/188572134-f53f6533-dca2-4364-b3e2-09fd100d0aa9.png)
