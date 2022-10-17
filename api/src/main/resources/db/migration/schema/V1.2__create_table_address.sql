CREATE TABLE address (

    id VARCHAR(255),
    street VARCHAR(50),
    street_number VARCHAR(50),
    postal_code VARCHAR(50),
    city VARCHAR(50),
    country VARCHAR(50),
    move_in_date DATE,
    is_main BOOLEAN,
    affiliate_id VARCHAR(255),

    CONSTRAINT pk_address_id PRIMARY KEY (id),
    CONSTRAINT fk_affiliate_id FOREIGN KEY (affiliate_id) REFERENCES affiliate (id) ON DELETE CASCADE
);
