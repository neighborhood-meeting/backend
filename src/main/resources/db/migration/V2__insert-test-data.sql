INSERT INTO users (birth_date, name, password, region_id, room_id, sex, token, user_id) VALUES ("890523", "KimSungJin", "3bfb730ef7a648b784fb249e11b79cc1", "1", "1", "male", "e68e85be-3506-4f4d-a69c-e19408af2e63", "ekdxhrl");

INSERT INTO room (description, name, notice, owner_id, region_id) VALUES ("description", "room1", "notice!", "1", "1");
INSERT INTO room (description, name, notice, owner_id, region_id) VALUES ("description", "room2", "notice!", "1", "1");
INSERT INTO room (description, name, notice, owner_id, region_id) VALUES ("description", "room3", "notice!", "1", "2");

INSERT INTO article (category_id, contents, creation_date, name, room_id, view_count, writer_id) VALUES ("1", "contents", "2016-08-17 22:32:38", "text 1", "1", "1", "1");
INSERT INTO article (category_id, contents, creation_date, name, room_id, view_count, writer_id) VALUES ("1", "contents", "2016-08-17 22:32:38", "text 2", "1", "12", "1");

INSERT INTO category (name) VALUES ("Thunder");