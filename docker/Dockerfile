FROM postgres:9-alpine

RUN apk update

# Postgress will look for this SQL and run it (creates user and db)
ADD infinitesound_setup.sql /docker-entrypoint-initdb.d/
