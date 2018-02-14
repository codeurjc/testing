#!/bin/sh
while ! nc -z db 3306 ; do
    echo "Waiting for MySQL server to be abailable"
    sleep 2
done

exec java -jar -Dspring.datasource.url=jdbc:mysql://db/test app.jar