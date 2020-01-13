FROM hub.c.163.com/library/java:8-alpine

MAINTAINER QINHAO qinpiyi@126.com

ADD target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]