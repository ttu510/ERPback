FROM openjdk:11.0.16
ADD build/libs/ProjectFinal-0.0.1-SNAPSHOT.jar /erp.jar
ENTRYPOINT ["java","-jar","/erp.jar"]



