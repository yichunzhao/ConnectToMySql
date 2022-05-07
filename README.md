# ConnectToMySql
Connect to MySQL Docker Container from Intellij Database

When connecting to the local MySQL docker container, it may cause the following error.

>Cannot connect to database server
>
>Communications link failure
>
>The last packet sent successfully to the server was 0 milliseconds ago. 
>
>The driver has not received any packets from the server.
>
>com.mysql.jdbc.exceptions.jdbc4.CommunicationsException: Communications link failure

MySQl server cannot recognize 'localhost' and port number. So you need to specify them when running MySQL docker container. 

```
docker run --name mysql -e MYSQL_ROOT_PASSWORD=test -d -p 127.0.0.1:3306:3306 mysql:latest
```


