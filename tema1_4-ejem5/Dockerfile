FROM maven as builder
RUN apt-get update; apt-get install -y netcat
RUN mkdir /project
COPY . /project/
WORKDIR /project
RUN mvn clean package -B -DskipTests=true 
RUN chmod 777 /project/run.sh
EXPOSE 8080
CMD ["/project/run.sh"]
