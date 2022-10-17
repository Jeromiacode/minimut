CREATE TABLE affiliate (

    id VARCHAR(255),
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email VARCHAR(50),
    phone_number VARCHAR(50),
    gender VARCHAR(6),
    birthdate DATE,

    CONSTRAINT pk_affiliate_id PRIMARY KEY (id)
);