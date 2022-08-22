# springboot-microserviesV2

## Setup git cofig-repo
```shell
$ cd $HOME
$ mkdir config-repo
$ cd config-repo
$ git init .
$ echo info.foo: bar > limits-service-dev.properties
$ echo info.foo: bar > limits-service-qa.properties
$ echo info.foo: bar > limits-service.properties
$ git add -A .
$ git commit -m "Add application.properties"
```

```properties
# default
limits-service.minimum=4
limits-service.maximum=996

#qa
limits-service.minimum=6
limits-service.maximum=994

#dev
limits-service.minimum=5
limits-service.maximum=995

```

```shell
# Currency Exchange Service
http://localhost:8000/currency-exchange/from/USD/to/IDR

# Currency Conversion Service
http://localhost:8000/currency-exchange/from/USD/to/IDR/quantity/10
```