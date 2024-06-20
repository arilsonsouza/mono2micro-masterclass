quarkus dev

curl http://localhost:8083/orders
curl http://localhost:8083/orders/1
curl -d "{ \"fromAirport\": \"GRU\", \"toAirport\": \"JFK\", \"nights\": 21}" -H "Content-Type: application/json" http://localhost:8083/orders


curl http://localhost:8081/flights
curl http://localhost:8081/flights/1
curl -d "{\"orderid\": 1, \"fromAirport\": \"GRU\", \"toAirport\": \"JFK\" }" -H "Content-Type: application/json" http://localhost:8081/flights


curl http://localhost:8083/hotels
curl http://localhost:8083/hotels/1
curl -d "{\"orderid\": 1, \"nights\": 30 }" -H "Content-Type: application/json" http://localhost:8083/hotels



http://localhost:8083/q/dev-ui/dev-services


while true; do  curl http://localhost:8083/orders; sleep .3; done


./mvnw quarkus:add-extension -Dextensions="io.quarkus:quarkus-container-image-jib"

./mvnw quarkus:add-extension -Dextensions="io.quarkus:quarkus-kubernetes"

https://dsri.maastrichtuniversity.nl/docs/openshift-install/

https://console.redhat.com/openshift/sandbox

oc version

oc login --token=<token>

kubectl get pods

kubectl apply -f postgres.yaml


docker login


mvn clean package -Dquarkus.kubernetes.deploy=true


kubectl get svc


oc expose svc flight-app

oc expose svc hotel-app

oc expose svc hotel-app

kubectl get routes
