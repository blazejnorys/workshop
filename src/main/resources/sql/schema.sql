DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS customer;

CREATE TABLE employee (
  id BIGSERIAL NOT NULL PRIMARY KEY,
  employeename TEXT NOT NULL,
  employeesurname TEXT NOT NULL
);
CREATE TABLE customer (
  id BIGSERIAL NOT NULL PRIMARY KEY,
  customername TEXT NOT NULL,
  customersurname TEXT NOT NULL,
  car TEXT NOT NULL,
  phonenumber INTEGER NOT NULL
);

INSERT INTO employee (employeename, employeesurname) VALUES ('MIETEK', 'MIETKOWSKI');
INSERT INTO employee (employeename, employeesurname) VALUES ('KAZEK', 'KAZOWSKI');
INSERT INTO employee (employeename, employeesurname) VALUES ('BORYS', 'BORYSEWICZ');
INSERT INTO employee (employeename, employeesurname) VALUES ('OWCZAREK', 'NIEMIECKI');

INSERT INTO customer (customername, customersurname, car, phonenumber) VALUES ('ROMAN', 'TYTANOWY','PASSAT',500100200);
INSERT INTO customer (customername, customersurname, car, phonenumber) VALUES ('STANISLAW', 'BLO','GOLF',600200300);
INSERT INTO customer (customername, customersurname, car, phonenumber) VALUES ('PREZES', 'WSZYSTKICH','SKODICZI',500600100);
INSERT INTO customer (customername, customersurname, car, phonenumber) VALUES ('OGÓREK', 'POLSKI','BORA',900800100);