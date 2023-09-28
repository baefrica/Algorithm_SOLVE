-- 코드를 입력하세요
SELECT (CASE
        WHEN PRICE < 10000 THEN 0
        WHEN PRICE < 20000 THEN 10000
        WHEN PRICE < 30000 THEN 20000
        WHEN PRICE < 40000 THEN 30000
        WHEN PRICE < 50000 THEN 40000
        WHEN PRICE < 60000 THEN 50000
        WHEN PRICE < 70000 THEN 60000
        WHEN PRICE < 80000 THEN 70000
        ELSE 80000
        END) AS PRICE_GROUP, COUNT(PRODUCT_ID) AS PRODUCTS
FROM PRODUCT
GROUP BY PRICE_GROUP
ORDER BY PRICE_GROUP;