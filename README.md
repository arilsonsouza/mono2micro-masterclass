```shell
quarkus dev
```

```shell
curl http://localhost:8083/orders

curl http://localhost:8083/orders/1

curl -d "{ \"fromAirport\": \"GRU\", \"toAirport\": \"JFK\", \"nights\": 21}" -H "Content-Type: application/json" http://localhost:8083/orders

```

```shell
curl http://localhost:8081/flights

curl http://localhost:8081/flights/1

curl -d "{\"orderid\": 1, \"fromAirport\": \"GRU\", \"toAirport\": \"JFK\" }" -H "Content-Type: application/json" http://localhost:8081/flights
```

```shell
curl http://localhost:8083/hotels

curl http://localhost:8083/hotels/1

curl -d "{\"orderid\": 1, \"nights\": 30 }" -H "Content-Type: application/json" http://localhost:8083/hotels
```

```shell
http://localhost:8083/q/dev-ui/dev-services
```

```shell
while true; do  curl http://localhost:8083/orders; sleep .3; done
```

```shell
./mvnw quarkus:add-extension -Dextensions="io.quarkus:quarkus-container-image-jib"
```

```shell
./mvnw quarkus:add-extension -Dextensions="io.quarkus:quarkus-kubernetes"
```

```shell
https://dsri.maastrichtuniversity.nl/docs/openshift-install/
```

```shell
https://console.redhat.com/openshift/sandbox
```

```shell
oc version
```

```shell
oc login --token=<token>
```

```shell
kubectl get pods
```
```shell
kubectl apply -f postgres.yaml
```

```shell
docker login
```

```shell
mvn clean package -Dquarkus.kubernetes.deploy=true
```

```shell
kubectl get svc
```

```shell
oc expose svc flight-app
```

```shell
oc expose svc hotel-app
```

```shell
oc expose svc order-app
```

```shell
kubectl get routes
```

```shell
curl http://order-app-arilson-dev.apps.sandbox-m2.ll9k.p1.openshiftapps.com/orders

curl http://order-app-arilson-dev.apps.sandbox-m2.ll9k.p1.openshiftapps.com/orders/1

curl -d "{ \"fromAirport\": \"GRU\", \"toAirport\": \"JFK\", \"nights\": 21}" -H "Content-Type: application/json" http://order-app-arilson-dev.apps.sandbox-m2.ll9k.p1.openshiftapps.com/orders
```
