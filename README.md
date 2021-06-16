# RabbitMqProject
Реализация RPC с использованием RabbitMq.
Producer - содержит REST API для вызова удаленных процедур, EntityServiceModule - содержит набор сущностей и сервисов, MarvelHero - реализация методов сервиса MarvelHeroService из EntityServiceModule.
Запуск rabbitMq в докере: docker run -d -p 5672:5672 -p 15672:15672 --name my-rabbit rabbitmq:3-management
Веб - интерфейс доступен по адресу: http://localhost:15672 с username:guest и password:guest
Запуск MarvelHero: 
cd MarvelHero
mvn spring-boot:run
Запуск Producer:
cd Producer
mvn spring-boot:run
Проверка:
GET http://localhost:8080/front/marvel/1
Ответ:
{
    "id": 1,
    "name": "Captain America",
    "age": 34,
    "origin": "USA"
}
