FROM openjdk:17-jdk
COPY book-exporer.jar book-exporer.jar
EXPOSE 8080
CMD ["java","-jar","book-exporer.jar"]