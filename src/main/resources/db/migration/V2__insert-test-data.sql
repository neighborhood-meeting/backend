INSERT INTO users (birth_date, name, password, sex, token, user_id, profile_url) VALUES ("890523", "KimSungJin", "3bfb730ef7a648b784fb249e11b79cc1", 남", "e68e85be-3506-4f4d-a69c-e19408af2e63", "ekdxhrl", "ekdxhrl.jpg");

INSERT INTO region (description, name, notice) VALUES ("description", "룸1", "notice!");
INSERT INTO region (description, name, notice) VALUES ("description", "룸2", "notice!");
INSERT INTO region (description, name, notice) VALUES ("description", "룸3", "notice!");

INSERT INTO user_region (region_id, user_id) VALUES (1, 1);
INSERT INTO user_region (region_id, user_id) VALUES (2, 1);
INSERT INTO user_region (region_id, user_id) VALUES (3, 2);

INSERT INTO article (category_id, contents, creation_date, name, room_id, view_count, writer_id) VALUES ("1", "contents", "2016-08-17 22:32:38", "text 1", "1", "1", "1");
INSERT INTO article (category_id, contents, creation_date, name, room_id, view_count, writer_id) VALUES ("1", "contents", "2016-08-17 22:32:38", "text 2", "1", "12", "1");

INSERT INTO category (name) VALUES ("벙개");

INSERT INTO comment (article_id, contents, creation_date, user_id) VALUES ("1", "댓글1", "2016-08-17 22:32:38", "ekdxhrl")
INSERT INTO comment (article_id, contents, creation_date, user_id) VALUES ("1", "댓글2", "2016-08-17 22:32:38", "ekdxhrl")

insert into users (birth_date, email, name, password, profile_url, sex, token) values (?, ?, ?, ?, ?, ?, ?)