insert into users (birth_date, email, name, password, profile_url, sex, token) values ('890523', 'ekdxhrl0096@daum.net', '아이유1', '3bfb730ef7a648b784fb249e11b79cc1', 'http://52.78.120.152/profile/iu.jpg', '', '653ab858-ce05-4f29-9652-fa1f7b6ad1c8');
insert into users (birth_date, email, name, password, profile_url, sex, token) values ('890523', 'ekdxhrl@daum.net', '아이유2', '3bfb730ef7a648b784fb249e11b79cc1', 'http://52.78.120.152/profile/iu.jpg', '여', '44a6d1ff-a7ca-4f32-a419-76510d79532e');

INSERT INTO regions (description, name, notice) VALUES ("description 1", "Region 1", "notice 1!");
INSERT INTO regions (description, name, notice) VALUES ("description 2", "Region 2", "notice 2!");
INSERT INTO regions (description, name, notice) VALUES ("description 3", "Region 3", "notice 3!");

INSERT INTO user_region (region_id, user_id) VALUES (1, 1);
INSERT INTO user_region (region_id, user_id) VALUES (2, 1);
INSERT INTO user_region (region_id, user_id) VALUES (3, 2);

INSERT INTO category (type) VALUES ('HELP');
INSERT INTO category (type) VALUES ('HELLO');
INSERT INTO category (type) VALUES ('FREE');
INSERT INTO category (type) VALUES ('SHOPPING');
INSERT INTO category (type) VALUES ('LIGHTNING');

INSERT INTO article (article_main_image_url, category_id, contents, name, region_id, view_count, user_id, created_at) VALUES ('http://52.78.120.152/article/articleMainImageUrl.jpg', '1', 'article Contents 1', 'article Name 1', '1', '0', '1', '2016-08-21 16:27:33');
INSERT INTO article (article_main_image_url, category_id, contents, name, region_id, view_count, user_id, created_at) VALUES ('http://52.78.120.152/article/articleMainImageUrl.jpg', '2', 'article Contents 2', 'article Name 2', '1', '0', '1', '2016-08-21 16:27:33');
INSERT INTO article (article_main_image_url, category_id, contents, name, region_id, view_count, user_id, created_at) VALUES ('http://52.78.120.152/article/articleMainImageUrl.jpg', '3', 'article Contents 3', 'article Name 3', '1', '0', '1', '2016-08-21 16:27:33');
INSERT INTO article (article_main_image_url, category_id, contents, name, region_id, view_count, user_id, created_at) VALUES ('http://52.78.120.152/article/articleMainImageUrl.jpg', '4', 'article Contents 4', 'article Name 3', '1', '0', '1', '2016-08-21 16:27:33');
INSERT INTO article (article_main_image_url, category_id, contents, name, region_id, view_count, user_id, created_at) VALUES ('http://52.78.120.152/article/articleMainImageUrl.jpg', '5', 'article Contents 5', 'article Name 3', '1', '0', '1', '2016-08-21 16:27:33');
INSERT INTO article (article_main_image_url, category_id, contents, name, region_id, view_count, user_id, created_at) VALUES ('http://52.78.120.152/article/articleMainImageUrl.jpg', '5', 'article Contents 6', 'article Name 3', '1', '0', '1', '2016-08-21 16:27:33');
INSERT INTO article (article_main_image_url, category_id, contents, name, region_id, view_count, user_id, created_at) VALUES ('http://52.78.120.152/article/articleMainImageUrl.jpg', '1', 'article Contents 7', 'article Name 3', '1', '0', '1', '2016-08-21 16:27:33');

INSERT INTO comment (article_id, contents, created_at, user_id) VALUES ('1', 'Article 1 Comment', '2016-08-21 16:27:33', '1');
INSERT INTO comment (article_id, contents, created_at, user_id) VALUES ('1', 'Article 1 Comment', '2016-08-21 16:27:33', '2');
INSERT INTO comment (article_id, contents, created_at, user_id) VALUES ('1', 'Article 1 Comment', '2016-08-21 16:27:33', '1');
INSERT INTO comment (article_id, contents, created_at, user_id) VALUES ('1', 'Article 1 Comment', '2016-08-21 16:27:33', '2');
INSERT INTO comment (article_id, contents, created_at, user_id) VALUES ('1', 'Article 1 Comment', '2016-08-21 16:27:33', '2');
INSERT INTO comment (article_id, contents, created_at, user_id) VALUES ('1', 'Article 1 Comment', '2016-08-21 16:27:33', '1');