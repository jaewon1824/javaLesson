-- 수업 날짜 : 1/19

--실제로는 테이블의 컬럼으로 함수 실행합니다.	select lower(컬럼명) from 테이블명;

-- 1. 날짜 함수 : to_char(날짜를 문자열로 변환) , to_date(문자열을 날짜형식으로 변환)
SELECT SYSDATE ,SYSTIMESTAMP FROM dual;
--systimestamp 는 표준시와의 시차(타임존) 표시

SELECT to_char(SYSDATE,'yyyy-mm-dd') FROM dual;
--한글을 표시하고 싶다면 yyyy 뒤에 "년" 큰따옴표를 붙여야함.
-- yyyy-mm-dd hh24:mi:ss 24시간기준
-- yyyy-mm-dd hh:mi:ss am 12시간 기준 (am대신에 pm도 가능)

--TBL_MEMBER 테이블에 JOIN_DATE 컬럼 insert
-- INSERT INTO TBL_MEMBER VALUES (2,'박나연','parkny@gmail.com','2022-10-24 13:24:55');		--오류
--자동 캐스팅 패턴 yyyy-mm-dd 만 가능합니다.
INSERT INTO TBL_MEMBER VALUES (2,'박나연','parkny@gmail.com',to_date('2022-10-24 13:24:55','yyyy-mm-dd hh24:mi:ss'));
INSERT INTO TBL_MEMBER VALUES (10,'홍길동','gdHong@daum.net',to_date('20240109','yyyymmdd'));
SELECT * FROM tbl_member;

SELECT ADD_MONTHS(SYSDATE,3) FROM dual;
--오늘날짜 3개월 이후. 첫번째 인자는 날짜 형식.	두번째 더해지는 값

SELECT TO_CHAR(ADD_MONTHS(SYSDATE,3),'yyyy/mm/dd') FROM dual;
--문자열패턴 기호 - 또는 / 구분기호 없음가능

SELECT MONTHS_BETWEEN(SYSDATE,TO_DATE('2022-09-23')) FROM dual;
--지정된 2개의 날짜 사이에 간격(월). 결과는 소수점

SELECT trunc(SYSDATE)-to_date('20240110','yyyymmdd') FROM dual;
--2개의 날짜형식 값 간격(일) TRUNC(SYSDATE)는 일(day)로 변환

SELECT TRUNC(3.177567,2) FROM dual; 	
--trunc(숫자,자리수) : 자리수 맞추기 위해서 버림 3.177567 -> 3.17

SELECT ROUND(3.177567,2) FROM dual;		
--round(숫자,자리수) : 반올림 3.177567 -> 3.18  

SELECT ROUND(3.177567) FROM dual;		
--ceil(숫자)	: 실수를 정수로 올림으로 변환 4  

SELECT floor(3.177567) FROM dual;		
--floor(숫자) : 실수를 정수로 내림으로 변환 3

-- 2. 문자열 함수
SELECT INITCAP('hello') FROM dual;	
--예상 : Hello		--initail capital : 첫번째 대문자

SELECT upper('hello') FROM dual;	
-- 대문자로 변환	HELLO

SELECT LOWER('OraCle') FROM dual;	
--소문자로 변환 	oracle

SELECT LENGTH ('oracle') FROM dual;	
--문자열 길이 6

SELECT substr ('java program',3,5) FROM dual;	
--부분 추출(문자열,위치,길이) 결과 : *오라클에서 문자열 위치 인덱스는 1부터 시작*

SELECT substr ('java program',-5,3) FROM dual;	
--부분 추출 결과 : 위치음수이면 뒤에서부터

SELECT replace('java program','pro','프로') FROM dual;	
--문자열 바꾸기 java프로gram

SELECT instr('java program','og') from dual;	
--자바의 indexOf --결과 8	해달 문자열이 없으면 결과 0

SELECT trim (' java program     ') FROM dual;		
--공백 제거

SELECT LENGTH ('java program      ') FROM dual;		
--공백포함 길이

SELECT LENGTH (trim('  java program    ')) FROM dual; 
--공백제거 후 길이
