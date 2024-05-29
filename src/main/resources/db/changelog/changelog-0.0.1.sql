
CREATE TABLE category_details (
    category_id UUID NOT NULL PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE shop_details (
    shop_id UUID NOT NULL PRIMARY KEY,
    shop_name VARCHAR(255),
    phone_number VARCHAR(255),
    owner_name VARCHAR(255),
    registration_number VARCHAR(255) NOT NULL UNIQUE,
    category_id UUID,
    FOREIGN KEY (category_id) REFERENCES category_details(category_id)
);
