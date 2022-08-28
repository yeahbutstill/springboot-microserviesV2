# Setup Postgre
```shell
docker run --rm \
--name restful-spring-boot-v3 \
-e POSTGRES_DB=springbootdb \
-e POSTGRES_USER=yeahbutstill \
-e POSTGRES_PASSWORD=PNSJkxXvVNDAhePMuExTBuRR \
-e PGDATA=/var/lib/postgresql/data/pgdata \
-v "$PWD/springbootdb-data:/var/lib/postgresql/data" \
-p 5432:5432 \
postgres
```