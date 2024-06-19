quarkus dev

curl http://localhost:8080/orders
curl http://localhost:8080/orders/1
curl -d "{ \"fromAirport\": \"GRU\", \"toAirport\": \"JFK\", \"nights\": 21}" -H "Content-Type: application/json" http://localhost:8080/orders


curl http://localhost:8080/flights
curl http://localhost:8080/flights/1
curl -d "{\"orderid\": 1, \"fromAirport\": \"GRU\", \"toAirport\": \"JFK\" }" -H "Content-Type: application/json" http://localhost:8080/flights


curl http://localhost:8080/hotels
curl http://localhost:8080/hotels/1
curl -d "{\"orderid\": 1, \"nights\": 30 }" -H "Content-Type: application/json" http://localhost:8080/hotels



http://localhost:8080/q/dev-ui/dev-services


while true; do  curl http://localhost:8083/orders; sleep .3; done
