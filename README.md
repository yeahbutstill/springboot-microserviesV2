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

### Insert

```mysql
insert into currency_exchange (id, created, created_by, updated, updated_by, status_record, reference, currency_from, currency_to, conversion_multiple, environment)
values ('test001', '2021-07-31 23:37:08.975283', 'Artivisi',
        '2021-07-31 23:37:08.975283', 'Artivisi', 'ACTIVE', 'usdtoidr', 'USD', 'IDR', 14895.05, '');
insert into currency_exchange (id, created, created_by, updated, updated_by, status_record, reference, currency_from, currency_to, conversion_multiple, environment)
values ('test002', '2021-07-31 23:37:08.975283', 'Artivisi',
        '2021-07-31 23:37:08.975283', 'Artivisi', 'ACTIVE', 'usdtoinr', 'USD', 'INR', 79.85, '');
insert into currency_exchange (id, created, created_by, updated, updated_by, status_record, reference, currency_from, currency_to, conversion_multiple, environment)
values ('test003','2021-07-31 23:37:08.975283', 'Artivisi',
        '2021-07-31 23:37:08.975283', 'Artivisi', 'ACTIVE', 'eurtoidr', 'EUR', 'IDR', 14808.21, '');
insert into currency_exchange (id, created, created_by, updated, updated_by, status_record, reference, currency_from, currency_to, conversion_multiple, environment)
values ('test004', '2021-07-31 23:37:08.975283', 'Artivisi',
        '2021-07-31 23:37:08.975283', 'Artivisi', 'ACTIVE', 'audtoidr', 'AUD', 'IDR', 10273.95, '');
```

### API
```text
# Currency Conversion Service
http://localhost:8100/yeahbutstill/api/v1/currency-conversion/from/USD/to/IDR/quantity/10

# Currency Exchange Service
http://localhost:8001/yeahbutstill/api/v1/currency-exchange/from/USD/to/IDR
```