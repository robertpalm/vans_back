-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2023-05-25 07:28:20.298

-- tables
-- Table: city
CREATE TABLE city
(
    id   serial      NOT NULL,
    name varchar(50) NOT NULL,
    CONSTRAINT city_pk PRIMARY KEY (id)
);

-- Table: driver
CREATE TABLE driver
(
    id           serial       NOT NULL,
    city_id      int          NOT NULL,
    user_id      int          NOT NULL,
    name         varchar(255) NOT NULL,
    license      varchar(11)  NOT NULL,
    phone_number varchar(255) NOT NULL,
    status       char(1)      NOT NULL,
    van_id       int          NULL    ,
    CONSTRAINT driver_pk PRIMARY KEY (id)
);

-- Table: insurance
CREATE TABLE insurance
(
    id           serial       NOT NULL,
    provider     varchar(255) NOT NULL,
    phone_number varchar(255) NOT NULL,
    CONSTRAINT insurance_pk PRIMARY KEY (id)
);

-- Table: maintenance
CREATE TABLE maintenance
(
    id            serial        NOT NULL,
    van_id        int           NOT NULL,
    description   varchar(1000) NOT NULL,
    total_mileage int           NOT NULL,
    date          date          NOT NULL,
    attachment    bytea         NULL    ,
    status        char(1)       NOT NULL,
    CONSTRAINT maintenance_pk PRIMARY KEY (id)
);

-- Table: message
CREATE TABLE message
(
    id               serial        NOT NULL,
    text             varchar(1000) NOT NULL,
    receiver_user_id int           NOT NULL,
    sender_user_id   int           NOT NULL,
    date_time        timestamp     NOT NULL,
    status           char(1)       NOT NULL,
    CONSTRAINT message_pk PRIMARY KEY (id)
);

-- Table: mileage
CREATE TABLE mileage
(
    id     serial NOT NULL,
    van_id int    NOT NULL,
    date   date   NOT NULL,
    km     int    NOT NULL,
    CONSTRAINT mileage_pk PRIMARY KEY (id)
);

-- Table: role
CREATE TABLE role
(
    id        serial       NOT NULL,
    role_name varchar(255) NOT NULL,
    CONSTRAINT role_pk PRIMARY KEY (id)
);

-- Table: user
CREATE TABLE "user"
(
    id       serial       NOT NULL,
    role_id  int          NOT NULL,
    username varchar(255) NOT NULL,
    password varchar(255) NOT NULL,
    status   char(1)      NOT NULL,
    CONSTRAINT user_pk PRIMARY KEY (id)
);

-- Table: van
CREATE TABLE van
(
    id              serial       NOT NULL,
    model           varchar(255) NOT NULL,
    plate_number    varchar(6)   NOT NULL,
    insurance_id    int          NOT NULL,
    city_id         int          NOT NULL,
    next_inspection date         NOT NULL,
    status          char(1)      NOT NULL,
    CONSTRAINT van_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: driver_city (table: driver)
ALTER TABLE driver
    ADD CONSTRAINT driver_city
        FOREIGN KEY (city_id)
            REFERENCES city (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: driver_user (table: driver)
ALTER TABLE driver
    ADD CONSTRAINT driver_user
        FOREIGN KEY (user_id)
            REFERENCES "user" (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: driver_van (table: driver)
ALTER TABLE driver
    ADD CONSTRAINT driver_van
        FOREIGN KEY (van_id)
            REFERENCES van (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: maintenance_van (table: maintenance)
ALTER TABLE maintenance
    ADD CONSTRAINT maintenance_van
        FOREIGN KEY (van_id)
            REFERENCES van (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: message_user_receiver (table: message)
ALTER TABLE message
    ADD CONSTRAINT message_user_receiver
        FOREIGN KEY (receiver_user_id)
            REFERENCES "user" (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: message_user_sender (table: message)
ALTER TABLE message
    ADD CONSTRAINT message_user_sender
        FOREIGN KEY (sender_user_id)
            REFERENCES "user" (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: mileage_van (table: mileage)
ALTER TABLE mileage
    ADD CONSTRAINT mileage_van
        FOREIGN KEY (van_id)
            REFERENCES van (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: user_role (table: user)
ALTER TABLE "user"
    ADD CONSTRAINT user_role
        FOREIGN KEY (role_id)
            REFERENCES role (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: van_city (table: van)
ALTER TABLE van
    ADD CONSTRAINT van_city
        FOREIGN KEY (city_id)
            REFERENCES city (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: van_insurance (table: van)
ALTER TABLE van
    ADD CONSTRAINT van_insurance
        FOREIGN KEY (insurance_id)
            REFERENCES insurance (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- End of file.

