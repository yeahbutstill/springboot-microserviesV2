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

### Setup Docker MySQL
```shell
 docker run --rm \
  --name=currency-exchange-db \
  -e MYSQL_DATABASE=currency-exchangedb \
  -e MYSQL_ROOT_PASSWORD=JBJwTMMYyZ8yy8eBaY3kPb6p \
  -e TZ=Asia/Jakarta \
  -p 6603:3306 \
  -v "$PWD/docker/currency-exchange-db/conf.d":/etc/mysql/conf.d \
  -v "$PWD/storage/docker/currency-exchange-data":/var/lib/mysql \
  mysql
```

```mysql
insert into currency_exchange (currency_from, currency_to, conversion_multiple, environment)
values ('USD', 'IDR', 14895.05, '');
insert into currency_exchange (currency_from, currency_to, conversion_multiple, environment)
values ('USD', 'INR', 79.85, '');
insert into currency_exchange (currency_from, currency_to, conversion_multiple, environment)
values ('EUR', 'IDR', 14808.21, '');
insert into currency_exchange (currency_from, currency_to, conversion_multiple, environment)
values ('AUD', 'IDR', 10273.95, '');
```