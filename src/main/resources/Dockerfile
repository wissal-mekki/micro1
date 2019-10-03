#FROM mysql:5.7.15

#MAINTAINER me

#ENV MYSQL_DATABASE=micro1\
#MYSQL_ROOT_PASSWORD=26156276
# MYSQL_ROOT_PASSWORD=26156276
#- MYSQL_DATABASE=micro1
 #MYSQL_PASSWORD=26156276

#ADD   micro1dump.sql  /docker-entrypoint-initdb.d
#VOLUME ./:/docker-entrypoint-initdb.d/micro1dump.sql
 #VOLUME ../../../dump.sql:/docker-entrypoint-initdb.d/
#EXPOSE 3306
FROM mysql:latest

#ENV MYSQL_USER root
ENV MYSQL_ROOT_PASSWORD 26156276
ENV MYSQL_DATABASE micro1
#ENV MYSQL_PASSWORD 26156276


ADD micro1.sql /docker-entrypoint-initdb.d


EXPOSE 3306

# Copy the database schema to the /data directory
#ADD run_db init_db micro1dump.sql /tmp/
#RUN chmod +x /tmp/init_db
# init_db will create the default
# database from epcis_schema.sql, then
# stop mysqld, and finally copy the /var/lib/mysql directory
# to default_mysql_db.tar.gz
#RUN /tmp/init_db

# run_db starts mysqld, but first it checks
# to see if the /var/lib/mysql directory is empty, if
# it is it is seeded with default_mysql_db.tar.gz before
# the mysql is fired up

#ENTRYPOINT "/tmp/run_db"