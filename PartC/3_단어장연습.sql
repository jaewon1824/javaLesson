/*
* ' 단어장' 프로그램을 위한 테이블
*
* 0. 테이블 명 : tbl_javaword
* 1. 테이블 구조
*												3. To do : 컬럼값들의 규칙	=> 요구사항에 대한 제약조건
*	idx			number(8)					같은 값을 가질 수 없다. 	반드시 값이 있어야한다.
*	english		varchar2(100)				같은 값을 가질 수 없다. 	반드시 값이 있어야한다.
*	korean		nvarchar2(100)				반드시 값이 있어야한다.
*	step		number(1)					반드시 값이 없는 null도 가능하다. 1~4 범위로만 한다.
*											
*	4. To do : 검색 속도 향상시키기 위한 컬럼을 정해라. 데이터행을 식별할 수 있는 컬럼을 정해라(기본키 설정)
*		지정하지 않으면 null 가능
* 2. 테이블에 행 추가 - 데이터 입력하기
*
*
*
*/

CREATE TABLE TBL_JAVAWORD(
	idx number(8),
	english varchar2(100),
	korean nvarchar2(100),
	step NUMBER(1)
	);
SELECT * FROM TBL_JAVAWORD ;
-- insert into 테이블명 후에 모든 항목을 보려면 () 생략가능 하나라도 빼고 싶다면 전부 입력 ex) idx english korean 
INSERT INTO TBL_javaword(idx,english,korean,step) VALUES (8,'mother','어머니',8);
INSERT INTO TBL_javaword(idx,english,korean,step) VALUES (8,'fother','아버지',6);
INSERT INTO TBL_javaword(idx,english,korean,step) VALUES (8,'food','음식',5);
INSERT INTO TBL_javaword(idx,english,korean,step) VALUES (8,'coffee','커피',2);
INSERT INTO TBL_javaword(idx,english,korean,step) VALUES (8,'music','음악',3);
INSERT INTO TBL_javaword(idx,english,korean,step) VALUES (8,'computer','컴퓨터',1);
INSERT INTO TBL_javaword(idx,english,korean,step) VALUES (8,'sound','소리',4);

-- SELECT 컬럼명1,컬럼명2,	FROM 테이블명 => 모든 컬럼을 지정하려면 * from 테이블명
-- 입력하지 않은 컬럼의 값은 null
-- select 컬럼명,1 컬럼명2, from 테이블명 where 컬럼명 = 값	=> 특정 컬럼을 조건식으로 조회
SELECT * FROM TBL_JAVAWORD WHERE STEP IS NOT NULL;
SELECT * FROM TBL_JAVAWORD WHERE STEP IS NULL;
SELECT * FROM TBL_JAVAWORD WHERE IDX=2;
SELECT * FROM TBL_JAVAWORD WHERE ENGLISH ='public';
SELECT * FROM TBL_JAVAWORD WHERE ENGLISH ='public' AND STEP = 2;  --NOT,AND,OR : 논리연산
SELECT * FROM TBL_JAVAWORD WHERE ENGLISH LIKE '%sh';		--sh로 끝나는, %기호는 don't care
SELECT * FROM TBL_JAVAWORD WHERE ENGLISH LIKE '%sh%';		--sh가 들어가는 모든, %기호는 don't care
SELECT * FROM TBL_JAVAWORD WHERE IDX BETWEEN 10 AND 20;		--10~20
SELECT * FROM TBL_JAVAWORD WHERE IDX NOT BETWEEN 10 AND 20;		--10~20 범위값이 아닌 것
SELECT * FROM TBL_JAVAWORD WHERE ENGLISH < 'food';		-- ~보다