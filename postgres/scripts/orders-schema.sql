--product_id, seller_id, order_id, customer_id, order_status, order_purchase_timestamp, order_approved_at, order_delivered_carrier_date, order_delivered_customer_date, order_estimated_delivery_date, customer_unique_id, customer_zip_code_prefix, customer_city, customer_state, review_id, review_score, review_comment_title, review_comment_message, review_creation_date, review_answer_timestamp, payment_sequential, payment_type, payment_installments, payment_value, order_item_id, price, freight_value, seller_zip_code_prefix, seller_city, seller_state, product_category_name, product_name_lenght, product_description_lenght, product_photos_qty, product_weight_g, product_length_cm, product_height_cm, product_width_cm

DROP TABLE orders CASCADE;

CREATE TABLE orders(
	product_id VARCHAR(50),
    seller_id VARCHAR(50),
    order_id VARCHAR(50),
    customer_id VARCHAR(50),
    order_status VARCHAR(10),
    order_purchase_timestamp TIMESTAMP,
    order_approved_at TIMESTAMP,
    order_delivered_carrier_date TIMESTAMP,
    order_delivered_customer_date TIMESTAMP,
    order_estimated_delivery_date TIMESTAMP,
    customer_unique_id VARCHAR(50),
    customer_zip_code_prefix BIGINT,
    customer_city VARCHAR(50),
    customer_state VARCHAR(50),
    review_id VARCHAR(50), 
    review_score INT, 
    review_comment_title VARCHAR(100), 
    review_comment_message VARCHAR(250), 
    review_creation_date TIMESTAMP, 
    review_answer_timestamp TIMESTAMP, 
    payment_sequential VARCHAR(5), 
    payment_type VARCHAR(50), 
    payment_installments INT, 
    payment_value FLOAT(8), 
    order_item_id VARCHAR(50), 
    price FLOAT(8), 
    freight_value FLOAT(8), 
    seller_zip_code_prefix BIGINT, 
    seller_city VARCHAR(50), 
    seller_state VARCHAR(50), 
    product_category_name VARCHAR(50), 
    product_name_lenght VARCHAR(50), 
    product_description_lenght VARCHAR(10), 
    product_photos_qty VARCHAR(10), 
    product_weight_g VARCHAR(10), 
    product_length_cm VARCHAR(10), 
    product_height_cm VARCHAR(10), 
    product_width_cm VARCHAR(10),


    PRIMARY KEY (product_id, seller_id, order_id, customer_id, customer_unique_id, review_id, order_item_id)
);
