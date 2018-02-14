FROM maven as builder
RUN apt-get update; apt-get install -y netcat
RUN mkdir /project
WORKDIR /project
COPY * /project/
RUN mvn package -DskipTests=true 
RUN chmod 777 /project/run.sh
EXPOSE 8080
CMD ["/project/run.sh"]

#FROM openjdk:8-jre
#COPY --from=builder /project/target/app.jar .
#CMD ["run.sh"]