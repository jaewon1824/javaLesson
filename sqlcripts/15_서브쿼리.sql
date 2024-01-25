/*
 * 		서브 쿼리 (sub query) : select 조회 결과가 다른 DML 명령어에 쓰일 수 있습니다.
 * 													ㄴ select, insert, update, delete
 * 							 select, insert, update, delete 에 포함되는 select를 서브 쿼리라고 합니다.
 * 
 * 		select와 함께 쓰이는 서브 쿼리
 * 							: select 컬럼1, 컬럼2 from (select......)
 * 												where 컬럼명1 = 값(select.....)
 * 		select 서브쿼리는 join으로도 가능합니다.
 */

-- 1) where 에서 쓰는 서브쿼리 : twice가 구매한 상품 정보
SELECT tp.* FROM TBL_PRODUCT tp , TBL_BUY tb WHERE tp.PCODE =tb.PCODE AND CUSTOMID = 'twice'; -- JOIN
-- 크로스 연산, 조건식 연산

--서브쿼리
SELECT tp.* FROM TBL_PRODUCT tp WHERE PCODE IN 
--('CJBAb12g','APLE5kg','DOWON123a');
(SELECT PCODE FROM TBL_BUY tb WHERE CUSTOMID = 'twice');
-- 조건식 연산, 조건식 연산

-- 2) from에서 사용되는 서브 쿼리 : 컬럼명 또는 테이블명 별칭을 줄 때 한글을 쓰려면 ""안에 사용합니다.
SELECT saleMoney.PCODE,sum(QUANTITY), sum("구매 금액") FROM 	--집계함수 사용
(SELECT tp.PCODE, QUANTITY , QUANTITY * PRICE "구매 금액" 
FROM TBL_PRODUCT tp , TBL_BUY tb WHERE tp.PCODE =tb.PCODE) saleMoney GROUP BY saleMoney.PCODE;

-- 오라클 with 구문 : select 조회 결과를 저장해 놓고 사용하도록 합니다.
WITH saleMoney
AS (SELECT tp.PCODE, QUANTITY , QUANTITY * PRICE "구매 금액" 
FROM TBL_PRODUCT tp , TBL_BUY tb WHERE tp.PCODE =tb.PCODE)
SELECT saleMONEY.PCODE,sum(QUANTITY), sum("구매 금액") FROM SALEMONEY GROUP BY SALEMoney.PCODE;


SELECT 
    tp.PCODE,
    SUM(tb.QUANTITY) AS "총 구매 수량",
    SUM(tp.PRICE * tb.QUANTITY) AS "총 구매 가격"
FROM 
    TBL_PRODUCT tp
JOIN 
    TBL_BUY tb ON tp.PCODE = tb.PCODE
GROUP BY 
    tp.PCODE;
   

   
   

   
-- 서브쿼리와 조인을 이용한 문제를 한 개씩 만들어 팀별로 공유해보세요.
   
-- 2023년에 팔린 상품의 이름과 코드,총 판매액 그리고 총 판매개수를 구하시오.

SELECT total.PCODE,PNAME, SUM(QUANTITY) "총 구매개수", SUM("총 가격")
FROM (
    SELECT tp.PCODE,PNAME, QUANTITY, QUANTITY * PRICE "총 가격", BUY_DATE  
    FROM TBL_PRODUCT tp, TBL_BUY tb 
    WHERE tp.PCODE = tb.PCODE AND to_char(BUY_DATE, 'yyyy') = '2023'
) total
GROUP BY total.PCODE, PNAME;

--문제 : 가격이 1만원 이상의 상품마다 각각 고객들이 구매한 개수의 평균을 출력하시오.
SELECT tp.PNAME "상품명", avg(tb.QUANTITY)
FROM TBL_BUY tb 
JOIN TBL_PRODUCT tp ON tb.PCODE = tp.PCODE
WHERE tp.PRICE >= 10000
GROUP BY tp.PNAME;

--조이루 : 20대 사용자들이 구매한 가격의 평균, 이름, id 조회
SELECT tc.custom_id, tc.name, AVG(tp.price) AS avg_price
FROM TBL_CUSTOM  tc 
JOIN TBL_BUY tb ON tc.custom_id = tb.customId
JOIN TBL_PRODUCT tp ON tb.pcode = tp.pcode
WHERE tc.age BETWEEN 20 AND 29
GROUP BY tc.custom_id, tc.name;

--문제[전예진]: 진라면을 구매한 고객의 이름, 구매수량, 구매날짜를 조회하자.
/*
 * 순서1. buy의 pcode= product의 pcode -> 구매수량, 구매날짜를 조회
 * 순서2. buy의 customid= custom의 custom_id -> 고객의이름 
 * */
--답: 
WITH bi 
AS (
    SELECT CUSTOMID, PCODE, QUANTITY "구매수량", BUY_DATE "구매날짜"
    FROM TBL_BUY
    WHERE PCODE = 'JINRMn5'
)
SELECT tc.NAME "고객명", bi.구매수량, bi.구매날짜
FROM bi
JOIN TBL_CUSTOM tc 
ON bi.CUSTOMID = tc.CUSTOM_ID;

-- 문제)
 미나와 길동이는 한집에 살고 있습니다.
미나와 길동이가 구매한 상품,수량,가격을 조회하세요

--정답)
WITH minaGD
as(
SELECT *
FROM TBL_BUY tb 
WHERE CUSTOMID = 'twice' OR  CUSTOMID ='hongGD' 
)
SELECT tp.PNAME, minaGD.quantity,tp.PRICE 
FROM minaGD
JOIN TBL_PRODUCT tp
ON minaGD.PCODE = tp.PCODE ;


--고객별로 구매금액이 가장 높은 상품코드를 조회하세요.
--  ㄴ 오라클 RANK 함수		(그룹화 결과에 대한 순위를 제공)

-- 내림차순 또는 오름차순 정렬된 결과에서 top3 조회하기 

