CREATE TABLE PRODUCT_TABLE (
                              id BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                              name VARCHAR(255) NOT NULL,
                              description TEXT,
                              price DECIMAL(10,2) NOT NULL,
                              category VARCHAR(100),
                              brand VARCHAR(255),
                              quantity INT NOT NULL,
                              sku VARCHAR(100),
                              createdat TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                              updatedat TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);