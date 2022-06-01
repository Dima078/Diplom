# запуск контейнера

> docker-compose up

# запуск приложения
### с подключением MySQL
>java "-Dspring.datasource.url=jdbc:mysql://localhost:3306/app" -jar artifacts/aqa-shop.jar

### с подключением PostgreSQL
>java "-Dspring.datasource.url=jdbc:postgresql://localhost:5432/app" -jar artifacts/aqa-shop.jar

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