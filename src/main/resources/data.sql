SELECT * FROM CATEGORY;

INSERT INTO USER_ACCOUNT
(EMAIL, FIRST_NAME, LAST_NAME, PHONE_NUMBER, ROLE, SALT, HASH)
VALUES
    ('admin@example.com',
     'John',
     'Admin',
     '5551234567',
     'ADMIN',
     '419880e7066387423a89f13938961000',
     '89ae24aa55c87d0931ddfed360b08efa7f5e0f38c74f5e8161fb2675d96cf8a6');

INSERT INTO ADMIN (USER_ID)
SELECT USER_ID
FROM USER_ACCOUNT
WHERE EMAIL = 'admin@example.com';

INSERT INTO USER_ACCOUNT
(EMAIL, FIRST_NAME, LAST_NAME, PHONE_NUMBER, ROLE, SALT, HASH)
VALUES
    ('123@gmail.com',
     'John',
     'Customer',
     '5551234568',
     'CUSTOMER',
     '763aa660e746f9c6b17fdc9b5c03b6bf',
     '3a87916c3916b9452105de0558892428e03fe29b0cca3feb60b709a4db98e154');

INSERT INTO CUSTOMER (USER_ID)
SELECT USER_ID
FROM USER_ACCOUNT
WHERE EMAIL = '123@gmail.com';



INSERT INTO CATEGORY (CATEGORY_NAME) VALUES ('Food');
INSERT INTO CATEGORY (CATEGORY_NAME) VALUES ('Furniture');
INSERT INTO CATEGORY (CATEGORY_NAME) VALUES ('Clothing');


INSERT INTO PRODUCT (PRODUCT_DESCRIPTION,PRODUCT_NAME,PRODUCT_PRICE,PRODUCT_QUANTITY,PRODUCT_SOLD,CATEGORY_ID)
VALUES
    ('Fresh yellow bananas, high in potassium.',    'Banana',           0.49, 150, 0, 1),
    ('Organic carrots, crunchy and sweet.',         'Carrot',           0.89, 200, 0, 1),
    ('Whole grain sandwich bread loaf.',            'Whole Grain Bread',2.99,  80, 0, 1),
    ('2% reduced-fat milk, 1 gallon.',              'Milk',             3.49,  50, 0, 1),
    ('Aged cheddar cheese block, 8 oz.',             'Cheddar Cheese',   4.25,  60, 0, 1);

INSERT INTO PRODUCT (PRODUCT_DESCRIPTION,PRODUCT_NAME,PRODUCT_PRICE,PRODUCT_QUANTITY,PRODUCT_SOLD,CATEGORY_ID)
VALUES
    ('Solid oak dining table—seats six.',           'Dining Table',     299.99, 10, 0, 2),
    ('Ergonomic office chair with lumbar support.', 'Office Chair',     129.99, 25, 0, 2),
    ('5-shelf pine wood bookshelf.',                'Bookshelf',         89.99, 15, 0, 2),
    ('Comfortable three-seat fabric sofa.',          'Fabric Sofa',      549.99,  5, 0, 2),
    ('Modern nightstand with two drawers.',          'Nightstand',        74.99, 20, 0, 2);

INSERT INTO PRODUCT
(PRODUCT_DESCRIPTION, PRODUCT_NAME, PRODUCT_PRICE, PRODUCT_QUANTITY, PRODUCT_SOLD, CATEGORY_ID)
VALUES
    ('100% cotton crew-neck t-shirt, unisex.',       'T-Shirt',          14.99,100, 0, 3),
    ('Classic blue denim jeans.',                   'Jeans',            39.99, 80, 0, 3),
    ('Waterproof winter parka jacket.',              'Winter Jacket',   119.99, 40, 0, 3),
    ('Lightweight running sneakers.',               'Sneakers',         59.99, 60, 0, 3),
    ('Adjustable cotton baseball cap.',              'Baseball Cap',     19.99,150, 0, 3);
