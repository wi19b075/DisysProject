CREATE TABLE customers
(
    customer_id SERIAL PRIMARY KEY ,
    customer_lastname      VARCHAR(50) NOT NULL,
    customer_firstname VARCHAR(50) NOT NULL,
    customer_street    VARCHAR(50) NOT NULL,
    customer_city      VARCHAR(50) NOT NULL,
    customer_zip       INT NOT NULL
);

CREATE TABLE processes
(
    process_id      SERIAL PRIMARY KEY,
    customer_id     INT NOT NULL references Customers(customer_id),
    station_id      INT NOT NULL references ChargingStations(station_id),
    charging_date   DATE NOT NULL,
    charging_amount FLOAT NOT NULL
);

CREATE TABLE stations
(
    station_id SERIAL PRIMARY KEY,
    available  bool      NOT NULL,
    latitude   FLOAT NOT NULL,
    longitude  FLOAT NOT NULL
);

