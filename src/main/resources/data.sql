INSERT INTO product (
    PROD_NAME, PROD_DESCRIPTION, PROD_BRAND, PROD_PRICE, PROD_CATEGORY, PROD_AVAILABLE, PROD_QUANTITY, PROD_RELEASE_DATE
) VALUES
(
    'Fridge', 'A high-efficiency refrigerator.', 'CoolBrand', 15000.00, 'Electronics', TRUE, 20, NOW()
),
(
    'Washing Machine', 'A top-load washing machine with 8 kg capacity and multiple wash programs.', 'WashPro', 12000.00, 'Home Appliances', TRUE, 15, NOW()
),
(
    'Microwave Oven', 'A compact microwave oven with defrost and reheat functions.', 'HeatWave', 5000.00, 'Kitchen Appliances', FALSE, 0, NOW()
),
(
    'Air Conditioner', 'A 1.5 ton air conditioner with cooling and heating modes.', 'CoolAir', 25000.00, 'Electronics', TRUE, 10, NOW()
);
