/*
 * 	DML : select , insert , update , delete
 * 		: 테이블의 행 데이터에 대한 조작.
 * 
 * 	여기서 한번 더 생각할 것은 기본키가 필요한 이유 : 행 식별
 */

-- update 테이블명
--			set 컬럼명1=변경할 값, 컬럼명2=변경할 값....
--			where 조건식;

-- 예시 : mina012 회원이 구매한 상품 CJBAb12g의 수량을 모두 10으로 변경하기
UPDATE EXBUY SET QUNA = 10 WHERE exno = 'mina012' AND code = 'CJBAb12g';
SELECT *FROM EXBUY ;

--예시 : buy_idx 값이 1001인 행의 수량을 5로 변경하기
--	  : 조건식 컬럼이 PK컬럼(행식별) 일 때는 반드시 1개의 행만 수정이 적용됩니다.
UPDATE EXBUY SET quna = 5 WHERE BUY_IDX = 1001;

UPDATE EXBUY SET quna = 5;				--WHERE 조건 없는 sql은 신중하게. 꼭 필요할 때 (전부 바뀜)


-- delete from 테이블명 where 조건식 : 행 전체 삭제
--	  : 조건식 컬럼이 PK컬럼(행식별) 일 때는 반드시 1개의 행만 삭제가 됩니다.
--WHERE 조건 없는 sql은 신중하게. 꼭 필요할 때 (전부 바뀜)
DELETE FROM EXBUY WHERE buy_idx = 1001;

-- 최종결론 : PK컬럼은 응용프로그램 개발할 때는 없으면 기능을 만들 수 없습니다.
--		   행식별을 하여 조회 select , 수정 update , 삭제 delete 에 반영되는 행을 지정할 수 있습니다.


------------------------------------------------------------------------------------------------

--  트랜잭션 : insert , update , delete에서 반드시 하나의 단위로 처리해야할 작업
--		    모모가 미나한테 5만원 이체를 합니다. 모모계좌는 -50,000 그리고 미나계좌는 +50,000
--			update 2개의 명령어로 실행할 때 둘 다 실행 또는 2개 모두 실행이 안되거나 해야하는 트랜잭션입니다.	
--	자동 커밋 : insert , update , delete가 바로 테이블에 반영되는 것.
--	수동 커밋 : insert , update , delete 명령이 바로 반영되지 않고 commit 명령을 통해서 실행됩니다.
--			 insert , update , delete 명령 트랜잭션 취소는 rollback으로 합니다.

-- sql plus 명령
-- show autocommit;
-- set autocommit on 또는 off;

-- 디비버의 auto commit 해제하지 : 데이터베이스 메뉴 - 트랜잭션 모드 - manual commit으로 변경하기
INSERT INTO EXBUY (buy_idx,exno,code,quna) VALUES (exbuy_pkseq.nextval,'mina012' , 'CJBAb12g' , 5);			--1 현재 트랜잭션 명령
SELECT * FROM EXBUY ;			--2 현재 트랜잭션 명령

-- 수동 커밋 상태에서 sql plus 실행 c##idev 계정으로 접속하기
-- 		디비버 사용자가 추가한 insert는 커밋을 해야 sqlpuls 반영됩니다.

UPDATE EXBUY SET quna = 8 WHERE BUY_IDX = 1002;			--3 현재 트랜잭션 명령
SELECT * FROM EXBUY ;			--4 현재 트랜잭션 명령

-- 트랜잭션 취소		시퀀스를 롤백이 되지 않는다.
ROLLBACK;
SELECT  * FROM EXBUY ;			--1 새로운 트랜잭션 명령
-- insert 와 update 다시하고 commit 테스트 해보세요.
-- 							ㄴ sqlplus 사용자테스트 해보기.

INSERT INTO EXBUY (buy_idx,exno,code,quna) VALUES (exbuy_pkseq.nextval,'mina012' , 'CJBAb12g' , 5);		--2 새로운 트랜잭션 명령
UPDATE EXBUY SET quna = 8 WHERE BUY_IDX = 1002;			--시퀀스는 이미 증가하여 롤백 안됩니다.		--3 새로운 트랜잭션 명령
SELECT  * FROM EXBUY ;			--4 새로운 트랜잭션 명령

--트랜잭션 처리 완료
COMMIT;