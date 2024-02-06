CREATE TABLE TBL_MENU (
	mcode nvarchar2(8) PRIMARY KEY,
	mname nvarchar2(10) NOT NULL UNIQUE,
	mprice number(7) NOT NULL
);

CREATE TABLE TBL_MEMBERS (
	code nvarchar2(8) PRIMARY KEY,
	name nvarchar2(4) NOT NULL,
	email nvarchar2(30),
	phone_number nvarchar2(20) unique,
	age number(3)
);

CREATE TABLE TBL_BUY_MENU (
	buy_index NUMBER(8) PRIMARY KEY,
	customer_id nvarchar2(8),
	menu_id nvarchar2(8),
	menu_quantity NUMBER NOT NULL,
	buy_date DATE DEFAULT sysdate,
	FOREIGN KEY (customer_id) REFERENCES TBL_MEMBERS(code),
	FOREIGN KEY (menu_id) REFERENCES TBL_MENU(mcode)
);

CREATE SEQUENCE burger_seq START WITH 1001;

-- TBL_MENU insert
ALTER TABLE TBL_MENU ADD (CATEGORY NVARCHAR2(8));
INSERT INTO TBL_MENU 
VALUES ('QUAR4', '쿼터파운드 치즈버거', 8900,'버거');
INSERT INTO TBL_MENU 
VALUES ('BG1955', '1955 버거', 7200,'버거');
INSERT INTO TBL_MENU 
VALUES ('TOMA2', '토마토 치킨 스낵랩', 3800,'사이드');
INSERT INTO TBL_MENU 
VALUES ('PEA1000', '천도 복숭아 칠러', 3700,'음료');
INSERT INTO TBL_MENU 
VALUES ('JEJU8', '제주 한라봉 칠러', 4300,'음료');
INSERT INTO TBL_MENU tm 
VALUES ('CH40','치즈버거',4000,'버거');
INSERT INTO TBL_MENU tm 
VALUES ('BM45','빅맥',4500,'버거');
INSERT INTO TBL_MENU tm 
VALUES ('BTD50','베토디',5000,'버거');
INSERT INTO TBL_MENU tm 
VALUES ('FF25','감자튀김',2500,'사이드');
INSERT INTO TBL_MENU tm 
VALUES ('SP20','스트라이트',2000,'음료');

-- TBL_MEMBERS insert
INSERT INTO TBL_MEMBERS values('jyj001','전예진','yyyjjj001@gmail.com','010-1234-3278',21);
INSERT INTO TBL_MEMBERS values('jjw001','정재원','jjjwww001@gmail.com','010-3278-1234',22);
INSERT INTO TBL_MEMBERS VALUES ('lce001','임채은','lce1234@gmail.com','010-0123-4567',25);
INSERT INTO TBL_MEMBERS VALUES ('jir001','조이루','jir777@naver.com','010-0987-6543',22);
INSERT INTO TBL_MEMBERS values('jsw001','장성우','ssswww444@gmail.com','010-1122-1122',25); 
INSERT INTO TBL_MEMBERS values('lhb002','임현범','hbhbhb001@naver.com','010-3344-5566',30); 

-- TBL_BUY_MENU insert
INSERT INTO TBL_BUY_MENU VALUES (burger_seq.nextval, 'jsw001', 'TOMA2', 3, sysdate);
INSERT INTO TBL_BUY_MENU VALUES (burger_seq.nextval, 'jsw001', 'BG1955', 2, sysdate);
INSERT INTO TBL_BUY_MENU VALUES (burger_seq.nextval, 'lhb002', 'SP20', 4, sysdate);
INSERT INTO TBL_BUY_MENU VALUES (burger_seq.nextval, 'jyj001', 'BTD50', 2, sysdate);
INSERT INTO TBL_BUY_MENU VALUES (burger_seq.nextval, 'jyj001', 'JEJU8', 1, sysdate);
INSERT INTO TBL_BUY_MENU VALUES (burger_seq.nextval, 'jjw001', 'PEA1000', 1, sysdate);
INSERT INTO TBL_BUY_MENU VALUES (burger_seq.nextval, 'jjw001', 'BTD50', 1, sysdate);
INSERT INTO TBL_BUY_MENU VALUES (burger_seq.nextval, 'lce001', 'FF25', 1, sysdate);
INSERT INTO TBL_BUY_MENU VALUES (burger_seq.nextval, 'lce001', 'QUAR4', 1, sysdate);
INSERT INTO TBL_BUY_MENU VALUES (burger_seq.nextval, 'jir001', 'CH40', 1, sysdate);
INSERT INTO TBL_BUY_MENU VALUES (burger_seq.nextval, 'jir001', 'TOMA2', 1, sysdate);

