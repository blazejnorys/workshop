DROP TABLE IF EXISTS employee;

CREATE TABLE employee (
  id BIGSERIAL NOT NULL PRIMARY KEY,
  employeename TEXT NOT NULL,
  employeesurname TEXT NOT NULL
);

INSERT INTO employee (employeename, employeesurname) VALUES ('MIETEK', 'MIETKOWSKI');
INSERT INTO employee (employeename, employeesurname) VALUES ('KAZEK', 'KAZOWSKI');
INSERT INTO employee (employeename, employeesurname) VALUES ('BORYS', 'BORYSEWICZ');
INSERT INTO employee (employeename, employeesurname) VALUES ('OWCZAREK', 'NIEMIECKI');