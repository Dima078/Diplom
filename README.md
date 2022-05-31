# запуск контейнера

> docker-compose up

# запуск jar файла

>java -jar artifacts/aqa-shop.jar

# запустить тесты с отчетом Allure

> ./gradlew clean test allureReport

# запустить просмотр отчета Allure

> ./gradlew allureServe

> ./gradlew test -Dspring.datasource.url=jdbc:mysql://localhost:3306/app


# Для подключение к базе вручную использовать команду
> docker-compose exec mysql mysql -u dima -p app

> password: pass