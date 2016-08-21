insert into users (birth_date, email, name, password, profile_url, sex, token) values ('890523', 'ekdxhrl0096@daum.net', '김성진', '1234', 'http://52.78.120.152/김성진.jpg', '남', '653ab858-ce05-4f29-9652-fa1f7b6ad1c8');
insert into users (birth_date, email, name, password, profile_url, sex, token) values ('890523', 'ekdxhrl@daum.net', '김성진2', '1234', 'http://52.78.120.152/김성진.jpg', '남', '44a6d1ff-a7ca-4f32-a419-76510d79532e');

INSERT INTO regions (description, name, notice) VALUES ("description 1", "Region 1", "notice 1!");
INSERT INTO regions (description, name, notice) VALUES ("description 2", "Region 2", "notice 2!");
INSERT INTO regions (description, name, notice) VALUES ("description 3", "Region 3", "notice 3!");

INSERT INTO user_region (region_id, user_id) VALUES (1, 1);
INSERT INTO user_region (region_id, user_id) VALUES (2, 1);
INSERT INTO user_region (region_id, user_id) VALUES (3, 2);

INSERT INTO category (type) VALUES ('HELP');

INSERT INTO article (article_main_image, category_id, contents, name, region_id, view_count, user_id) VALUES ('http://52.78.120.152/articleMainImage.jpg', '1', 'article Contents 1', '2016-08-21 16:27:33', 'article Name 1', '1', '0', '1');
INSERT INTO article (article_main_image, category_id, contents, name, region_id, view_count, user_id) VALUES ('http://52.78.120.152/articleMainImage.jpg', '1', 'article Contents 2', '2016-08-21 16:27:33', 'article Name 2', '1', '0', '1');
INSERT INTO article (article_main_image, category_id, contents, name, region_id, view_count, user_id) VALUES ('http://52.78.120.152/articleMainImage.jpg', '1', 'article Contents 3', '2016-08-21 16:27:33', 'article Name 3', '1', '0', '1');