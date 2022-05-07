# ConnectToMySql
Connect to MySQL Docker Container from Intellij Database

as connecting to local MySQL docker container. 
It may cause a following error.

Cannot connect to database server
Communications link failure

The last packet sent successfully to the server was 0 milliseconds ago. 
The driver has not received any packets from the server.
com.mysql.jdbc.exceptions.jdbc4.CommunicationsException: Communications link failure

MySQl server may cannot recognize 'localhost' and port number.
So it needs to specify when starting MySQL docker container. 

docker run --name mysql -e MYSQL_ROOT_PASSWORD=test -d -p 127.0.0.1:3306:3306 mysql:latest


