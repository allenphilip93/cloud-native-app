--invoice_no,stockcode,description,quantity,invoice_date,unitprice,customer_id,country

DROP TABLE invoice CASCADE;

CREATE TABLE invoice(
	id BIGSERIAL,
    invoice_no VARCHAR(10),
    stockcode VARCHAR(20),
    description VARCHAR(100),
    quantity FLOAT(10),
    invoice_date TIMESTAMP,
    unitprice FLOAT(10),
    customer_id VARCHAR(10),
    country VARCHAR(20),
    PRIMARY KEY (id)
);
