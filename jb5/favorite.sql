drop table if exists favorite;
create table favorite (
	id integer auto_increment,
	category_name varchar(50),
	favorite_url VARCHAR(200),
	site_name varchar(50),
	site_image_url VARCHAR(200),
	created timestamp default current_timestamp(),
	updated timestamp default current_timestamp() on update current_timestamp(),
	primary key(id)
);

INSERT INTO favorite VALUES(1, '교육', 'https://www.milkt.co.kr/', '밀크티', '', SYSDATE(), SYSDATE());
INSERT INTO favorite VALUES(2, '검색', 'https://www.naver.com', '네이버', '', SYSDATE(), SYSDATE());
INSERT INTO favorite VALUES(3, '쇼핑', 'https://www.11st.co.kr', '11번가', '', SYSDATE(), SYSDATE());
