<h2>Технология разработки ПО</h2>
<h3>Лабораторная работа №1: создание микросервиса на Spring Boot с базой данных</h3>
<p>Кондраков А.В. mac2131</p>
<p>Целью лабораторной работы является знакомство с проектированием многослойной архитектуры Web-API (веб-приложений, микро-сервисов).</p>

<h3>Шаги запуска</h3>
<p>1. ./ mvnw clean install</p>
<p>2. docker build . -t clientsapi</p>
<p>3. docker-compose up</p>

<h4>cUrl запросы</h4>

<p>
curl --location 'http://localhost:8090/cards' \
--header 'Content-Type: application/json'
</p>

<p>
curl --location 'http://localhost:8090/types' \
--header 'Content-Type: application/json'
</p>

<p>
curl --location --request POST 'http://localhost:8090/clients' \
--header 'Content-Type: application/json' \
--data-raw '{
"fio": "Иван Иванов",
"cards": ["123456789021", "123456789031"],
"type": "Corporate"
}'
</p>

<p>
curl --location 'http://localhost:8090/clients/1' \
--header 'Content-Type: application/json'
</p>

<p>
curl --location --request POST 'http://localhost:8090/clients' \
--header 'Content-Type: application/json' \
--data-raw '{
"fio": "Иван Петров",
"cards": ["123456789041", "123456789022"],
"type": "Private"
}'
</p>

<p>
curl --location 'http://localhost:8090/clients/2' \
--header 'Content-Type: application/json'
</p>

<p>
curl --location --request DELETE 'http://localhost:8090/clients/2' \
--data-raw ''
</p>

<p>
curl --location 'http://localhost:8090/hostname'
</p>