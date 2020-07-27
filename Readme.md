**<h1>Spring Boot CRUD application: Leave Details</h1>**

**<h3>Java Assignment Group 02: CRUD Application using SpringBoot Rest Api using JDBC Connection</h3>**

**<h4>API USED</h4>**

1. /leaves
   1. Type: POST
   2. Should accept Json
   3. apply a new leave with following fields: reason, startDate, endDate, isHalfDay (boolean), leaveType (CL, PL, LWP), status (applied, approved, rejected, availed), appliedDate, updatedDate

2. /leaves/{leaveId}
   1. Type: PUT
   2. Should accept Json
   3. Update a particular leave, leaveId is mandatory.
   
3. /leaves
   1. Type: GET
   2. Should return Json
   3. Return all leaves
   
4. /leaves/{statusType}
   1. Type: GET
   2. Should return Json
   3. Return all leaves with status provided
   
5. /leaves/{leaveId}
    1. Type: Delete
    2. Should return Json
    3. Pass the leaveId which needs to be deleted
    
**<h4>Schema Table**

**Database Name:** leave_details
**Table Name:** leavedetails

LeaveId | reason | startDate | endDate | isHalfDay | leaveType | status | appliedDate | updatedDate

**<h3>Database Configuration</h3>**

*<b>application.properties file</b>*

```
#spring.datasource.driver-class-name=com.mysql.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/leave_details
spring.datasource.username=springuser
spring.datasource.password=171999@
spring.datasource.tomcat.max-wait=20000
spring.datasource.tomcat.max-active=50
spring.datasource.tomcat.max-idle=20
spring.datasource.tomcat.min-idle=15

spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQLDialect
spring.jpa.properties.hibernate.id.new_generator_mappings = false
spring.jpa.properties.hibernate.format_sql = true
spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl

logging.level.org.hibernate.SQL=DEBUG
logging.level.org.hibernate.type.descriptor.sql.BasicBinder=TRACE
```

**<h3>Process to Run the Application</h3>**

**<h4>1. Right click on Application.java file and run as Java Application**

<h4><b>Once Spring Boot Application will be started successfully then we</b></h4>

1. To get list of leave details following endpoint with **GET** Request
```http://localhost:8080/leave/leaves```

2. To Apply New Leave use following usrl with **POST** Request

```http://localhost:8080/leave/leaves```

set content type as in header as <h3>```application/json```</h3>

<b>set request body as raw with json payload</b>

```aidl
{
    "id": 102,
    "reason": "Covid19",
    "startDate": "2020-07-27",
    "endDate": "2020-08-20",
    "isHalfDay": false,
    "leaveType": "PL",
    "status": "Applied",
    "appliedDate": "2020-07-27",
    "updatedDate": "2020-08-16"
}
```

**3. To get particular leave detail, use following url with ```GET``` request type in postman**

```aidl
http://localhost:8080/leave/leaves/<id>
```

**4.To update Book in database, use following url with ```PUT``` request type in postman**

```http://localhost:8080/leave/leaves/<id>```

set content type as in header as <h3>```application/json```</h3>
set request body as raw with JSON payload

```aidl
{
    "reason": "Covid19",
    "startDate": "2020-07-28",
    "endDate": "2020-08-15",
    "isHalfDay": false,
    "leaveType": "PL",
    "status": "Applied",
    "appliedDate": "2020-07-27",
    "updatedDate": "2020-08-16"
}
```

**5. To delete a particular leave detail from database, use following url with ```DELETE``` request type in postman**
```aidl
http://localhost:8080/leave/leaves/<id>
```
**<h3>Note - Replace with actual id</h3>**

<h2>**Render Swagger-UI to display API documentation**</h2>
**Add dependency to ```pom.xml``` file**
```puml
<dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger2</artifactId>
            <version>2.9.2</version>
        </dependency>

        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger-ui</artifactId>
            <version>2.9.2</version>
        </dependency>
```

