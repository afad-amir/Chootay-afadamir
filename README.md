# Chootay-afadamir
Spring Boot Application (Inventory and sales management system) with REST Api's and Spring Security

# Prereqs
1-> Eclipes IDE For Java
#
2-> JDK
#
3-> STS(Spring Tool Suit) for Esclipes
# Setup steps
Create New Project -> Spring Boot Project -> Filling Details (Java 1.8) 
#
-> Selecting Required tools(Spring Secrity, Spring Data JPA, Spring Security , MySql Driver , Spring Web and Spring Dev Tools)

# The Show Begins :)
Initially I commented out the Spring Security Dependecy so that i can work on apis first.
#
I Started With Entities(Models) specifying database Schema for each table as per requiment defined each aspect using anotiation (@Entity, @table, @UniqueConstraint, @GeneratedValue,@Id)
#
Then Gradully made my way to Repository Interfaces for all my Entities which extended CrudRepository( which is a genaric CRUD repo) it takes Entity Object as input and Provides 
prebuilt functions which we can tweak if required.
#
The Repo Interface is consumed by the Service for CRUD operations Service is also configured Using anotations @Service and @Autowired in my case.
#
Finally the @RestConroller For Rest end point configuration and consumption of Service Writen for performing all the methods defined as per requirement.
#
After testing api i moved on with Spring Security configured Security Authenticaion and Authorization for Each User Role (Admin,Mechanic,Sales person,Account Manager) I used Default Login provided 
by Spring Security and provided the Credentials and using JDBC Authentioon as the sechma i designed was bit diffrent then default used by spring so I maually fetched the data as per 
required format and passed to spring Security along with that I configured My user service So that Password can be ancrypted while creation of user.
#
After Configuring Security i created a UI for User Creation and it showed some issues after resolving them it is the time i am Pushing it here.
# DataBase
I have used Mysql db for this i didn't set the dialect of sql the default dialect it was using (8.*) meet the specs requiremwnts mentioned.


# Api End-points:

# For Users:
GET /users,/user/{id} POST /users PUT /users/{id} DELETE /users/{id}
# For Roles:
GET /roles,/roles/{id} POST /roles PUT /users/{id} DELETE /roles/{id}
# For UserRole 
GET /userrole,/userrole/{id} POST /userrole PUT /userrole/{id} DELETE /userrole/{id}
# For Customer 
GET /customer,/customer/{id} POST /customer PUT /customer/{id} DELETE /customer/{id}
# For Customer 
GET /customer,/customer/{id} POST /customer PUT /customer/{id} DELETE /customer/{id}
# For Spare Parts parts
GET /parts,/parts/{id} POST /parts PUT /parts/{id} DELETE /parts/{id}
#For Inventory 
GET /inventory,/inventory/{id} POST /inventory PUT /inventory/{id} DELETE /inventory/{id}
# For Bike 
GET /bike,/bike/{id} POST /bike PUT /bike/{id} DELETE /bike/{id}
# For User Addition View
GET /adduser
