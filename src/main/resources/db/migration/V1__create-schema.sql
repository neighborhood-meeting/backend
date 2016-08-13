CREATE DATABASE neighborhood;

CREATE TABLE neighborhood.users (id VARCHAR(50) PRIMARY KEY, name VARCHAR(50))

create table neighborhood.category (id bigint not null auto_increment PRIMARY KEY, name VARCHAR(50))

INSERT INTO TABLE neighborhood.category values('자유글')
INSERT INTO TABLE neighborhood.category values('공구')
INSERT INTO TABLE neighborhood.category values('질문')
INSERT INTO TABLE neighborhood.category values('돈')
INSERT INTO TABLE neighborhood.category values('번개')