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

# Eureka
http://localhost:8761

# Route Discovery Disabled and Custom Routes Configured
http://localhost:8765/yeahbutstill/api/v1/currency-exchange/from/USD/to/IDR
http://localhost:8765/yeahbutstill/api/v1/currency-conversion/from/USD/to/IDR/quantity/10
http://localhost:8765/yeahbutstill/api/v1/currency-conversion-feign/from/USD/to/IDR/quantity/10
http://localhost:8765/yeahbutstill/api/v1/currency-conversion-new/from/USD/to/IDR/quantity/10

# Discovery
http://localhost:8765/CURRENCY-EXCHANGE/yeahbutstill/api/v1/currency-exchange/from/USD/to/IDR
http://localhost:8765/CURRENCY-CONVERSION/yeahbutstill/api/v1/currency-conversion/from/USD/to/IDR/quantity/10
http://localhost:8765/CURRENCY-CONVERSION/yeahbutstill/api/v1/currency-conversion-feign/from/USD/to/IDR/quantity/10

#LowerCase
http://localhost:8765/currency-exchange/yeahbutstill/api/v1/currency-exchange/from/USD/to/IDR
http://localhost:8765/currency-conversion/yeahbutstill/api/v1/currency-conversion/from/USD/to/IDR/quantity/10
http://localhost:8765/currency-conversion/yeahbutstill/api/v1/currency-conversion-feign/from/USD/to/IDR/quantity/10
```

### Zipkin
```shell
docker run -p 9411:9411 openzipkin/zipkin
```

### Build Docker Image 
To create the docker group and add your user:
```shell
sudo groupadd docker
```

Add your user to the docker group.
```shell
sudo usermod -aG docker $USER
```

Log out and log back in so that your group membership is re-evaluated.
If testing on a virtual machine, it may be necessary to restart the virtual machine for changes to take effect.
On a desktop Linux environment such as X Windows, log out of your session completely and then log back in.
On Linux, you can also run the following command to activate the changes to groups:
```shell
newgrp docker
```