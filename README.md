# запуск контейнера

> docker-compose up

# запуск приложения
### с подключением MySQL
>java -jar .\artifacts\aqa-shop.jar "-Dspring.datasource.url=jdbc:mysql://localhost:3306/app"

### с подключением PostgreSQL
>java -jar .\artifacts\aqa-shop.jar "-Dspring.datasource.url=jdbc:postgresql://localhost:5432/app"


# запуск тестов
### с подключением MySQL
> ./gradlew clean test -Durl=jdbc:mysql://localhost:3306/app

### с подключением PostgreSQL
> ./gradlew clean test -Durl=jdbc:postgresql://localhost:5432/app

# запустить просмотр отчета Allure

> ./gradlew allureReport

> затем

> ./gradlew allureServe


# Для подключение к базе вручную использовать команду
> docker-compose exec mysql mysql -u dima -p app

> password: pass