
Primero devuelve toda la informacion sin ningun parametro

curl -X GET "http://localhost:8099/api/fixtures"

Solo con nombre de equipo local

$ curl -X GET "http://localhost:8099/api/fixtures?homeTeam=Murcia"

Solo con nombre de equipo visitante

$ curl -X GET "http://localhost:8099/api/fixtures?awayTeam=Murcia"

Equipos locales y visitants

$ curl -X GET "http://localhost:8099/api/fixtures?homeTeam=Tenerife&awayTeam=Tenerife"

fecha

curl -X GET "http://localhost:8099/api/fixtures?homeTeam=Valencia&awayTeam=Granada&country=spain&league=acb"
