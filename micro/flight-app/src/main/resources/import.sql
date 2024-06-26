-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(1, 'field-1');
-- insert into myentity (id, field) values(2, 'field-2');
-- insert into myentity (id, field) values(3, 'field-3');
-- alter sequence myentity_seq restart with 4;
CREATE SEQUENCE flights_sequence START WITH 1 INCREMENT BY 1;
INSERT INTO flights(id, orderid, fromAirport, toAirport) VALUES(nextval('flights_sequence'), 1, 'GRU', 'MCO');
INSERT INTO flights(id, orderid, fromAirport, toAirport) VALUES(nextval('flights_sequence'), 2, 'GRU', 'JFK');
INSERT INTO flights(id, orderid, fromAirport, toAirport) VALUES(nextval('flights_sequence'), 3, 'GRU', 'ATL');
INSERT INTO flights(id, orderid, fromAirport, toAirport) VALUES(nextval('flights_sequence'), 4, 'GRU', 'MEX');
