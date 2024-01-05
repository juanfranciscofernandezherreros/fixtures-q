curl -X GET "http://localhost:8099/api/fixtures?dates=2024-01-05,2023-12-24,2024-01-02" -H "Content-Type: application/json"

curl -X GET "http://localhost:8099/api/fixtures?today" -H "Content-Type: application/json"

curl -X GET "http://localhost:8099/api/fixtures?tomorrow" -H "Content-Type: application/json"

curl -X GET "http://localhost:8099/api/fixtures?homeTeam=Real%20Madrid&awayTeam=Real%20Madrid&country=spain&league=acb"

curl -X GET "http://localhost:8099/api/fixtures?country=spain&league=acb"

