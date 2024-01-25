### 데이터베이스 구축 시나리오

(1월 19일)

식료품을 판매하는 매장의 판매 관리를 위한 시스템을 구축합니다. 이 쇼핑몰에서 `고객` 은  필요한 `상품`을
`구매`할 수 있습니다. 고객은 회원가입 후 상품을 구매할 수 있습니다. 
+ `회원` 은  고유ID , 이름, 이메일, 나이 , 가입날짜로 관리하며
  + PK


+ `상품` 은  상품코드, 카테고리, 상품명, 가격이 필요합니다.
  + PK
 
 
+ `구매` 는  상품을 구매한 회원의 고유ID, 상품코드 , 구매수량, 구매날짜를 저장하여 관리합니다. 
  + PK 
  + FK
  
  
  CREATE TABLE EXCUSTOMER(
  	exno char(10) PRIMARY KEY,
  	name nvarchar2(5) NOT NULL,
  	email varchar2(30) NOT NULL UNIQUE,
  	age number(2) NOT NULL,
  	nDate Date NOT NULL
  );
 
 
 CREATE TABLE exproduct(
 	code char(10) PRIMARY KEY,
 	kate nvarchar2(10) NOT NULL,
 	prna nvarchar2(10) NOT NULL,
 	price number(10) NOT null
 );


CREATE TABLE exbuy(
	exno char(10),
	code char(10),
	quna number(10) NOT NULL,
	bDate Date DEFAULT sysdate,
	FOREIGN key(exno)
	REFERENCES EXCUSTOMER(exno),
	FOREIGN key(code)
	REFERENCES exproduct(code)
);

INSERT INTO EXCUSTOMER VALUES ('mina012', '김미나', 'kimm@gmail.com', 20, to_Date('2022-03-10 14:23:25','yyyy-mm-dd hh24:mi:ss'));
INSERT INTO EXCUSTOMER VALUES ('hongGD', '홍길동', 'gil@korea.com', 32,to_Date('2021-10-21 11:12:23','yyyy-mm-dd hh24:mi:ss')); 
INSERT INTO EXCUSTOMER VALUES ('twice', '박모모', 'momo@daum.net', 29, to_Date('2021-12-25 19:23:45','yyyy-mm-dd hh24:mi:ss'));   
INSERT INTO EXCUSTOMER VALUES ('wonder', '이나나', 'lee@naver.com', 40, to_char(SYSDATE, 'yyyy-mm-dd'));

INSERT INTO EXPRODUCT VALUES ('DOWON123a', 'B2', '동원참치선물세트', 54000);
INSERT INTO EXPRODUCT VALUES ('CJBAb12g', 'B1', '햇반 12개입', 14500);
INSERT INTO EXPRODUCT VALUES ('JINRMn5', 'B1', '진라면 5개입', 6350);
INSERT INTO EXPRODUCT VALUES ('APLE5kg', 'A1', '청송사과 5kg', 66000);
INSERT INTO EXPRODUCT VALUES ('MANGOTK4r', 'A2', '애플망고 1kg', 32000);


INSERT INTO EXBUY  VALUES ('mina012' , 'CJBAb12g' , 5 , to_Date('2022-03-10 14:33:15','yyyy-mm-dd hh24:mi:ss'));
INSERT INTO EXBUY  VALUES ('mina012' , 'APLE5kg' , 2 , to_Date('2022-03-10 14:33:15','yyyy-mm-dd hh24:mi:ss'));
INSERT INTO EXBUY  VALUES ('mina012' , 'JINRMn5' , 2 , to_Date('2022-04-16 10:13:15','yyyy-mm-dd hh24:mi:ss'));
INSERT INTO EXBUY  VALUES ('twice' , 'JINRMn5' , 3 , to_Date('2021-12-25 19:32:15','yyyy-mm-dd hh24:mi:ss'));
INSERT INTO EXBUY  VALUES ('twice' , 'MANGOTK4r' , 2 , to_Date('2021-12-25 19:32:15','yyyy-mm-dd hh24:mi:ss'));
INSERT INTO EXBUY  VALUES ('hongGD' , 'DOWON123a' , 1 , to_Date('2021-10-21 11:13:25','yyyy-mm-dd hh24:mi:ss'));
INSERT INTO EXBUY  VALUES ('hongGD' , 'APLE5kg' , 1 , to_Date('2022-04-21 11:13:25','yyyy-mm-dd hh24:mi:ss'));

SELECT * FROM EXCUSTOMER ;
SELECT * FROM EXPRODUCT ;
SELECT * FROM EXBUY ;


--구매 테이블에 기본키 만들기

-- 0) 기본키가 필요한 이유 : 행 식별

-- 1) 기본키에 들어갈 값은 시퀀스로 만듭니다. exbuy_pkseq 시작값은 1001로 합시다.
CREATE SEQUENCE exbuy_pkseq START WITH 1001;

-- 2) 기본키 컬럼명을 buy_idx로 하여 컬럼추가. number(8)
ALTER TABLE EXBUY ADD buy_idx NUMBER (8) ;

-- 3) 기본 행에 적용할 buy_idx 컬럼값을 저장하기. not null과 unique 적용하여 설정하기
--	디비버의 메뉴에서


-- 4) buy_idx 컬럼에 대해 primary key 설정하기
ALTER TABLE EXBUY ADD CONSTRAINT exbuy_pk PRIMARY KEY (buy_idx);

-- 5) 이제부터 새로운 행을 추가할 때에는 시퀀스 함수로 pk 값을 insert 합니다.
INSERT INTO EXBUY (buy_idx,exno,code,quna) VALUES (exbuy_pkseq.nextval,'mina012' , 'CJBAb12g' , 5);
SELECT *FROM EXBUY ;

--출제자 조이루
--문제 :  각회원들이 구매한 상품의 합계를 구하시오.
SELECT exno "구매회원", sum(quna)"구매한개수" FROM EXBUY GROUP BY exno;


--출제자 : 임현범
--문제 : 가입한지 12개월 이상된 회원들의 회원 정보를 출력하시오
SELECT * FROM EXCUSTOMER  WHERE MONTHS_BETWEEN(SYSDATE,nDate) > 12  ;


--출제자: 전예진
--문제 :  미나의 고객ID 뭔가요
SELECT exno "회원"FROM EXCUSTOMER WHERE name ='김미나';

--출제자 : 정재원
--문제 : 나이가 33살 이하인 회원들의 이름을 출력하시오
SELECT * FROM EXCUSTOMER WHERE age <=33 ;


--출제자 : 장성우
--문제: 1) id에 'ina' 가 포함되어 있는 
--             사용자  데이터 출력!! 
 --       2)컬럼을 다음과 별칭을 이용해서 
 --            출력하세요
 --          "아이디","상품 코드",
  --         "상품 수량","구매날짜"
SELECT * FROM EXCUSTOMER  WHERE EXNO LIKE '%ina%';
SELECT EXNO"아이디" , CODE "상품 코드" , QUNA "상품 수량" , BDATE "구매 날짜" FROM  EXBUY  ;

-- 출제자 : 임채은
-- 문제: 상품 정보에서 가격이 10000원과 60000원 사이에 있는 것을 구하시오
SELECT * FROM EXPRODUCT  WHERE PRICE between 10000 AND 60000 ;

DROP TABLE EXCUSTOMER ;
DROP TABLE EXPRODUCT ;
DROP TABLE EXBUY ;



















  