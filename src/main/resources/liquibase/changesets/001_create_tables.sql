create table sensor
(
    id   serial primary key,
    name varchar(100) not null unique
);

create table measurement
(
    id                    serial primary key,
    value                 double precision not null,
    raining               boolean          not null,
    measurement_date_time timestamp        not null,
    type                  varchar(128)     not null,
    sensor                varchar(100) references Sensor (name)
);