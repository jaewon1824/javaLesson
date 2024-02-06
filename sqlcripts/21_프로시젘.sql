/*
 * 		프로시저 직접 만들어보기 : money_of_day
 * 		매개변수 IN : 고객ID, 날짜(패턴은 'yyyy-mm-dd')
 * 		매개변수 OUT : IN으로 받은 값들을 tbl_buy에서 상품코드를 조회하여 총 구매 금액을 구합니다.
		주의 : 매개변수 선언에는 varchar2 또는 number 만 씁니다 () 불필요
 * 			단, 고객은 1일 1품목만 구매 가능합니다.
 * 
 * 		1) 고객 ID 날짜 값으로 구매 테이블에서 수량과 pcode 조회하고 변수에 저장하기
 * 		2) 1에서 구한 pcode의 가격을 조회하여 저장하기
 * 		3) 2번 가격과 1번 수량을 곱하기 하여 결과값을 변수에 저장 => 출력변수
 */
CREATE SEQUENCE TBL_buy_seq START WITH 3000;
ALTER TABLE TBL_buy ADD money number(8);

CREATE OR REPLACE PROCEDURE money_of_day(
	bcustom_id IN TBL_buy.CUSTOMID %TYPE,
	bpcode IN TBL_buy.PCODE %TYPE,
	bcnt IN TBL_buy.QUANTITY %TYPE,
	bdate IN TBL_buy.BUY_DATE %TYPE
)
IS 
	vpcode NUMBER;
	vqu NUMBER;
	vprice NUMBER;
BEGIN
	INSERT INTO TBL_BUY (buy_IDX,CUSTOMID,PCODE,QUANTITY,BUY_DATE)
		VALUES (pbuy_seq.nextval, bcustom_id, bpcode, bcnt,bdate);
	SELECT PCODE, QUANTITY
	  	INTO vpcode,vuq
	  	FROM TBL_BUY 
	  	WHERE CUSTOMID = bcustom_id
 AND to_char(buy_date, 'yyyy-mm-dd') = bdate;
	SELECT price
  		INTO vprice
  		FROM TBL_PRODUCT tp
  		WHERE PCODE = vpcode;
  	SELECT vpcode*vprice
  	INTO vqu 
  	FROM dual;
END;



--프로시저 실행 
  
DECLARE
		  vmoney number(8);			--일반변수 선언할때는 ()에 크기 필요		매개변수에는 안줌
		  -- 프로시저 실행결과 OUT 매개변수값 저장 (꼭 필요한 변수)
		  vid tbl_custom.custom_id %TYPE;	-- 프로시저 실행에 필요한 IN 매개변수값 저장변수
		  vdate varchar2(20);				-- 없어도 되지만 출력 등 편의상 선언합니다.
Begin 
 		vid :='mina012';
 		vdate :='2023-11-10';
 		money_of_day(vid,vdate,vmoney);
 		--vid, vdate IN 매개변수값으로 프로시저를 실행합니다.
 		--OUT 매개변수에 저장된 프로시저 실행 결과를 vmoney 변수에 저장합니다.
 		dbms_output.put_line(CHR(10) || '고객ID : ' || vid || '날짜 : ' || vdate);
		dbms_output.put_line('고객님의 구매금액은 ' || vmoney || '입니다.'); 
end;
  
  	--힌트
  	
  	SELECT PCODE, QUANTITY
  	INTO ?,?
  	FROM TBL_BUY 
 	WHERE CUSTOMID = 입력변수IN 
 	AND to_char(buy_date, 'yyyy-mm-dd') = 입력변수IN;
  	
  	SELECT price
  	INTO ?
  	FROM TBL_PRODUCT tp
  	WHERE PCODE = 1 번 구한 변수
  	
  	출력매개변수에 저장하기
  	SELECT 1번에서 구한 수량값 변수* 2번에서 구한 가격값 변수
  	INTO ? 출력매개변수
  	FROM dual;
  	
  -- 답
  
  --실행을 위한 주요 sql :
  SELECT  PCODE, QUANTITY 
  FROM TBL_BUY 
  WHERE CUSTOMID = 'mina012' AND to_char(BUY_DATE, 'yyyy-mm-dd') = '2023-11-11';

 
  
  
  CREATE OR REPLACE PROCEDURE "C##IDEV".money_of_day(
   p_id IN tbl_custom.custom_id %TYPE,      -- 출력(리턴) 변수
   p_date IN varchar2,      -- 출력(리턴) 변수
   p_money OUT NUMBER
)
IS
   v_pcode TBL_BUY.PCODE %TYPE;
   v_quantity TBL_BUY.QUANTITY %TYPE;
   v_price TBL_PRODUCT.PRICE %TYPE;
BEGIN
   SELECT PCODE, QUANTITY					--1일 1구매 조건으로 오직 1개의 행이 조회됩니다.
      INTO v_pcode , v_quantity				--조회 결과가 n개의 행이면 프로시저의 커서 기능을 이용합니다.
      --into 는 프로시저에서만 사용합니다. 조회 결과를 변수에 저장합니다.
   FROM TBL_BUY
   WHERE CUSTOMID = p_id AND to_char(buy_date, 'yyyy,mm,dd') = p_date;
   
   DBMS_OUTPUT.PUT_LINE('* p : ' || v_pcode || v_quantity );
   SELECT PRICE
      INTO v_price
   FROM TBL_PRODUCT
   WHERE PCODE = v_pcode;
   DBMS_OUTPUT.PUT_LINE('* p : ' || v_price);
   SELECT v_quantity * v_price
      INTO p_money
   FROM dual;	--수량 * 가격 수식연산결과를 출력매개변수 p_money에 저장
   				-- 특정 테이블과 상관 없으므로 dual 임시 테이블 사용하여 연산합니다.
   DBMS_OUTPUT.PUT_LINE('* m : ' || p_money);
   EXCEPTION	--프로시저에서는 조회 결과가 없는 경우 예외로 처리할 수 있습니다.
   WHEN no_data_found then
   DBMS_OUTPUT.PUT_LINE('조건에 맞는 데이터가 없습니다.');
   p_money :=0;
END;