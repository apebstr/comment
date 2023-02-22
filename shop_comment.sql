--DROP TABLE board;

CREATE TABLE board(
    num number CONSTRAINT board_num PRIMARY KEY,
    writer varchar2(50),
    subject varchar2(50),
    reg_date date,
    readcount number default 0, 
    ref number, 
    re_step number, 
    re_level number, 
    content varchar2(100),
    ip varchar2(20),
    upload varchar2(300),
    memberEmail varchar2(50)   
);

DROP SEQUENCE board_num_seq;

CREATE SEQUENCE board_num_seq
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

INSERT INTO board 
VALUES(board_num_seq.nextval, '홍길동','제목1',sysdate,0,board_num_seq.nextval,
0,0,'내용 테스트.......','127.0.0.1','sample.txt','young@aaaa.com');

commit;

select * from board;

ALTER TABLE board
DROP COLUMN writer;

SELECT * FROM board;


-- 회원가입처리를 위한 member테이블 생성
CREATE TABLE members(
    memberEmail varchar2(50),  --이메일
    memberPass varchar2(30),  --비밀번호
    memberName varchar2(20),  --이름
    memberPhone char(11),  --전화번호
    memberType number(1) default 1,  --회원구분 : 일반회원1, 관리자2
    constraint members_email primary key(memberEmail)
);

SELECT * FROM members;

commit;

-- commet처리를 위한 comment테이블 생성

--DROP TABLE comments;

CREATE TABLE comments(
    comContent varchar2(100),
    comReg_date date,
    num number,  -- boards테이블의 게시물 번호
    comRe_level number, 
    comIp varchar2(20),
    memberEmail varchar2(50)   
);

INSERT INTO comments 
VALUES('test', SYSTIMESTAMP, 8,0,'127.0.0.1','abc@email.com');

SELECT * FROM comments;

SELECT count(*)
FROM comments
WHERE num = 8;


commit;