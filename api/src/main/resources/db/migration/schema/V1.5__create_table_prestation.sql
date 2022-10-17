CREATE TABLE prestation (

    id VARCHAR(255),
    code VARCHAR(6),
    description VARCHAR(255),
    start_date DATE,
    end_date DATE,
    price INTEGER,

    CONSTRAINT pk_prestation_id PRIMARY KEY (id)
);