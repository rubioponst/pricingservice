CREATE TABLE prices (
    product_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    brand_id BIGINT NOT NULL,
    start_date TIMESTAMP NOT NULL,
    end_date TIMESTAMP NOT NULL,
    price_list_id BIGINT NOT NULL,
    priority INT NOT NULL,
    productPrice FLOAT(10,2) NOT NULL,
    currency VARCHAR(3) NOT NULL
);