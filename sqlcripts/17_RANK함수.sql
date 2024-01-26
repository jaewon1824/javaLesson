/*
 * 		오라클의 RANK 함수
 * 		예제 : 고객-상품별 최대구매금액을 구하고 해당 상품코드 조회하기
 * 				ㄴ 고객ID로 1차 그룹화, 고객내에서 상품코드로 2차 그룹화
 * 
 */
-- 준비 : mina012 에게 구매 이력이 있는 상품 한번 더 구매시키기
INSERT INTO TBL_BUY tb VALUES (buy_pk_seq.nextval, 'mina012', 'JINRMn5', 13, '2024-01-26');


SELECT *
FROM TBL_BUY tb, TBL_PRODUCT tp WHERE tb.PCODE = tp.PCODE 

-- 1) group by


SELECT 
tb.CUSTOMID , tb.PCODE, sum(tp.PRICE * tb.QUANTITY)
FROM TBL_BUY tb, TBL_PRODUCT tp WHERE tb.PCODE = tp.PCODE 
GROUP BY tb.CUSTOMID , tb.PCODE ;

-- 2) 1번 결과에 정렬 해봅니다.
SELECT 
tb.CUSTOMID , tb.PCODE, sum(tp.PRICE * tb.QUANTITY) MONEY
FROM TBL_BUY tb, TBL_PRODUCT tp WHERE tb.PCODE = tp.PCODE 
GROUP BY tb.CUSTOMID , tb.PCODE
ORDER BY tb.CUSTOMID , MONEY DESC ;


-- 3) 1번 결과에 RANK 함수를 적용해 봅니다.
SELECT 
tb.CUSTOMID , tb.PCODE, sum(tp.PRICE * tb.QUANTITY) MONEY
--,RANK() OVER(ORDER BY sum(tp.PRICE * tb.QUANTITY) DESC)	"RANK"			--OVER ()안에는 어떤 컬럼으로 정렬해서 순위를 매기는지에 대한 값을 넣으면 됨. 그룹화 된 RANK 순위
,RANK() OVER(PARTITION BY tb.CUSTOMID ORDER BY sum(tp.PRICE * tb.QUANTITY) DESC)
FROM TBL_BUY tb, TBL_PRODUCT tp WHERE tb.PCODE = tp.PCODE 
GROUP BY tb.CUSTOMID , tb.PCODE;

-- 4) 3번을 서브쿼리로 하여 rank =1 인 조건을 적용해보기
WITH CUSTOMSALE 
AS (SELECT tb.CUSTOMID , tb.PCODE, sum(tp.PRICE * tb.QUANTITY)
	,RANK() OVER(PARTITION BY tb.CUSTOMID ORDER BY sum(tp.PRICE * tb.QUANTITY) DESC) "RANK"
	FROM TBL_BUY tb, TBL_PRODUCT tp WHERE tb.PCODE = tp.PCODE 
	GROUP BY tb.CUSTOMID , tb.PCODE)
SELECT *
FROM CUSTOMSALE WHERE "RANK" = 1;



