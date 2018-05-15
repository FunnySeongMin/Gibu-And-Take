--회원 분류 테이블
drop table member_group;
create table member_group(
	mgroup_no varchar2(100) primary key,
	mgroup_name varchar2(100) not null
)

insert into member_group values('1','일반회원');
insert into member_group values('2','재능기부자');
insert into member_group values('3','기부단체');
insert into member_group values('4','관리자');

--회원 등급 테이블
drop table member_grade;
create table member_grade(
	mgrade_no varchar2(100) primary key,
	mgrade_name varchar2(100) not null
)

insert into member_grade values('1','새싹');
insert into member_grade values('2','일반');
insert into member_grade values('3','성실');
insert into member_grade values('4','열심');
insert into member_grade values('5','우수');
insert into member_grade values('6','감사');

--회원 테이블
drop table gt_member;
create table gt_member(
	id varchar2(100) primary key,
	password varchar2(100) not null,
	name varchar2(100) not null,
	address varchar2(100) not null,
	birthday date not null,
	mileage number default 0,
	total_use_mileage number default 0,
	mgroup_no varchar2(100) not null,
	mgrade_no varchar2(100) not null,
	CONSTRAINT fk_gt_member_mgroup FOREIGN KEY(mgroup_no) REFERENCES member_group(mgroup_no) ON DELETE CASCADE,
	CONSTRAINT fk_gt_member_mgrade FOREIGN KEY(mgrade_no) REFERENCES member_grade(mgrade_no) ON DELETE CASCADE
)

insert into gt_member(id,password,name,address,birthday,mgroup_no,mgrade_no)
values('javaking','seo','서정우','판교',to_date('1997.07.21','yyyy.mm.dd'),1,6);
insert into gt_member(id,password,name,address,birthday,mgroup_no,mgrade_no)
values('hwang','ma','황명아','한국',to_date('1820.07.21','yyyy.mm.dd'),1,6);
insert into gt_member(id,password,name,address,birthday,mgroup_no,mgrade_no)
values('banjang','lee','이윤희','판교',to_date('1988.08.24','yyyy.mm.dd'),1,6);
insert into gt_member(id,password,name,address,birthday,mgroup_no,mgrade_no)
values('baek','12345','백설희','용인',to_date('1994.06.16','yyyy.mm.dd'),1,1);
insert into gt_member(id,password,name,address,birthday,mgroup_no,mgrade_no)
values('cho','abcd','조민경','서울',to_date('1992.06.09','yyyy.mm.dd'),1,2);
insert into gt_member (id,password,name,address,birthday,mgroup_no,mgrade_no)
values('yong','diyong','용다은','수원',to_date('1994.06.01','yyyy.mm.dd'),2,3);
insert into gt_member (id,password,name,address,birthday,mgroup_no,mgrade_no)
values('jin','jung','정진표','하남',to_date('1987.06.15','yyyy.mm.dd'),3,4);
insert into gt_member (id,password,name,address,birthday,mgroup_no,mgrade_no)
values('keroro','pororo','은성민','서울',to_date('1990.08.14','yyyy.mm.dd'),4,5);
insert into gt_member (id,password,name,address,birthday,mgroup_no,mgrade_no)
values('D_ruking','1234','앞잡이','교도소',to_date('1988.02.24','yyyy.mm.dd'),4,6);

--마일리지 거래 분류 테이블
drop table mileage_use_group;
create table mileage_use_group(
	mug_no varchar2(100) primary key,
	mug_name varchar2(100) not null
)

insert into mileage_use_group values('1','충전');
insert into mileage_use_group values('2','기부');
insert into mileage_use_group values('3','환전');

--마일리지 거래 테이블
drop table mileage_trade;
create table mileage_trade(
	mt_no number primary key,
	mt_volume number not null,
	mt_regdate date default sysdate,
	mug_no varchar2(100) not null,
	id varchar2(100) not null,
	CONSTRAINT fk_gt_mileage_mug FOREIGN KEY(mug_no) REFERENCES mileage_use_group(mug_no) ON DELETE CASCADE,
	CONSTRAINT fk_gt_mileage_id FOREIGN KEY(id) REFERENCES gt_member(id) ON DELETE CASCADE
)

--마일리지 거래 시퀀스
drop sequence mileage_trade_seq;
create sequence mileage_trade_seq;

insert into mileage_trade(mt_no,mt_volume,mug_no,id)
values(mileage_trade_seq.nextval,1000,'1','D_ruking');

--신청서 분류 테이블
drop table app_group;
create table app_group(
	ag_no varchar2(100) primary key,
	ag_name varchar2(100) not null
)

insert into app_group values('1','재능기부');
insert into app_group values('2','기부단체');

--신청서 테이블
drop table application;
create table application(
	app_no number primary key,
	app_title varchar2(100) not null,
	app_contents clob not null,
	app_place varchar2(100) not null,
	app_regdate date default sysdate,
	goal_mileage number not null,
	app_status varchar2(100) not null,
	start_date date not null,
	end_date date not null,
	app_parent_no number,
	id varchar2(100) not null,
	ag_no varchar2(100) not null,
	CONSTRAINT fk_gt_appliction_id FOREIGN KEY(id) REFERENCES gt_member(id) ON DELETE CASCADE,
	CONSTRAINT fk_gt_applictrion_ag_no FOREIGN KEY(ag_no) REFERENCES app_group(ag_no) ON DELETE CASCADE
)

--신청서 테이블 시퀀스
drop sequence application_seq;
create sequence application_seq;

--신청서 등록
insert into application(app_no,app_title,app_contents,app_place,goal_mileage,app_status,start_date,end_date,id,ag_no)
values(application_seq.nextval,'청소왕 황마의 청소 A to Z','여러분 청소가 참 쉽습니다. 저랑 같은조가 되시면 가위바위보를 질 수 있어요',
'판교',200000,'승인',to_date('2018.01.23','yyyy.mm.dd'),to_date('2018.06.08','yyyy.mm.dd'),'hwang','1');

insert into application(app_no,app_title,app_contents,app_place,goal_mileage,app_status,start_date,end_date,id,ag_no)
values(application_seq.nextval,'이윤희의 유니짜장','유니짜장은 재료만 잘게 다지면 됩니다!',
'판교',200000,'처리중',to_date('2018.01.23','yyyy.mm.dd'),to_date('2018.06.08','yyyy.mm.dd'),'banjang','1');

select *from application;

--선물 테이블
drop table present;
create table present(
	present_no number primary key,
	donation_mileage number not null,
	present_contents varchar2(100) not null,
	app_no number not null,
	CONSTRAINT fk_gt_persent_app_no FOREIGN KEY(app_no) REFERENCES application(app_no) ON DELETE CASCADE
)

--선물 시퀀스
drop sequence present_seq;
create sequence present_seq;

--선물 등록
insert into present values(present_seq.nextval,1000,'한 달 수강','1');
insert into present values(present_seq.nextval,2800,'세 달 수강','1');
insert into present values(present_seq.nextval,3500,'네 달 수강','1');

--첨부파일 테이블
drop table attachment;
create table attachment(
	ach_no number primary key,
	ach_directory varchar2(100) not null,
	ach_grade varchar2(100) not null,
	app_no number not null,
	CONSTRAINT fk_gt_attachment_app_no FOREIGN KEY(app_no) REFERENCES application(app_no) ON DELETE CASCADE
)

--첨부파일 시퀀스
drop sequence attachment_seq;
create sequence attachment_seq;

insert into attachment values(attachment_seq.nextval,'디렉토리1','메인',1);
insert into attachment values(attachment_seq.nextval,'디렉토리2','내용 이미지1',1);
insert into attachment values(attachment_seq.nextval,'디렉토리3','내용 이미지2',1);
insert into attachment values(attachment_seq.nextval,'디렉토리4','내용 이미지3',1);

--기부 게시글 테이블
drop table donation_post;
create table donation_post(
	dp_no number primary key,
	dp_title varchar2(100) not null,
	dp_contents clob not null,
	dp_regdate date default sysdate,
	dp_place varchar2(100) not null,
	dp_count number default 0,
	goal_mileage number not null,
	donation_mileage number default 0,
	total_entry number default 0,
	app_no number,
	CONSTRAINT fk_gt_donation_post_app_no FOREIGN KEY(app_no) REFERENCES application(app_no) ON DELETE CASCADE
)

--기부 게시글 시퀀스
drop sequence donation_post_seq;
create sequence donation_post_seq;

insert into donation_post(dp_no,dp_title,dp_contents,dp_place,goal_mileage,app_no)
values(donation_post_seq.nextval,'청소왕 황마의 청소 A to Z','여러분 청소가 참 쉽습니다. 저랑 같은조가 되시면 가위바위보를 질 수 있어요','판교',
200000,'1');

select * from donation_post;

update donation_post set donation_mileage=donation_mileage+1000 where dp_no='1';

--기부 참여 테이블
drop table take_donation;
create table take_donation(
	td_no number primary key,
	td_regdate date default sysdate,
	td_mileage number not null,
	cheerup_message varchar2(200) default '당신을 응원합니다',
	id varchar2(100) not null,
	dp_no number not null,
	CONSTRAINT fk_gt_take_donation_id FOREIGN KEY(id) REFERENCES gt_member(id) ON DELETE CASCADE,
	CONSTRAINT fk_gt_take_donation_dp_no FOREIGN KEY(dp_no) REFERENCES donation_post(dp_no) ON DELETE CASCADE
)

--기부 참여 테이블 시퀀스
drop sequence take_donation_seq;
create sequence take_donation_seq;

insert into take_donation(td_no,td_mileage,id,dp_no)
values(take_donation_seq.nextval,1000,'keroro',1);

select *from take_donation;

--후기 게시판 테이블
drop table review_post;
create table review_post(
	rp_no number primary key,
	rp_title varchar2(100) not null,
	rp_contents clob not null,
	rp_regdate date default sysdate,
	rp_rate number not null,
	id varchar2(100) not null,
	dp_no number not null,
	td_no number not null,
	CONSTRAINT fk_gt_review_post_id FOREIGN KEY(id) REFERENCES gt_member(id) ON DELETE CASCADE,
	CONSTRAINT fk_gt_review_post_dp_no FOREIGN KEY(dp_no) REFERENCES donation_post(dp_no) ON DELETE CASCADE,
	CONSTRAINT fk_gt_review_post_td_no FOREIGN KEY(td_no) REFERENCES take_donation(td_no) ON DELETE CASCADE
)

--후기 게시판 시퀀스
drop sequence review_post_seq;
create sequence review_post_seq;

insert into review_post(rp_no,rp_title,rp_contents,rp_rate,id,dp_no,td_no)
values(review_post_seq.nextval,'유익한 시간이었습니다.','청소의 전부를 모두 다 배운거 같아 뿌듯합니다. 가위바위보를 확실히 질 수 있을것 같아요!!',
8,'keroro',1,1);









