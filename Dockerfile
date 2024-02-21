FROM openjdk:17-jdk-slim-buster

WORKDIR /app

# gitignore에 build가 ignore 처리되어있기 때문에 jar파일을 Docker파일이 있는 디렉토리로 복사 시킨뒤 git push
COPY order-0.0.1-SNAPSHOT.jar app.jar

CMD ["java", "-jar", "app.jar"]