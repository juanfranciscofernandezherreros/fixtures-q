curl -X GET "http://localhost:8099/api/fixtures?dates=2024-01-05,2023-12-24,2024-01-02" -H "Content-Type: application/json"

curl -X GET "http://localhost:8099/api/fixtures?today" -H "Content-Type: application/json"

curl -X GET "http://localhost:8099/api/fixtures?tomorrow" -H "Content-Type: application/json"

curl -X GET "http://localhost:8099/api/fixtures?homeTeam=Real%20Madrid&awayTeam=Real%20Madrid&country=spain&league=acb"

curl -X GET "http://localhost:8099/api/fixtures?country=spain&league=acb"

curl -X GET "http://localhost:8099/api/fixtures"

curl -X GET "http://localhost:8099/api/fixtures/g_3_AL2aGoq6"

--
//
curl -X POST -H "Content-Type: application/json" -d '[
{
"matchId": "5",
"eventTime": "2023-12-24T12:00:00Z",
"homeTeam": "TeamA",
"awayTeam": "TeamB",
"country": "CountryA",
"league": "LeagueA",
"action": "ActionA",
"hasExecuted": true
},
{
"matchId": "6",
"eventTime": "2023-12-25T15:30:00Z",
"homeTeam": "TeamC",
"awayTeam": "TeamD",
"country": "CountryB",
"league": "LeagueB",
"action": "ActionB",
"hasExecuted": false
}
]' http://localhost:8099/api/fixtures

--

curl -X DELETE -H "Content-Type: application/json" -d '["1", "2", "3"]' http://localhost:8099/api/fixtures/deleteByIds

--

curl -X GET "http://localhost:8099/api/fixtures/5"