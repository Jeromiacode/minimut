CREATE TABLE request (

    id VARCHAR(255),
    prestation_code VARCHAR(6),
    affiliate_code VARCHAR(6),
    date DATE,

    CONSTRAINT pk_request_id PRIMARY KEY (id)
);