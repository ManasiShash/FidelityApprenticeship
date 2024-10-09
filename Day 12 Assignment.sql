CREATE TABLE customers (
    customer_id VARCHAR(10) PRIMARY KEY,
    customer_name VARCHAR(20) NOT NULL,
    address VARCHAR(20),
    phone_no BIGINT,
    email_id VARCHAR(20)
);
INSERT INTO customers (customer_id, customer_name, address, phone_no, email_id)
VALUES 
('CUST1001', 'THOMAS', 'KOCHI', 9856325486, 'thomas@gmail.com'),
('CUST1002', 'CHARLES', 'ALLEPY', 9856367486, 'charles@gmail.com'),
('CUST1003', 'SUDHAKAR', 'KOCHI', 9856323869, 'sudhakar@gmail.com'),
('CUST1004', 'JAGADISH', 'ERNAKULAM', 9856326666, 'jagadish@gmail.com'),
('CUST1005', 'ALBERT', 'ALLEPY', 9856328659, 'albert@gmail.com'),
('CUST1006', 'ASHWIN DAS', 'KANNUR', 9856325659, 'ashwin@gmail.com');

CREATE TABLE delivery_partners (
    partner_id VARCHAR(10) PRIMARY KEY,
    partner_name VARCHAR(20) NOT NULL,
    phone_no BIGINT,
    rating INT
);
INSERT INTO delivery_partners (partner_id, partner_name, phone_no, rating)
VALUES 
('PART1001', 'DeliveryX', 9876543210, 4),
('PART1002', 'FastWheels', 9876543220, 5),
('PART1003', 'QuickMove', 9876543230, 3),
('PART1004', 'SwiftTransit', 9876543240, 2);

CREATE TABLE hotel_details (
    hotel_id VARCHAR(10) PRIMARY KEY,
    hotel_name VARCHAR(20) NOT NULL,
    hotel_type VARCHAR(20),
    hotel_rating INT
);

INSERT INTO hotel_details (hotel_id, hotel_name, hotel_type, hotel_rating)
VALUES 
('HOTEL1001', 'A2B', 'VEG', 4),
('HOTEL1002', 'BBQ Nation', 'NON-VEG', 5),
('HOTEL1003', 'Saravana Bhavan', 'VEG', 4),
('HOTEL1004', 'Meat Lovers', 'NON-VEG', 3);

CREATE TABLE orders (
    order_id VARCHAR(10) PRIMARY KEY,
    customer_id VARCHAR(10),
    hotel_id VARCHAR(10),
    partner_id VARCHAR(10),
    order_date DATE,
    order_amount INT,
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id),
    FOREIGN KEY (hotel_id) REFERENCES hotel_details(hotel_id),
    FOREIGN KEY (partner_id) REFERENCES delivery_partners(partner_id)
);

INSERT INTO orders (order_id, customer_id, hotel_id, partner_id, order_date, order_amount)
VALUES 
('ORD1001', 'CUST1001', 'HOTEL1001', 'PART1001', '2023-09-01', 250),
('ORD1002', 'CUST1002', 'HOTEL1002', 'PART1002', '2023-09-02', 500),
('ORD1003', 'CUST1003', 'HOTEL1003', 'PART1003', '2023-09-03', 150),
('ORD1004', 'CUST1004', 'HOTEL1004', 'PART1004', '2023-09-04', 300);

CREATE TABLE pizza (
    pizza_id VARCHAR(10) PRIMARY KEY,
    cust_id VARCHAR(10),
    partner_id VARCHAR(10),
    pizza_name VARCHAR(15),
    pizza_type VARCHAR(15),
    order_date DATE,
    amount BIGINT,
    FOREIGN KEY (cust_id) REFERENCES customers(customer_id),
    FOREIGN KEY (partner_id) REFERENCES delivery_partners(partner_id)
);

INSERT INTO pizza (pizza_id, cust_id, partner_id, pizza_name, pizza_type, order_date, amount)
VALUES 
('PIZ1001', 'CUST1001', 'PART1001', 'Margherita', 'Extra Large', '2023-09-05', 500),
('PIZ1002', 'CUST1002', 'PART1002', 'Pepperoni', 'Medium', '2023-09-06', 300),
('PIZ1003', 'CUST1003', 'PART1003', 'BBQ Chicken', 'Extra Large', '2023-09-07', 600);

CREATE TABLE supplier (
    supplier_id NUMERIC(5) PRIMARY KEY,
    supplier_name VARCHAR(150) NOT NULL,
    address VARCHAR(150),
    city VARCHAR(50),
    state VARCHAR(15),
    country VARCHAR(15),
    contact VARCHAR(10)
);

INSERT INTO supplier (supplier_id, supplier_name, address, city, state, country, contact)
VALUES 
(10001, 'ABC Supplies', '123 Street', 'Kochi', 'Kerala', 'India', '9998887776'),
(10002, 'XYZ Food Supply', '456 Avenue', 'Bangalore', 'Karnataka', 'India', '9998887775');

SELECT partner_id, partner_name, phone_no
FROM delivery_partners
WHERE rating BETWEEN 3 AND 5
ORDER BY partner_id;

UPDATE customers
SET phone_no = 19876543210
WHERE customer_id = 'CUST1004';

SELECT customer_id, customer_name, address, phone_no
FROM customers
WHERE email_id LIKE '%@gmail.com'
ORDER BY customer_id;

ALTER TABLE customers
ALTER COLUMN customer_id TYPE INT;

ALTER TABLE hotel_details
RENAME COLUMN rating TO hotel_rating;

SELECT CONCAT(hotel_name, ' is a ', hotel_type, ' hotel') AS "HOTEL INFO"
FROM hotel_details
ORDER BY hotel_name DESC;

SELECT h.hotel_id, h.hotel_name, COUNT(o.order_id) AS NO_OF_ORDERS
FROM hotel_details h
JOIN orders o ON h.hotel_id = o.hotel_id
GROUP BY h.hotel_id, h.hotel_name
HAVING COUNT(o.order_id) > 5
ORDER BY h.hotel_id ASC;

SELECT h.hotel_id, h.hotel_name, h.hotel_type
FROM hotel_details h
LEFT JOIN orders o ON h.hotel_id = o.hotel_id
AND o.order_date BETWEEN '2019-05-01' AND '2019-05-31'
WHERE o.order_id IS NULL
ORDER BY h.hotel_id ASC;

SELECT o.order_id, c.customer_name, h.hotel_name, o.order_amount
FROM orders o
JOIN customers c ON o.customer_id = c.customer_id
JOIN hotel_details h ON o.hotel_id = h.hotel_id
ORDER BY o.order_id ASC;

UPDATE pizza
SET amount = amount * 0.97
WHERE pizza_type = 'Extra Large';

CREATE TABLE orders (
    ord_no NUMERIC(5),
    purch_amt DECIMAL(8,2),
    ord_date DATE,
    customer_id NUMERIC(5),
    salesman_id NUMERIC(5),
    FOREIGN KEY (salesman_id) REFERENCES salesman(salesman_id)
);


ALTER TABLE supplier
ADD CONSTRAINT chk_contact_length
CHECK (LENGTH(contact) = 10);

