/*
 * 제약 조건	constraint
 * 1) 반드시 값이 있어야한다.				null 허용?
 * 2) 같은 값을 가질 수 없다.				unique(유일) 키워드
 * 3) 1~4 범위도로만 한다.				check 키워드
 * -----------------------
 * 4) 기본키 : 테이블의 행을 식별(구별) where 기본키컬럼=값;	조건실행 했을 때 1개의 행 조회됩니다.
 * 			 자동으로 인덱스(색인)로 생성이 됩니다. 인덱스는 검색(조회) 속도 향상시키는 방법입니다.
 * 			 기본키는 NOT NULL과 UNIQUE 2가지 제약조건에 해당합니다.
 * 			 기본키는 테이블에서 1개만 가능합니다. 단, 기본키를 구성하는 컬럼은 1개이상 (2개,3개 등등) 가능합니다.
 * 5) 외래키 : 테이블 간의 참조를 위해서 사용합니다.
 * 			 외래키는 테이블 1개에서 여러개 만들어질 수 있습니다.
 */

-- 제약조건 컬럼레벨 설정하기
CREATE TABLE tbl_constr(		
	aname Varchar2(20) NOT NULL,
	bname varchar2(20) UNIQUE,	--null은 허용
	cno number(4) NOT NULL UNIQUE,
	dno number(4) CHECK (dno BETWEEN 1 AND 4)	--NULL 허용
);

INSERT INTO TBL_CONSTR (aname,cno) VALUES ('apple',3);			--필수 입력 컬럼
--1) 입력 오류 발생하는 경우 : unique 위반
--INSERT INTO TBL_CONSTR (aname,bname,cno) values('apple','banana',3);	--cno 컬럼값 중복
INSERT INTO TBL_CONSTR (aname,bname,cno) values('apple','banana',4);
--INSERT INTO TBL_CONSTR (aname,bname,cno) values('apple','banana',5);	--bname 컬럼값 중복

--2) 입력 오류 발생하는 경우 : not null 위반
--INSERT INTO TBL_CONSTR (cno) VALUES (3);

--3) 입력 오류 발생하는 경우 : check 위반
INSERT INTO TBL_CONSTR (aname,cno,dno) VALUES ('apple',7,3);
--INSERT INTO TBL_CONSTR (aname,cno,dno) VALUES ('apple',8,13);		--값의 범위 1~4 아님
SELECT * FROM TBL_CONSTR ;

--단어장 테이블에 제약조건을 적용해서 다시 만들어 봅시다.
--기존 테이블 삭제
DROP TABLE TBL_JAVAWORD ;
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
*2. 테이블에 행 추가 - 데이터 입력하기
*
*
*
*/

CREATE TABLE TBL_JAVAWORD(
	idx number(8) primary KEY,		--UNIQUE 와 NOT null
	english varchar2(100) UNIQUE NOT NULL,
	korean nvarchar2(100) NOT NULL,	
	step NUMBER(1) CHECK (step BETWEEN 1 AND 4)			--CHECK () 괄호 필수
	);

INSERT INTO TBL_JAVAWORD VALUES (1,'public','공용의',1);
--INSERT INTO TBL_JAVAWORD VALUES (1,'private','사적인',1);		--오류
--INSERT INTO TBL_JAVAWORD VALUES (2,'public','사적인',1);		--오류
--INSERT INTO TBL_JAVAWORD VALUES (null,'public','사적인',1);		--오류
	



