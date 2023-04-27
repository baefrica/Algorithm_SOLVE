-- 코드를 입력하세요
SELECT DISTINCT(CART_ID)
FROM CART_PRODUCTS
WHERE CART_ID IN (SELECT CART_ID
                 FROM CART_PRODUCTS
                 WHERE NAME = 'Milk')
AND CART_ID IN (SELECT CART_ID
              FROM CART_PRODUCTS
              WHERE NAME = 'Yogurt')


# -- 우유가 담긴 장바구니의 아이디
# SELECT CART_ID
# FROM CART_PRODUCTS
# WHERE NAME = 'Milk'

# -- 요거트가 담긴 장바구니의 아이디
# SELECT CART_ID
# FROM CART_PRODUCTS
# WHERE NAME = 'Yogurt'