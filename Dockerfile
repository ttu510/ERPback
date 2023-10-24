FROM openjdk:11.0.16
ADD build/libs/ProjectFinal-0.0.1-SNAPSHOT.jar /erp.jar
ENV PORT 2580
EXPOSE $PORT
ENTRYPOINT ["java","-jar","/erp.jar"]



