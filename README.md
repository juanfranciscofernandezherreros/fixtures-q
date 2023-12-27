
Primero devuelve toda la informacion sin ningun parametro

curl -X GET "http://localhost:8099/api/fixtures"

$ curl -X GET "http://localhost:8099/api/fixtures/1"

Solo con nombre de equipo local

$ curl -X GET "http://localhost:8099/api/fixtures?homeTeam=Murcia"

Solo con nombre de equipo visitante

$ curl -X GET "http://localhost:8099/api/fixtures?awayTeam=Murcia"

Equipos locales y visitants

$ curl -X GET "http://localhost:8099/api/fixtures?homeTeam=Tenerife&awayTeam=Tenerife"

fecha

curl -X GET "http://localhost:8099/api/fixtures?homeTeam=Valencia&awayTeam=Granada&country=spain&league=acb"

curl -X POST -H "Content-Type: application/json" -d '[
{
"matchId": "1",
"eventTime": "2023-12-24T12:00:00Z",
"homeTeam": "TeamA",
"awayTeam": "TeamB",
"country": "CountryA",
"league": "LeagueA",
"action": "ActionA",
"hasExecuted": true
},
{
"matchId": "2",
"eventTime": "2023-12-25T15:30:00Z",
"homeTeam": "TeamC",
"awayTeam": "TeamD",
"country": "CountryB",
"league": "LeagueB",
"action": "ActionB",
"hasExecuted": false
}
]' http://localhost:8099/api/fixtures

curl -X DELETE -H "Content-Type: application/json" -d '["1", "2", "3"]' http://localhost:8099/api/fixtures/deleteByIds

curl -X PUT -H "Content-Type: application/json" -d '[
{
"matchId": "1",
"eventTime": "2023-12-24T12:00:00Z",
"homeTeam": "TeamAA",
"awayTeam": "TeamBB",
"country": "CountryAA",
"league": "LeagueAA",
"action": "ActionAA",
"hasExecuted": true
},
{
"matchId": "2",
"eventTime": "2023-12-25T15:30:00Z",
"homeTeam": "TeamCC",
"awayTeam": "TeamDD",
"country": "CountryBB",
"league": "LeagueBB",
"action": "ActionBB",
"hasExecuted": false
}
]' http://localhost:8099/api/fixtures