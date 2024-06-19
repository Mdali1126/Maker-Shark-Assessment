Mahammed ali, cmdali235@gmail.com

USER REGISTRATION AND FETCH API'S ALSO HAVE UPDATE AND DELETE API'S FOR USER WITH JWT TOKEN AUTHENTICATION WITH POSTGRESQL DATABASE.
REQUIREMENTS:                                                                                                                                             
- Java 17 or higher                                                                                                                                       
- Apache Maven 3.9.6 
- SpringBoot 3.3.0
- Spring Security 6.3.0
- jjwt token,impl,jackson 0.11.5
  
SECURITY:
-> Jwt token authentication is provided to secure Endpoints without authentication.
  
This project is a simple RESTful API built with Spring Boot that allows users to register and fetch their details.
-> First time user can register by providing details in like username,password and email and will receive a jwt token in response for authentication for further apis
-> If user is already registered can enter username and password and can get jwt token in response for further apis
-> If credentials are wrong user cant access the apis.

ENDPOINTS:
-> POST API  - http://localhost:8888/api/user/register (for new user registration)
Request body
{
"username":"",
"password":"",
"email":""
}
In response you will get a jwt token which can be used for accessing other apis.
----------------------------------------------------------------------------------------------------------------------------
-> POST API - http://localhost:8888/api/user/login (for existing user)
Request body
{
"username":"",
"password":"",
}
In response you will get a jwt token which can be used for accessing other apis.[201.created]
------------------------------------------------------------------------------------------------------------------------------
-> POST API - http://localhost:8888/api/user/login (for existing user)
Request body
{
"username":"",
"password":""
}
In response you will get a jwt token which can be used for accessing other apis.[200.ok]
------------------------------------------------------------------------------------------------------------------------------
-> GET API - http://localhost:8888/api/user/fetch/username (for existing user token is requires)
PATH VARIABLE - provide username in the path variable
Response - you will get user details.[200.ok]
-------------------------------------------------------------------------------------------------------------------------------
-> PUT API - http://localhost:8888/api/user/update/username (for existing user token is requires)
PATH VARIABLE - provide username in the path variable
Request body
{
"username":"",
"password":"",
"email":""
}
Response - you will get Updated user details [200.0k]
----------------------------------------------------------------------------------------------------------------------------
-> DELETE API - http://localhost:8888/api/user/delete/username (for existing user token is requires)
PATH VARIABLE - provide username in the path variable
Response - you will get user details deleted message.[200.ok]
