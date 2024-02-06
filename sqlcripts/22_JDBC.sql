--카테고리로 검색하기
-- 1) 어떤 카테고리가 있는지 보여주기

-- 주요 정리 : 컬럼 조회한 결과는 1개 또는 1개 이상에 따라 리턴형식을 결정하자 (list 또는 not list)
--상품 검색하기 SQL : ProductVo, TblProductDao 만들기
								--	ㄴ selectByCategory , selectByPname 메소드 만듭시다

SELECT DISTINCT CATEGORY FROM TBL_PRODUCT ;		--중복된 값은 한번만 (중복제거)

-- 2) 특정 카테고리에 대해 상품 목록 보여주기
SELECT * FROM TBL_PRODUCT 
WHERE CATEGORY = 'B1'
ORDER BY PNAME;

-- 데이터 추가
UPDATE TBL_PRODUCT SET CATEGOrY = 'B2' , PNAME = '부사 사과 3kg 박스' , PRICE = 25000 
WHERE PCODE = 'BUSA211'   ;

-- 3) 상품명 유사(like) 검색
SELECT * FROM TBL_PRODUCT 
WHERE PNAME LIKE '%' || '사과' || '%'		--프로그램에서 매개변수 처리를 위해 연결연산으로 합니다.
ORDER BY CATEGORY;

--MyPage 기능의 메소드를 위한 SQL
-- selectBuyList => TblBuyDao에 만드세요.
--				 => 아래 조회된 행들에 대해 컬럼과 매핑되는 CustomerBuyVo를 만들어야 합니다.
SELECT BUY_IDX , tb.PCODE , PNAME, PRICE, QUANTITY , BUY_DATE 
FROM TBL_BUY tb
JOIN TBL_PRODUCT tp
ON tb.PCODE = tp.PCODE 
WHERE tb.CUSTOMID = 'mina012';

SELECT tb.PCODE , sum(QUANTITY*PRICE) 
FROM TBL_PRODUCT tp
JOIN TBL_BUY tb
ON tp.PCODE = tb.PCODE 
GROUP BY tb.PCODE ;

SELECT DISTINCT tb.PCODE , PRICE 
FROM TBL_PRODUCT tp
JOIN TBL_BUY tb
ON tp.PCODE = tb.PCODE ;
