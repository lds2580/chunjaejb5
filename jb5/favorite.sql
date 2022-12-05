drop table if exists favorite;
create table favorite (
	id integer auto_increment,
	favoriteUrl varchar(500),
	nickname varchar(100),
	created timestamp default current_timestamp(),
	updated timestamp default current_timestamp() on update current_timestamp(),
	primary key(id)
);

INSERT INTO favorite(id, favoriteUrl, nickname, created, updated) VALUES(1, 'http://www.naver.com', '네이버', SYSDATE(), SYSDATE());
INSERT INTO favorite(id, favoriteUrl, nickname, created, updated) VALUES(2, 'http://www.google.com', '구글', SYSDATE(), SYSDATE());
INSERT INTO favorite(id, favoriteUrl, nickname, created, updated) VALUES(3, 'http://www.daum.net', '다음', SYSDATE(), SYSDATE());