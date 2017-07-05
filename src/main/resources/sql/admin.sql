-- database
DROP DATABASE IF EXISTS workshop;
CREATE DATABASE workshop TEMPLATE template0;

-- user
-- DROP USER IF EXISTS spring;
-- CREATE USER spring WITH PASSWORD 'spring123';

-- privileges
GRANT ALL PRIVILEGES ON DATABASE workshop TO spring;
GRANT USAGE ON SCHEMA public TO spring;
ALTER USER spring WITH SUPERUSER;
