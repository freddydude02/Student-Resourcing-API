# Student Resourcing API  

**Description:**
My first Spring Project from a year ago. A spring app that has basic crud functionality. Originally used to learn AWS Beanstalk deployment as well, but data is now stored in the local instance of SQL database instead of AWS RDS. 

**Setup:**
- clone repo
- edit the application.properties file to match the SQL info i.e usename, password and database url
- run code

**Postman Endpoints:**
Get - /students - get all students
Get - /students/{id} - get specific student
Post - /students/{id} - create new student
Patch - /students/{id} - update student details
Delete - /students - get all students

**What I'd do differently next time:**
- During initialisation, I added lombok, but havent used in the future, I may return to refactor the code using lombok
- add testing so test my application for edgecases and for correct responses

**Challenges:**
As it was my first spring I was difficult keeping track of and learning each of the entity related classes that were required for running the API's.
- Spring structure - entity, dto, repository, service & controller
- familiarising with the appropriate response entities for each request(utilising optional<> to avoid calling methods on null values)
- learning new annotations

**future goals:**
- learn to manage multiple entities and manage them by implementing JPA relationships
- Implemnt JWT authentication
- implement Swagger UI
